package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.ResultatExamen;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalResultatsExamen {

	public static boolean Insert(Examen examenChoisit, Theme theme,
			int nbQuestionsTotales, int nbQuestionsReussies) throws SQLException, NamingException {
		
		boolean insertOk = false;
		
		//Enregistrer la liste des Questions
		try (Connection cnx = PoolConnection.getConnection()) {
			
			CallableStatement cmd = cnx.prepareCall("{ call INSERT_RESULTAT_EXAMEN (?,?,?,?,?)}");
			cmd.setInt(1, examenChoisit.getId());
			cmd.setInt(2, examenChoisit.getTest().getId());
			cmd.setInt(3, theme.getId());
			cmd.setInt(4, nbQuestionsReussies);
			cmd.setInt(5, nbQuestionsTotales);
			
			int nbligneAffectees = cmd.executeUpdate();
			if (nbligneAffectees == 1) {
				insertOk = true;
			}
		}
		return insertOk;
	}

	public static ArrayList<ResultatExamen> SelectAll(Examen examenChoisit) throws SQLException, NamingException {
		ArrayList<ResultatExamen> listResultatCandidat = new ArrayList<ResultatExamen>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_RESULTAT_EXAMEN (?)}");
			cmd.setInt(1, examenChoisit.getId());
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) 
			{
				//int Test_Id = rs.getInt("Test_Id");
				int Theme_Id = rs.getInt("Theme_Id");
				String Theme_Libelle = rs.getString("Theme_Libelle");
				int NbQuestionsReussies = rs.getInt("NbQuestionsReussies");
				int NbQuestionsTotales = rs.getInt("NbQuestionsTotales");
				
				Theme unTheme = new Theme();
				unTheme.setId(Theme_Id);
				unTheme.setLibelle(Theme_Libelle);
				ResultatExamen unResultat = new ResultatExamen();
				unResultat.setExamen(examenChoisit);
				unResultat.setTest(examenChoisit.getTest());
				unResultat.setTheme(unTheme);
				unResultat.setNbrQuestionsReussies(NbQuestionsReussies);
				unResultat.setNbrQuestionsTotales(NbQuestionsTotales);	
				//construction de la liste
				listResultatCandidat.add(unResultat);
			}
		}	
		return listResultatCandidat;
	}

}
