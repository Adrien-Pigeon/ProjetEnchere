package fr.eni.projetEnchere.dal;

import java.util.List;


import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;

public interface CategorieDAO {

	public List<ArticleVendu> selectAll();	
	
	
	
}
