package fr.eni.projetEnchere.bo;

import java.time.LocalDate;


public class Enchere {

	private LocalDate dateEnchere;
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
	public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu article) {
		super();
		this.setDateEnchere(dateEnchere);
		this.setMontantEnchere(montantEnchere);
		this.setUtilisateur(utilisateur);
		this.setArticle(article);
	}

	//assesseurs et mutateurs 
	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
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
