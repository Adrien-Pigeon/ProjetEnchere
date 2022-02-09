package fr.eni.projetEnchere.dal;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.eni.projetEnchere.bo.Enchere;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class EnchereDAOImpl implements EnchereDAO {
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,"
			+ " montant_enchere) VALUES(?,?,?,?);";
	private static final String UPDATE_ENCHERE = "UPDATE ENCHERE SET date_enchere = ? AND montant_enchere = ? "
			+ "WHERE no_utilisateur = ? AND no_article = ?; ";
	private static final String DELETE_ENCHERE = "UPDATE ENCHERE SET date_enchere = ? AND montant_enchere = ? "
			+ "WHERE no_utilisateur = ? AND no_article = ?; ";
	
	private static final String ENCHERES_OUVERTES ="SELECT FROM ENCHERES;";
	
	private static final String ENCHERES_EN_COURS="SELECT FROM ENCHERES;";
	
	private static final String ENCHERES_REMPORTES="SELECT nom_article, article_vendu.description, prix_vente, prix_initial, date_fin_encheres, acheteur.pseudo as acheteur, \r\n"
			+ "																				  vendeur.pseudo as vendeur, retrait.rue, retrait.code_postal, retrait.ville	 \r\n"
			+ "				FROM ARTICLES_VENDUS article_vendu INNER JOIN UTILISATEURS vendeur\r\n"
			+ "				ON article_vendu.no_utilisateur = vendeur.no_utilisateur\r\n"
			+ "\r\n"
			+ "					INNER JOIN RETRAITS retrait ON article_vendu.no_article = retrait.no_article \r\n"
			+ "					INNER JOIN ENCHERES enchere ON article_vendu.no_article = enchere.no_article\r\n"
			+ "					INNER JOIN UTILISATEURS acheteur ON acheteur.no_utilisateur = enchere.no_utilisateur  \r\n"
			+ "\r\n"
			+ "				WHERE article_vendu.no_utilisateur = ?;";

	@Override
	public void insertEnchere(Enchere enchere) throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(INSERT_ENCHERE);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			pstmt.setObject(3, LocalDate.now());
			pstmt.setInt(4,enchere.getMontantEnchere());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la methode insertEnchere()",e);
		}
		
	}

	@Override
	public void updateEnchere(Enchere enchere)throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		
			try {
				cnx = ConnectionProvider.getConnection();
				pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
				pstmt.setObject(1,LocalDate.now());
				pstmt.setInt(2, enchere.getMontantEnchere());
				pstmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
				pstmt.setInt(4, enchere.getArticle().getNoArticle());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme sur la methode updateEnchere()",e);
			}
		
	}

	@Override
	public void deleteEnchere(Enchere enchere)throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		
			try {
				cnx = ConnectionProvider.getConnection();
				pstmt = cnx.prepareStatement(DELETE_ENCHERE);
				pstmt.setObject(1,LocalDate.now());
				pstmt.setInt(2, enchere.getMontantEnchere());
				pstmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
				pstmt.setInt(4, enchere.getArticle().getNoArticle());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme sur la methode deleteEnchere()",e);
			}
		
	}
	
	@Override
	public void remporterEnchere(Enchere enchere) throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(ENCHERES_REMPORTES);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			pstmt.setObject(3, LocalDate.now());
			pstmt.setInt(4,enchere.getMontantEnchere());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la methode insertEnchere()",e);
		}
		
	}
	

	@Override
	public void enchereOuverte(Enchere enchere) throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(ENCHERES_OUVERTES);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			pstmt.setObject(3, LocalDate.now());
			pstmt.setInt(4,enchere.getMontantEnchere());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la methode insertEnchere()",e);
		}
		
	}

	@Override
	public void enchereEnCours(Enchere enchere) throws DalException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(ENCHERES_EN_COURS);
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			pstmt.setObject(3, LocalDate.now());
			pstmt.setInt(4,enchere.getMontantEnchere());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la methode insertEnchere()",e);
		}
		
	}
	


	

}
