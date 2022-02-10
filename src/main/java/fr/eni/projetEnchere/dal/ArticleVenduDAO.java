package fr.eni.projetEnchere.dal;

import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.dal.Exception.DalException;

public interface ArticleVenduDAO {

	public List<ArticleVendu> selectAll() throws DalException;
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DalException;
	public List<ArticleVendu> selectByName(String motRech) throws DalException;
	public List<ArticleVendu> selectByUtilisateurs(int no_utilisateur) throws DalException;
	public void insertArticle(ArticleVendu article) throws DalException;
	public List<ArticleVendu> selectByFiltres(String motRech,int noCategorie) throws DalException;
	public ArticleVendu selectById(int id) throws DalException;
	public ArticleVendu detailVente(int noArticle) throws DalException;
	public List<ArticleVendu> selectArticleByUser(int id)throws DalException;
}
