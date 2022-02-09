package fr.eni.projetEnchere.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ArticleVendu {

	private int noArticle;
	private String nomArticle,description;
	private LocalDate dateDebutEncheres,dateFinEncheres;
	private int prixInitial,prixVente;
	private String utilisateurPseudo;
	private Categorie categorie;
	private Utilisateur utilisateur;
	
	
	public ArticleVendu() {
		
	}
	

	

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Categorie categorie, Utilisateur utilisateur) {
		super();
	
		this.setNomArticle(nomArticle);
		this.setDescription(description);
		this.setDateDebutEncheres(dateDebutEncheres);
		this.setDateFinEncheres(dateFinEncheres);
		this.setCategorie(categorie);
		this.setUtilisateur(utilisateur);
	}



	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}




	public String getUtilisateurPseudo() {
		return utilisateurPseudo;
	}




	public void setUtilisateurPseudo(String utilisateurPseudo) {
		this.utilisateurPseudo = utilisateurPseudo;
	}




	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", utilisateurPseudo=" + utilisateurPseudo + ", categorie="
				+ categorie + ", utilisateur=" + utilisateur + ", getNoArticle()=" + getNoArticle()
				+ ", getNomArticle()=" + getNomArticle() + ", getDescription()=" + getDescription()
				+ ", getDateDebutEncheres()=" + getDateDebutEncheres() + ", getDateFinEncheres()="
				+ getDateFinEncheres() + ", getPrixInitial()=" + getPrixInitial() + ", getPrixVente()=" + getPrixVente()
				+ ", getCategorie()=" + getCategorie() + ", getUtilisateur()=" + getUtilisateur()
				+ ", getUtilisateurPseudo()=" + getUtilisateurPseudo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
