package fr.eni.projetEnchere.bo;

import java.util.List;

public class Utilisateur {

	// Attributs privé

	private int noUtilisateur;
	private String nom, prenom, email, telephone, rue, codePostal, ville, motDePasse;
	private int credit;
	private boolean administrateur;

	// List
	private List<Enchere> encheres;
	private List<ArticleVendu> achete;
	private List<ArticleVendu> vend;

	private String pseudo;

	// Constructeur par defaut
	public Utilisateur() {

	}


	// Constructeur Surchargï¿½ de Utilisateur
	public Utilisateur(String Pseudo,String nom, String prenom, String email, String telephone, String rue, String codePostal,
			String ville, String motDePasse, int credit, boolean administrateur) {
		super();
		this.setPseudo(Pseudo);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setMotDePasse(motDePasse);
		this.setCredit(credit);
		this.setAdministrateur(administrateur);
	}

	// Constructeur Surchargï¿½ de Utilisateur
	public Utilisateur(int noUtilisateur,String Pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		super();
		this.setNom(nom);
		this.setPseudo(Pseudo);
		this.setNoUtilisateur(noUtilisateur);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setMotDePasse(motDePasse);
		this.setCredit(credit);
		this.setAdministrateur(administrateur);
	}

	// Accesseurs et Mutateurs

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public List<ArticleVendu> getAchete() {
		return achete;
	}

	public void setAchete(List<ArticleVendu> achete) {
		this.achete = achete;
	}

	public List<ArticleVendu> getVend() {
		return vend;
	}

	public void setVend(List<ArticleVendu> vend) {
		this.vend = vend;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return getMotDePasse();
	}


	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + ", motDePasse=" + motDePasse + ", credit=" + credit + ", administrateur=" + administrateur
				+ ", encheres=" + encheres + ", achete=" + achete + ", vend=" + vend + ", pseudo=" + pseudo + "]";
	}
	

}
