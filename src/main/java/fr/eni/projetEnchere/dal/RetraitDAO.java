package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface RetraitDAO {

	public void insertRetrait(Retrait retrait) throws DalException;
	public Retrait SelectByNoArticle(int no_article) throws DalException;
}
