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
import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	private static final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS as a JOIN UTILISATEURS as u on(a.no_utilisateur = u.no_utilisateur) WHERE date_fin_encheres >= CAST(FLOOR(CAST(getdate() as float)) as datetime) order by date_fin_encheres;";

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,"
			+ " date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) "
			+ "values (?, ?, ?, ?, ?, ?, ?,?);";
	private static final String SELECT_BY_CATEGORIE = "select description,prix_vente,av.no_article,nom_article,\n"
			+ "					prix_initial,date_debut_encheres,pseudo,date_fin_encheres from UTILISATEURS as u\n"
			+ "					\n"
			+ "					RIGHT JOIN ARTICLES_VENDUS as av on (u.no_utilisateur = av.no_utilisateur) WHERE no_categorie = ? AND date_fin_encheres >= CAST(FLOOR(CAST(getdate() as float)) as datetime) order by date_fin_encheres;";
	private final static String SELECT_BY_NAME = "select no_article,nom_article,description,date_fin_encheres,prix_initial, prix_vente, pseudo,date_debut_encheres "
			+ "from ARTICLES_VENDUS "
			+ "LEFT JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur where nom_article LIKE ? AND date_fin_encheres >= CAST(FLOOR(CAST(getdate() as float)) as datetime) order by date_fin_encheres;";
	private final static String SELECT_BY_FILTRE = "select no_article,nom_article,description,date_fin_encheres,prix_initial, prix_vente, pseudo,"
			+ "date_debut_encheres from ARTICLES_VENDUS LEFT JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
			+ "where nom_article LIKE ? AND no_categorie = ? AND date_fin_encheres >= CAST(FLOOR(CAST(getdate() as float)) as datetime) order by date_fin_encheres;";
	
	private final static String SELECT_BY_ID = "select * from ARTICLES_VENDUS as av INNER JOIN UTILISATEURS as u "
			+ "ON av.no_utilisateur = u.no_utilisateur where av.no_article = ?;";


	@Override
	public List<ArticleVendu> selectAll() throws DalException {
		Connection cnx = null;
		Statement stmt = null;
		List<ArticleVendu> articles = new ArrayList<>();

		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setDescription(rs.getString("description"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setDateFinEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setUtilisateurPseudo(rs.getString("pseudo"));
				articles.add(article);
			}

		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return articles;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(int no_categorie) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		ArticleVendu article = null;

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			pstmt.setInt(1, no_categorie);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				article = new ArticleVendu();
				
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setDescription(rs.getString("description"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setDateFinEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setUtilisateurPseudo(rs.getString("pseudo"));
				articles.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return articles;
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
			pstmt = cnx.prepareStatement(INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			pstmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, article.getCategorie().getNoCategorie());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}

	}

	@Override
	public List<ArticleVendu> selectByName(String motRech) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_NAME);
			pstmt.setString(1, "%" + motRech + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setDescription(rs.getString("description"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setDateFinEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setUtilisateurPseudo(rs.getString("pseudo"));
				articles.add(article);
			}
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return articles;
	}

	@Override
	public List<ArticleVendu> selectByFiltres(String motRech,int noCategorie) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_FILTRE);
			pstmt.setString(1, "%" + motRech + "%");
			pstmt.setInt(2,noCategorie);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateurPseudo(rs.getString("pseudo"));
				articles.add(article);
			}
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return articles;
	}


	@Override
	public ArticleVendu selectById(int id) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
				article.setDateFinEncheres(rs.getDate("date_debut_encheres").toLocalDate());
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				// article.getUtilisateur().setPseudo("pseudo");
				return article;
			}
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche dal", e);
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return null;
	}

}
