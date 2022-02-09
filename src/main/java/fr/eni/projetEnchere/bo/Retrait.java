package fr.eni.projetEnchere.bo;

public class Retrait {

	
	


	private String rue,codePostal,ville;
	
	private ArticleVendu article ;
	
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
	}
	
	
	public Retrait() {
		
	}

	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public ArticleVendu getArticle() {
		return article;
	}


	public void setArticle(ArticleVendu article) {
		this.article = article;
	}


	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", article=" + article
				+ ", getRue()=" + getRue() + ", getCodePostal()=" + getCodePostal() + ", getVille()=" + getVille()
				+ ", getArticle()=" + getArticle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
