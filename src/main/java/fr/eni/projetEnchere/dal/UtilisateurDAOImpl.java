package fr.eni.projetEnchere.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Utilisateur;


public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	
	private final static String INSERT_USER = "INSERT INTO dbo.UTILISATEURS (prenom,nom,email,mot_de_passe) VALUES(?,?,?,?)"; 
	private final static String SELECT_LOGIN = "SELECT * FROM dbo.UTILISATEURS WHERE email = ?   AND mot_de_passe = ?";
	private final static String RECHERCHER = " SELECT * FROM dbo.UTILISATEURS WHERE email = ? OR pseudo = ? AND mot_de_passe = ?";
	Connection cnx = null;
	PreparedStatement stmt =null;
	ResultSet rs=null;
	Utilisateur user = null; 
	
	
	
	@Override
	public void insert(Utilisateur user) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT_USER);
			stmt.setString(1, user.getPrenom());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
			stmt.executeUpdate();
			stmt.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean selectByLogin(Utilisateur user) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(SELECT_LOGIN);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			ResultSet result =  stmt.executeQuery();
			if(result.next()) {
				user.setNoUtilisateur(result.getInt("id"));
				user.setNom(result.getString("nom"));
				user.setPrenom(result.getString("prenom"));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
