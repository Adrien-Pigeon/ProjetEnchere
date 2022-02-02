package fr.eni.projetEnchere.bll;


import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.UtilisateurDAO;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class UtilisateurManager {
	

	private static UtilisateurManager instance;
	
	private UtilisateurManager() { 
		
		
	}
	
	public static UtilisateurManager getInstance() {
		if(instance==null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	
	public void addUser(Utilisateur user) throws BllException {
		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();
		
		try {
			//verifier l'objet utilisateur
			verifierUser(user);
			//ajouter l'article � la base de donn�e
			ud.insert(user);
		} catch (DalException e) {
			throw new BllException("Probleme sur la methode addUser()");
		}
	}
	
	public static void verifierUser(Utilisateur u) throws BllException {
		boolean valide = true;
		StringBuffer sb = new StringBuffer();
		if (u == null) {
			throw new BllException("Utilisateur null");
		}
			
			if (u.getPseudo() == null || u.getPseudo().trim().length() == 0) {
				sb.append("Le pseudo est obligatoire.\n");
				valide = false;
			}
			if (u.getNom() == null || u.getNom().trim().length() == 0) {
				sb.append("Le nom est obligatoire.\n");
				valide = false;
			}

			if (u.getVille() == null || u.getVille().trim().length() == 0) {
				sb.append("La ville est obligatoire.\n");
				valide = false;
			}
			if (u.getRue() == null || u.getRue().trim().length() == 0) {
				sb.append("La rue est obligatoire.\n");
				valide = false;
			}
			if (u.getCodePostal() == null || u.getCodePostal().trim().length() == 0) {
				sb.append("Le code postal est obligatoire.\n");
				valide = false;
			}

			if (u.getPrenom() == null || u.getPrenom().trim().length() == 0) {
				sb.append("Le prenom est obligatoire.\n");
				valide = false;
			}
			if (u.getEmail() == null || u.getEmail().trim().length() == 0) {
				sb.append("La rue est obligatoire.\n");
				valide = false;
			}
			if (u.getMotDePasse() == null || u.getMotDePasse().trim().length() == 0) {
				sb.append("Le mot de passe est obligatoire.\n");
				valide = false;
			}

			if (!valide) {
				throw new BllException(sb.toString());
			}
		
	}
	
	public boolean login(Utilisateur user) throws BllException {
		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();
		boolean OK = false;
		try {
			 OK =  ud.selectByLogin(user);
		} catch (DalException e) {
			throw new BllException("Probleme sur la methode logins()");
		}return OK;
	}
	
}
