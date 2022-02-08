package fr.eni.projetEnchere.bll;

import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.ArticleVenduDAO;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class ArticleVenduManager {

	private static ArticleVenduManager instance;

	private ArticleVenduManager() {

	}
	// SINGLETON

	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	
	public void ajouterArticle(ArticleVendu article) throws DalException, BllException {
		ArticleVenduDAO dao = DAOFactory.getArticleVenduDAO();
		verifierArticle(article);
		dao.insertArticle(article);
	}
	
	public static Boolean verifierArticle(ArticleVendu a) throws BllException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		if (a == null) {
			throw new BllException("Article null");
		}
		if (a.getNomArticle() == null || a.getNomArticle().trim().length() == 0) {
			sb.append("Lenom de l'article est obligatoire.\n");
			valide = false;
		}
		if (a.getNomArticle() == null || a.getNomArticle().trim().length() == 0) {
			sb.append("La description est obligatoire.\n");
			valide = false;
		}

		if (a.getDateDebutEncheres().isAfter(a.getDateFinEncheres())) {
			sb.append("La date de fin d'enchere ne peut etre anterieur a la date de debut d'enchere.\n");
			valide = false;
		}
		if (a.getCategorie() == null) {
			sb.append("La categorie obligatoire.\n");
			valide = false;
		}
		if(a.getPrixInitial() > a.getPrixVente()) {
			sb.append("Le prix de vente ne peut pas etre inferieur au prix initial.\n");
			valide = false;
		}
		if(!valide) {
			throw new BllException(sb.toString());
		}
		return true;
	}

}
