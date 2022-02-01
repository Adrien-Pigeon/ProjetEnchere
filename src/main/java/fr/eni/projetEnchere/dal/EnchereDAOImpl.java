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

	

}
