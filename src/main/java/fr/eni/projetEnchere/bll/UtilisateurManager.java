package fr.eni.projetEnchere.bll;


import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.UtilisateurDAO;

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
	
	public void addUser(String prenom,String nom, String username,String password) {
		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();
		Utilisateur user =new Utilisateur(nom, prenom, username, password);
		ud.insert(user);
	}
	
	public boolean login(Utilisateur user) {
		UtilisateurDAO ud = DAOFactory.getUtilisateurDAO();
		return ud.selectByLogin(user);
	}
	
}
