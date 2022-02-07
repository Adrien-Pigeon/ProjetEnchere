package fr.eni.projetEnchere.bll;
import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.EnchereDAO;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class EnchereManager {

	private static EnchereManager instance;

	private EnchereManager() {

	}
	// SINGLETON

	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	public void insertEnchere(Enchere enchere) throws DalException {
		EnchereDAO dao = DAOFactory.getEnchereDAO();
		dao.insertEnchere(enchere);
	}

	public void updateEnchere(Enchere enchere) throws DalException {
		EnchereDAO dao = DAOFactory.getEnchereDAO();
		dao.updateEnchere(enchere);
	}

	public void deleteEnchere(Enchere enchere) throws DalException {
		EnchereDAO dao = DAOFactory.getEnchereDAO();
		dao.deleteEnchere(enchere);
	}
}
