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
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalSection {

	private final static String SELECTALLBYTEST = "{call SelectAllByTest_Section (?)}";
	
	public static ArrayList<Section> SelectAll(Examen examenChoisit) throws SQLException, NamingException {
		ArrayList<Section> listSection = new ArrayList<Section>();
		
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{call SELECT_ALL_SECTION_BY_EXAMEN (?)}");
			cmd.setInt(1, examenChoisit.getTest().getId());
			ResultSet rs = cmd.executeQuery();			
			
			while (rs.next()) {
				int nbQuestion = rs.getInt("NombreQuestion");
				int themeID = rs.getInt("Id_Theme");
				String themeLibelle = rs.getString("Libelle_Theme");
				
		//Construction du theme
				Theme leTheme = new Theme();
				leTheme.setId(themeID);
				leTheme.setLibelle(themeLibelle);
		//construction d'une section
				Section uneSection = new Section();
				uneSection.setNombreQuestion(nbQuestion);
				uneSection.setTest(examenChoisit.getTest());	
				uneSection.setTheme(leTheme);	
		//construction de la liste
				listSection.add(uneSection);
			}
		}	
		return listSection;	
	}

	public static List<Section> SelectAllByTest(int idTest) {
		ArrayList<Section> listSection = new ArrayList<Section>();
		
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SELECTALLBYTEST);
			cmd.setInt(1, idTest);
			ResultSet rs = cmd.executeQuery();			
			
			while (rs.next()) {
				int nbQuestion = rs.getInt("NombreQuestion");
				int themeID = rs.getInt("Id_Theme");
				String themeLibelle = rs.getString("Libelle_Theme");
				
		//Construction du theme
				Theme leTheme = new Theme();
				leTheme.setId(themeID);
				leTheme.setLibelle(themeLibelle);
		//construction d'une section
				Section uneSection = new Section();
				uneSection.setNombreQuestion(nbQuestion);
				uneSection.setTest(idTest);	
				uneSection.setTheme(leTheme);	
		//construction de la liste
				listSection.add(uneSection);
			}
		}	
		return listSection;	
	}	
}
