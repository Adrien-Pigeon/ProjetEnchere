package fr.eni.projetEnchere.dal;



import java.util.ArrayList;

import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.dal.Exception.DalException;


public interface CategorieDAO {

	public ArrayList<Categorie> lister() throws DalException;
	public void ajouter(String libelle) throws DalException;
	public Categorie selectParNumero(int noCategorie) throws DalException;
	public Categorie selectParId(int noCategorie) throws DalException;
	
	

}