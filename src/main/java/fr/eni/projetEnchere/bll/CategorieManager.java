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

	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	
	public List<Categorie> lister() throws DalException {
        List<Categorie> categorie = new ArrayList<>();
        CategorieDAO cg = DAOFactory.getCategorieDAO();
        categorie = cg.lister();
        return categorie;
	}
	
	
	public void ajouter(String libelle) throws BllException, DalException {
		Categorie cg = new Categorie(libelle);
		
		CategorieDAO dao = DAOFactory.getCategorieDAO();
		dao.ajouter(libelle);
	}
	
	
	public Categorie selectParNumero(int noCategorie) throws BllException, DalException{
		Categorie no_categorie = new Categorie(noCategorie);
		
		CategorieDAO dao = DAOFactory.getCategorieDAO();
		dao.selectParNumero(noCategorie);
		return no_categorie;
	}
	
	
	public Categorie selectParId(int noCategorie) throws BllException{
		return null;
	}
}