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
	
	public static Map<String, ArrayList> SelectAll() throws SQLException, NamingException {
		//D�claration d'une HashMap qui sera retourn� en contenant deux listes : Themes et Comp�tences 
		List<Theme> listThemes = new ArrayList<Theme>();
		List<Competence> listCompetences = new ArrayList<Competence>();
		Map<String, ArrayList> hashMapThemes = new HashMap<String, ArrayList>();
		//variable permettant de limiter la liste des comp�tences � des comp�tences uniques
		int competenceIdPrecedent = 0;
		//r�cup�ration des donn�es
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALL);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int themeId = rs.getInt("Theme_Id");
				String themeLibelle = rs.getString("Theme_Libelle");
				int competenceId = rs.getInt("Competence_Id");
				String competenceLibelle = rs.getString("Competence_Libelle");
		//construction d'une comp�tence
				Competence uneCompetence = new Competence();
				uneCompetence.setId(competenceId);
				uneCompetence.setLibelle(competenceLibelle);
		//construction de la liste des comp�tences
				if (competenceIdPrecedent != competenceId) {
					listCompetences.add(uneCompetence);
					competenceIdPrecedent = competenceId;
					System.out.println(competenceLibelle);
				}
		//construction d'un theme
				Theme unTheme = new Theme();
				unTheme.setId(themeId);
				unTheme.setLibelle(themeLibelle);
				unTheme.setCompetence(uneCompetence);
		//construction de la liste des themes
				listThemes.add(unTheme);
				System.out.println(themeLibelle);
			}
		}
		//construction de la hashmap
		hashMapThemes.put("listThemes", (ArrayList) listThemes);
		hashMapThemes.put("listCompetences", (ArrayList) listCompetences);
		return hashMapThemes;
	}

	public static boolean Insert(Theme theme) {
		boolean insertOk = false;
		
		
		return insertOk;
	}

	public static boolean Update(Theme theme) {
		boolean updateOk = false;
		
		
		return updateOk;	
	}

	public static boolean Delete(Theme theme) {
		boolean deleteOk = false;
		
		
		return deleteOk;
	}

	public static Theme GetOne(Theme theme) {
		//R�cup�rer l'info des questions et des r�ponses associ�es
		
		
		return null;
	}

	
	
}
