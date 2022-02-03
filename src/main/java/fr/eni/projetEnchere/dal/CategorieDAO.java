package fr.eni.projetEnchere.dal;




import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;


public interface CategorieDAO {

	public List<Categorie> lister() throws DalException;
	public Categorie selectParId(String libelle) throws DalException;
	
	
	

}