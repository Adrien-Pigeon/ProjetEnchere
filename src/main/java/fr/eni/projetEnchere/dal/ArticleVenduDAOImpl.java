package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	private static final String SELECT_ALL = "SELECT nom_article,description,prix_vente,,date_debut_encheres,date_fin_encheres"
			+ "no_categorie,pseudo"
			+ "FROM ARTICLES_VENDUS as a JOIN UTILISATEURS as u on(a.no_utilisateur = u.no_utilisateur)";

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,"
			+ " date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) "
			+ "values (?, ?, ?, ?, ?, ?, ?,?);";

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
			while (rs.next()) {
				;
			}

		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		}finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
	}

	@Override
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DalException {

		return null;
	}

	@Override
	public List<ArticleVendu> selectByUtilisateurs(int no_utilisateur) throws DalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticle(ArticleVendu article) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(INSERT_ARTICLE,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()) );
			pstmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5,article.getPrixInitial());
			pstmt.setInt(6,article.getPrixVente());
			pstmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, article.getCategorie().getNoCategorie());
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}

	}

}
