package fr.eni.projetEnchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bll.Exception.BllException;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.CategorieDAO;
import fr.eni.projetEnchere.dal.DAOFactory;
import fr.eni.projetEnchere.dal.Exception.DalException;


public class CategorieManager {
	
	
	private static CategorieManager instance;

	private CategorieManager() {

	}
	// SINGLETON

	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	// Appel CategorieDAO qui redirige vers CategorieDAOImpl
	
	public List<Categorie> lister() throws DalException {
        List<Categorie> categorie = new ArrayList<>();
        CategorieDAO cg = DAOFactory.getCategorieDAO();
        categorie = cg.lister();
        return categorie;
	}
	
	
	public Categorie selectParId(String libelle) throws BllException, DalException{
		Categorie no_categorie = new Categorie();
		
		CategorieDAO dao = DAOFactory.getCategorieDAO();
		dao.selectParId(libelle);
		return no_categorie;
	}
	
}
	
