package fr.eni.projetEnchere.bo;

import java.util.Date;

public class Enchere {

	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur utilisateur;
	private ArticleVendu article;

	/**
	 * constructeur vide de l'objet enchere
	 */
	public Enchere() {
		super();
	}

	/**
	 * Constructeur surchargé permettant d'instancier l'objet enchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param utilisateur
	 * @param article
	 */
	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}

	//assesseurs et mutateurs 
	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
