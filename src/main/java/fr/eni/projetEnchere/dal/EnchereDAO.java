package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface EnchereDAO {

	public void insertEnchere(Enchere enchere) throws DalException;
	public void updateEnchere(Enchere enchere) throws DalException;
	public void deleteEnchere(Enchere enchere) throws DalException;
	void remporterEnchere(Enchere enchere) throws DalException;
	void enchereOuverte(Enchere enchere) throws DalException;
	void enchereEnCours(Enchere enchere) throws DalException;
	
	
	
}
