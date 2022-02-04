package fr.eni.projetEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projetEnchere.bo.Utilisateur;
import fr.eni.projetEnchere.dal.Exception.DalException;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private final static String INSERT_USER = "INSERT INTO dbo.UTILISATEURS (prenom,nom,pseudo,email,mot_de_passe,telephone,"
			+ "ville,rue,code_postal,credit,administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_LOGIN = "SELECT * FROM dbo.UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ? OR email = ?  AND mot_de_passe = ?";
	private final static String SELET_BY_ID = "SELECT * FROM dbo.UTILISATEURS WHERE no_article = ?;";
	private final static String UPDATE_USER = "UPDATE UTILISATEURS SET prenom =?,nom=?,email=?,mot_de_passe=?,telephone=?,"
			+ "ville=?,rue=?,code_postal=?,credit=? WHERE pseudo = ? and mot_de_passe= ?;";
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM dbo.UTILISATEURS WHERE pseudo = ?;";
	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;";

	Connection cnx = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Utilisateur user = null;

	/**
	 * Methode permettant d'ajouter un utilisateur � la base de donn�e
	 */
	@Override
	public void insert(Utilisateur user) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
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
			if (user.isAdministrateur() == true) {
				stmt.setInt(11, 1);
			} else {
				stmt.setInt(11, 0);
			}
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
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
			stmt.setString(3, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(4, user.getPassword());

			ResultSet result = stmt.executeQuery();
			if (result.next()) {
  
				u = new Utilisateur();
				u.setNoUtilisateur(result.getInt("no_utilisateur"));
				u.setNom(result.getString("nom"));
				u.setPrenom(result.getString("prenom"));
				u.setPseudo(result.getString("pseudo"));
				u.setEmail(result.getString("email"));
				u.setVille(result.getString("ville"));
				u.setTelephone(result.getString("telephone"));
				u.setCodePostal(result.getString("code_postal"));
				u.setRue(result.getString("rue"));
				u.setCredit(result.getInt("credit"));
				u.setMotDePasse(null);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// throw new DalException("Probleme de d�connexion", e);
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
				user.setAdministrateur(result.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return user;

	}

	@Override
	public Utilisateur selectByPseudo(String Pseudo) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		Utilisateur user = null;

		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			stmt.setString(1, Pseudo);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(result.getInt("no_utilisateur"));
				user.setNom(result.getString("nom"));
				user.setPrenom(result.getString("prenom"));
				user.setEmail(result.getString("email"));
				user.setVille(result.getString("ville"));
				user.setRue(result.getString("rue"));
				user.setPseudo(result.getString("pseudo"));
				user.setTelephone(result.getString("telephone"));
				user.setCodePostal(result.getString("codePostal"));
				user.setCredit(result.getInt("credit"));
				user.setAdministrateur(result.getBoolean("administrateur"));
			}

		} catch (SQLException e) {
			throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				throw new DalException("Probleme de d�connexion", e);
			}
		}
		return user;
	}

	@Override
	public void delete(Utilisateur user) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(DELETE);
			stmt.setInt(1, user.getNoUtilisateur());
			stmt.executeUpdate();

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DalException();
			}
		} catch (SQLException e) {
			throw new DalException();
		}
	}

	@Override
	public void update(Utilisateur user) throws DalException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = ConnectionProvider.getConnection();
			stmt = cnx.prepareStatement(UPDATE_USER);
			
			stmt.setString(1, user.getPrenom());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, user.getVille());
			stmt.setString(7, user.getRue());
			stmt.setString(8, user.getCodePostal());
			stmt.setInt(9, user.getCredit());
			stmt.setString(10, user.getPseudo());
			stmt.setString(11, user.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new DalException("Probleme sur la couche Dal", e);
		} finally {
			try {
				stmt.close();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// throw new DalException("Probleme de d�connexion", e);
			}
		}

	}

}
