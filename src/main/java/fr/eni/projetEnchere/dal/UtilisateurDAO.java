package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur user) throws DalException;
<<<<<<< HEAD
	public boolean selectByLogin(Utilisateur user) throws DalException;
=======
	public Utilisateur selectByLogin(Utilisateur user) throws DalException;
	public Utilisateur selectById(int noArticle) throws DalException;
>>>>>>> branch 'main' of https://github.com/OnlyDukeTV/ProjetEnchere.git
	

}
 
