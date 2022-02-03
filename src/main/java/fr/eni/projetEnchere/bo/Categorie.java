package fr.eni.projetEnchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	
	private int noCategorie;
	private String libelle;
	private List<ArticleVendu> articles;
	
	public Categorie( ) {				
		
	}
	
	public Categorie(String libelle) {				
		this.setLibelle(libelle);
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getArticles() {
		return articles;
	}

	public void ajouterArticle(ArticleVendu articles) {
		this.articles.add(articles);
	}

	public List<Categorie> lister() {
		 List<Categorie> liste_categorie = new ArrayList<Categorie>();
//		 liste_categorie.add("Toutes");
//		 liste_categorie.add("Ameublement");
//		 liste_categorie.add("Sport&Loisir");
	        return liste_categorie;
	}
	
	
	
	
}
