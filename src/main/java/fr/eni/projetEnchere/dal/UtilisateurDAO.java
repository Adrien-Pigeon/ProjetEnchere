package fr.eni.projetEnchere.dal;

import fr.eni.projetEnchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur user);
	public boolean selectByLogin(Utilisateur user);

}
 
