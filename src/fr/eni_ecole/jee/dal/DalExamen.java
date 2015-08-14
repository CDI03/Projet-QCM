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
	private final static String InsertExamen = "{ call Insert_Examen (?,?,?) }";
	private final static String DeleteExamen = "{ call Delete_Examen (?,?,?) }";
	
	//R�cup�rer tous les examens du candidat
	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		ArrayList<Examen> listExamen = new ArrayList<Examen>();
		
		//R�cup�ration des donn�es
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
				int seuilHaut = rs.getInt("SeuilHaut");
				int seuilBas = rs.getInt("SeuilBas");
				
				int examenTempsRestant;
				if(rs.getObject("TempsRestant")!=null)
					{examenTempsRestant = rs.getInt("TempsRestant");}
				else
					{examenTempsRestant = rs.getInt("Duree");}
		
		//construction d'un test
				Test unTest = new Test();
				unTest.setId(testId);
				unTest.setLibelle(testLibelle);
				unTest.setSeuilHaut(seuilHaut);
				unTest.setSeuilBas(seuilBas);
		//construction d'un examen
				Examen unExamen = new Examen();
				unExamen.setId(examenId);
				//TODO mettre une condition pour ne r�cup�rer que les examens avec la date de passage qui correspond � la date du jour
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
		
		//R�cup�ration des donn�es
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SelectAllCandidatsByTest);
			cmd.setInt(1, idTest);
			ResultSet rs = cmd.executeQuery();			
			while (rs.next()) {
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String motDePasse = rs.getString("motDePasse");
				java.sql.Date sqlDatePassage = rs.getDate("DatePassage");
				Date datePassage = new Date(sqlDatePassage.getTime());
				
				//construction d'un candidat
				Candidat unCandidat = new Candidat();
				unCandidat.setId(id);
				unCandidat.setMotDePasse(motDePasse);
				unCandidat.setNom(nom);
				unCandidat.setPrenom(prenom);
				unCandidat.setDatePassage(datePassage);
				//construction de la liste des Candidats
				listCandidats.add(unCandidat);
			}
		}
		return listCandidats;
	}

	public static Boolean Insert(int idTestSelectionne, String idCandidat, Date datePassage) throws SQLException, NamingException {
		boolean insertOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(InsertExamen);
			cstmt.setInt(1, idTestSelectionne);
			cstmt.setString(2, idCandidat.trim());
			java.sql.Timestamp sqlDatePassage = new java.sql.Timestamp(datePassage.getTime());
			cstmt.setTimestamp(3, sqlDatePassage);
			int intInsert = cstmt.executeUpdate();
			insertOk = (intInsert != 0)?true:false;
		}
		return insertOk;	
	}
	
	public static Boolean Delete(int idTestSelectionne, String idCandidat, Date datePassage) throws SQLException, NamingException {
		boolean deleteOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(DeleteExamen);
			cstmt.setInt(1, idTestSelectionne);
			cstmt.setString(2, idCandidat.trim());
			java.sql.Timestamp sqlDatePassage = new java.sql.Timestamp(datePassage.getTime());
			cstmt.setTimestamp(3, sqlDatePassage);
			int intDelete = cstmt.executeUpdate();
			deleteOk = (intDelete != 0)?true:false;
		}
		return deleteOk;	
	}
	
}
