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
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalExamen {

	private final static String SelectAllCandidatsByTest = "{ call SelectAllCandidatsByTest_Examen (?) }";
	
	//Récupérer tous les examens du candidat
	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		ArrayList<Examen> listExamen = new ArrayList<Examen>();
		
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_EXAMEN_CANDIDAT (?)}");
			cmd.setString(1, leCandidat.getId());
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

	public static boolean Update(Examen examenChoisit) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall("{ call UPDATE_ETAT_EXAMEN (?,?)}");
			cstmt.setInt(1, examenChoisit.getId());
			cstmt.setString(2, examenChoisit.getEtat());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;	
	}
	
	public static int getNbReponsesCorrectesExamen(Examen examen) throws SQLException, NamingException {
		int nbReponsesCorrectes = 0;
		try (Connection cnx = PoolConnection.getConnection()) {
			
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_COUNT_NBCORRECTES (?)}");
			cmd.setInt(1, examen.getId());	
			
			ResultSet rs = cmd.executeQuery();
			
			int taille = 0;
			while (rs.next()) {
				taille+=1;
			}
			
			//test si le ResultSet ne contient qu'une seule ligne
			if (taille==1)
				{
					nbReponsesCorrectes = rs.getInt("countNbCorrectes");
				}	
		}
		return nbReponsesCorrectes;
	}

	public static int getNbReponsesCorrectesCandidat(Examen examenChoisit,
			Candidat leCandidatChoisit) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static List<Candidat> SelectAllCandidatsByTest(int idTest) throws SQLException, NamingException {
		List<Candidat> listCandidats = new ArrayList<Candidat>();
		
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SelectAllCandidatsByTest);
			cmd.setInt(1, idTest);
			ResultSet rs = cmd.executeQuery();			
			while (rs.next()) {
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String motDePasse = rs.getString("motDePasse");
				//construction d'un candidat
				Candidat unCandidat = new Candidat();
				unCandidat.setId(id);
				unCandidat.setMotDePasse(motDePasse);
				unCandidat.setNom(nom);
				unCandidat.setPrenom(prenom);
				//construction de la liste des Candidats
				listCandidats.add(unCandidat);
			}
		}
		return listCandidats;
	}
}
