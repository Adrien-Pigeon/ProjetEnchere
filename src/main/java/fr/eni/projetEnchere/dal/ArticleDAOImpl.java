package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class ArticleDAOImpl implements ArticleVenduDAO{
	
	private static final String SELECT_ALL = "SELECT no_article, nom_article,pseudo,prix_vente,date_fin_encheres"
			+ "FROM ARTICLES_VENDUS as a JOIN UTILISATEURS as u on(a.no_utilisateur = u.no_utilisateur)";

	@Override
	public void selectAll() throws DalException {
		Connection cnx = null;
		Statement stmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		}
	}

	@Override
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DalException{
		
		
		return null;
	}

	@Override
	public List<ArticleVendu> selectByUtilisateurs(int no_utilisateur) throws DalException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticle(ArticleVendu article) throws DalException{
		// TODO Auto-generated method stub
		
	}

}
