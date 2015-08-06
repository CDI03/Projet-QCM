package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalExamen {

	//Récupérer tous les examens du candidat
	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		ArrayList<Examen> listExamen = new ArrayList<Examen>();
		
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_EXAMEN_CANDIDAT (?)}");
			cmd.setString(1, leCandidat.getid());
			ResultSet rs = cmd.executeQuery();			
			while (rs.next()) {
				int testId = rs.getInt("Test_Id");
				String testLibelle = rs.getString("Test_Libelle");							
				int examenId = rs.getInt("Examen_Id");
				Date examenDatePassage = rs.getDate("DatePassage");
				String examenEtat = rs.getString("Etat").trim();
				int examenTempsRestant;
				if(rs.getObject("TempsRestant")!=null)
					{examenTempsRestant = rs.getInt("TempsRestant");}
				else
					{examenTempsRestant = rs.getInt("Duree");}
		
		//construction d'un test
				Test unTest = new Test();
				unTest.setId(testId);
				unTest.setLibelle(testLibelle);
		//construction d'un examen
				Examen unExamen = new Examen();
				unExamen.setId(examenId);
				//TODO mettre une condition pour ne récupérer que les examens avec la date de passage qui correspond à la date du jour
				unExamen.setDatePassage(examenDatePassage);
				unExamen.setEtat(examenEtat);
				unExamen.setTempsRestant(examenTempsRestant);
				unExamen.setTest(unTest);
		//construction de la liste des themes
				listExamen.add(unExamen);
			}
		}
		return listExamen;
	}
}
