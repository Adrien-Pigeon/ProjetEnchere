package fr.eni.projetEnchere.dal;




import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;


public interface CategorieDAO {

	
	// Methode CategorieDAOImpl
	public List<Categorie> lister() throws DalException; 
	public Categorie selectParId(int noCategorie) throws DalException;
	
	
	

}