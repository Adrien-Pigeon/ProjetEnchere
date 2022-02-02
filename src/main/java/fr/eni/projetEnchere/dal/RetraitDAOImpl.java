package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Retrait;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class RetraitDAOImpl implements RetraitDAO {

	private static final String INSERT_RETRAIT = "INSERT INTO RETRAIT(ville,rue,code_postal) VALUES (?,?,?)";
	private static final String SELECT_RETRAIT = "SELECT ville,rue,code_postal FROM RETRAIT WHERE no_article = ?";

	public void insertRetrait(Retrait retrait) throws DalException {

		Connection cnx = null;
		PreparedStatement pstmt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(INSERT_RETRAIT);
			pstmt.setString(1, retrait.getVille());
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DalException("Probleme sur la methode insertRetrait", e);
		} finally {
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de déconnexion", e);
			}
		}

	}

	public Retrait SelectByNoArticle(int noArticle) throws DalException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		Retrait retrait = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(SELECT_RETRAIT);
			pstmt.setInt(1,noArticle);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				retrait = new Retrait();
					retrait.setVille(rs.getString("ville"));
					retrait.setRue(rs.getString("rue"));
					retrait.setCodePostal(rs.getString("code_postal"));
			}
		}catch(SQLException e){
			throw new DalException("Probleme sur la methode SelectByNoArticle",e);
		}finally{
			try {
				pstmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de déconnexion", e);
			}
		}
		return retrait;	
	}

}
