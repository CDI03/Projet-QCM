package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalThemes {

	private final static String SELECTALL = "{ call SelectAll_Themes }";
	private final static String INSERT = "{ call Insert_Themes (?,?) }";
	private final static String UPDATE = "{ call Update_Themes (?,?,?) }";
	
	public static Map<String, ArrayList> SelectAll() throws SQLException, NamingException {
		//Déclaration d'une HashMap qui sera retourné en contenant deux listes : Themes et Compétences 
		List<Theme> listThemes = new ArrayList<Theme>();
		List<Competence> listCompetences = new ArrayList<Competence>();
		Map<String, ArrayList> hashMapThemes = new HashMap<String, ArrayList>();
		//variable permettant de limiter la liste des compétences à des compétences uniques
		int competenceIdPrecedent = 0;
		//récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(SELECTALL);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int themeId = rs.getInt("Theme_Id");
				String themeLibelle = rs.getString("Theme_Libelle");
				int competenceId = rs.getInt("Competence_Id");
				String competenceLibelle = rs.getString("Competence_Libelle");
		//construction d'une compétence
				Competence uneCompetence = new Competence();
				uneCompetence.setId(competenceId);
				uneCompetence.setLibelle(competenceLibelle);
		//construction de la liste des compétences
				if (competenceIdPrecedent != competenceId) {
					listCompetences.add(uneCompetence);
					competenceIdPrecedent = competenceId;
				}
		//construction d'un theme
				Theme unTheme = new Theme();
				unTheme.setId(themeId);
				unTheme.setLibelle(themeLibelle);
				unTheme.setCompetence(uneCompetence);
		//construction de la liste des themes
				listThemes.add(unTheme);
			}
		}
		//construction de la hashmap
		hashMapThemes.put("listThemes", (ArrayList) listThemes);
		hashMapThemes.put("listCompetences", (ArrayList) listCompetences);
		return hashMapThemes;
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

	public static boolean Delete(Theme theme) {
		boolean deleteOk = false;
		
		
		return deleteOk;
	}

	public static Theme SelectOne(Theme theme) {
		//Récupérer l'info des questions et des réponses associées
		
		
		return null;
	}

	
	
}
