package fr.eni.projetEnchere.dal;



public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO(){
		return new UtilisateurDAOImpl();
	}
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	public static RetraitDAO getRetraitDAO(){
		return new RetraitDAOImpl();
	}
}
 
