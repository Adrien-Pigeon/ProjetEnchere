package fr.eni.projetEnchere.dal;



public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO(){
		return new UtilisateurDAOImpl();
	}
}
 