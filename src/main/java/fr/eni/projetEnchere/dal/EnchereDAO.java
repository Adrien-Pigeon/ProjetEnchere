package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface EnchereDAO {

	public void insertEnchere(Enchere enchere) throws DalException;
	public void updateEnchere(Enchere enchere) throws DalException;
	
	
	
}
