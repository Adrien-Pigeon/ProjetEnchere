package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface ArticleVenduDAO {

	public void selectAll() throws DalException;
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DalException;
	public List<ArticleVendu> selectByDescription(String motRech) throws DalException;
	public List<ArticleVendu> selectByUtilisateurs(int no_utilisateur) throws DalException;
	public void insertArticle(ArticleVendu article) throws DalException;
	public List<ArticleVendu> selectByRecherche(String motRech) throws DalException;
	public List<ArticleVendu> selectByFiltre(String motRech) throws DalException;
	public ArticleVendu selectById(int id) throws DalException;
}
