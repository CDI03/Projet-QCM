package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalTheme {

	private final static String SELECTALLBYCOMPETENCE = "{ call SelectAllByCompetence_Theme (?) }";
	private final static String INSERT = "{ call Insert_Theme (?,?) }";
	private final static String UPDATE = "{ call Update_Theme (?,?,?) }";
	private final static String DELETE = "{ call Delete_Theme (?) }";
	
	public static List<Theme> SelectAllByCompetence(int idCompetence) throws SQLException, NamingException {
		
		List<Theme> listThemes = new ArrayList<Theme>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALLBYCOMPETENCE);
			cstmt.setInt(1, idCompetence);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int themeId = rs.getInt("Theme_Id");
				String themeLibelle = rs.getString("Theme_Libelle");
				int competenceId = rs.getInt("Competence_Id");
				//construction d'un theme
				Theme unTheme = new Theme();
				unTheme.setId(themeId);
				unTheme.setLibelle(themeLibelle);
				//Construction de la compétence associé
				Competence uneCompetence = new Competence();
				uneCompetence.setId(competenceId);
				//Association de la compétence
				unTheme.setCompetence(uneCompetence);
				//construction de la liste des themes
				listThemes.add(unTheme);
			}
		}	

		return listThemes;
	}
	
	public static boolean Insert(Theme theme) throws SQLException, NamingException {
		boolean insertOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(INSERT);
			cstmt.setString(1, theme.getLibelle());
			cstmt.setInt(2, theme.getCompetence().getId());
			int intInsert = cstmt.executeUpdate();
			insertOk = (intInsert != 0)?true:false;
		}
		return insertOk;
	}

	public static boolean Update(Theme theme) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(UPDATE);
			cstmt.setInt(1, theme.getId());
			cstmt.setString(2, theme.getLibelle());
			cstmt.setInt(3, theme.getCompetence().getId());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;	
	}

	public static boolean Delete(Theme theme) throws SQLException, NamingException {
		boolean deleteOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(DELETE);
			cstmt.setInt(1, theme.getId());
			int intDelete = cstmt.executeUpdate();
			deleteOk = (intDelete != 0)?true:false;
		}
		return deleteOk;
	}
	
}
