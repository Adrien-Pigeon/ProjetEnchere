package fr.eni.projetEnchere.dal;




import java.util.List;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;


public interface CategorieDAO {

	public List<Categorie> lister() throws DalException;
	public void ajouter(String libelle) throws DalException;
	public Categorie selectParNumero(int noCategorie) throws DalException;
	public Categorie selectParId(int noCategorie) throws DalException;
	void delete(int no_categorie) throws DalException;
	
	

}