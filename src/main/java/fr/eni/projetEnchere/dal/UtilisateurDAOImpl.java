package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String INSERT_USER = "INSERT INTO dbo.UTILISATEURS (prenom,nom,pseudo,email,mot_de_passe,telephone,"
			+ "ville,rue,code_postal,credit,admministrateur) VALUES(?,?,?,?)";
	private final static String SELECT_LOGIN = "SELECT * FROM dbo.UTILISATEURS WHERE pseudo = ?  AND mot_de_passe = ?";
	private final static String SELET_BY_ID = "SELECT * FROM dbo.UTILISATEURS WHERE no_article = ?;";

	Connection cnx = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Utilisateur user = null;

	/**
	 * Methode permettant d'ajouter un utilisateur à la base de donnée
	 */
	@Override
	public void insert(Utilisateur user) throws DalException {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getPrenom());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPseudo());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getTelephone());
			stmt.setString(7, user.getVille());
			stmt.setString(8, user.getRue());
			stmt.setString(9, user.getCodePostal());
			stmt.setInt(10, user.getCredit());
			stmt.setBoolean(11, user.isAdministrateur());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de déconnexion", e);
			}
		}
	}

	/**
	 * Methode permettant de selectionner un utilisateur par ses identifiants
	 */
	@Override
	public Utilisateur selectByLogin(Utilisateur user) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		Utilisateur u = null;

		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_LOGIN);
			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getPassword());

			ResultSet result = stmt.executeQuery();
			if (result.next()) {

				u = new Utilisateur();
				u.setNom(result.getString("nom"));
				u.setPrenom(result.getString("prenom"));
				u.setPseudo(result.getString("pseudo"));
				u.setMotDePasse(null);
				

			}

		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de déconnexion", e);
			}
		}
		return u;
	}

	@Override
	public Utilisateur selectById(int noArticle) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		Utilisateur user = null;
		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(SELET_BY_ID);
			stmt.setInt(1, noArticle);
			ResultSet result = stmt.executeQuery();
			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(result.getInt("id"));
				user.setNom(result.getString("nom"));
				user.setPrenom(result.getString("prenom"));
				user.setEmail(result.getString("email"));
				user.setVille(result.getString("ville"));
				user.setRue(result.getString("rue"));
				user.setPseudo(result.getString("pseudo"));
				user.setTelephone(result.getString("telephone"));
				user.setCodePostal(result.getString("codePostal"));
				user.setCredit(result.getInt("credit"));
				user.setAdministrateur(result.getBoolean("prenom"));
			}
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de déconnexion", e);
			}
		}
		return user;
	}

}
