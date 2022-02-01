package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projetEnchere.bo.ArticleVendu;
import fr.eni.projetEnchere.bo.Categorie;
import fr.eni.projetEnchere.bo.Utilisateur;


public class CategorieDAOImpl implements CategorieDAO {

	private final static String INSERT_ARTICLES = "INSERT INTO ARTICLES_VENDUS (noArticle,"
			+ "nomArticle,description,dateDebutEncheres,dateFinEncheres,prixInitial,prixVente,"
			+ "noUtilisateur,noCategorie) VALUES (?,?,?,?,?,?,?,?,?);";
	
	private final static String INSERT_CATEGORIES = "INSERT INTO CATEGORIES (noArticle,nomArticle,"
			+ "description,dateDebutEncheres,dateFinEncheres,prixInitial,"
			+ "prixVente,noUtilisateur,noCategorie) VALUES(?,?,?,?,?,?,?,?,?)";
	
	private final static String SELECT_ALL = "select no_article,av.no_utilisateur,"
			+ "nom_article, prix_vente,date_fin_encheres,nom From ARTICLES_VENDUS as av \r\n"
			+ "join UTILISATEURS as u on(av.no_utilisateur = u.no_utilisateur)";



	
	
	@Override
	public List<ArticleVendu> selectAll() {
		List<ArticleVendu>  liste_articles = new ArrayList<>();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			int oldId = 0;
			ArticleVendu article= new ArticleVendu();
			while(rs.next()) {
				if(rs.getInt("no_categorie")!= oldId) { // current id
					oldId = rs.getInt("no_categorie");
					// new article				
					article = new ArticleVendu();
							
					liste_articles.add(article);
				}
				// ajouter les articles
				article.getNoArticle().add(new ArticleVendu(rs.getInt("no_article"), rs.getString("article"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste_articles;
	}
	
	
	
	
	@Override
	public void insert(ArticleVendu articles) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT_ARTICLES);
			stmt.setInt(1, articles.getNoArticle());
			stmt.setString(2,articles.getNomArticle());
			stmt.setString(3,articles.getDescription());
			stmt.setDate(4,(Date) articles.getDateDebutEncheres());
			stmt.setDate(5,(Date) articles.getDateFinEncheres());
			stmt.setInt(6,articles.getPrixInitial());
			stmt.setInt(7,articles.getPrixVente());
			stmt.setInt(8,articles.getUtilisateur());
			stmt.setInt(9,articles.getCategorie());
			
			stmt.executeUpdate();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	@java.lang.Override
	public void insert(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}




	

}
