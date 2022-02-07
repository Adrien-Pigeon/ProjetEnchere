package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class ArticleVenduDAOImpl implements ArticleVenduDAO{
	
	private static final String SELECT_ALL = "SELECT nom_article,description,prix_vente,,date_debut_encheres,date_fin_encheres"
			+ "no_categorie,pseudo"
			+ "FROM ARTICLES_VENDUS as a JOIN UTILISATEURS as u on(a.no_utilisateur = u.no_utilisateur)";

	@Override
	public void selectAll() throws DalException {
		Connection cnx = null;
		Statement stmt = null;
		List<ArticleVendu> articles = new ArrayList<>();
		
		
		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			ArticleVendu article;
			while(rs.next()) {
				;
			}
			
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
