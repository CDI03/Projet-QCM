package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalQuestionPosee {

	public static ArrayList<QuestionPosee> SelectAll(Examen examenChoisit) throws SQLException, NamingException {

		//Crer une liste de question posée
		ArrayList<QuestionPosee> listQuestionPosee = new ArrayList<QuestionPosee>();
		
		//Enregistrer la liste des Questions
		/*try (Connection cnx = PoolConnection.getConnection()) {
			int position = 0;
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_QUESTIONPOSEE (?)}");
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next())
			{
				//faire la création de la liste de question posée
				QuestionPosee laQuestionEnEnregistrement = new QuestionPosee();
				laQuestionEnEnregistrement.setExamen(examenChoisit);
				laQuestionEnEnregistrement.setMarque(rs.getBoolean(columnIndex));
				laQuestionEnEnregistrement.setRepondu(rs.getBoolean(columnIndex));
				//laQuestionEnEnregistrement.setQuestion(rs.get);
				laQuestionEnEnregistrement.setOrdre(rs.getInt(columnIndex));
				
				listQuestionPosee.add(laQuestionEnEnregistrement);
			}
		}	*/
		return listQuestionPosee;	
	}

	public static boolean InsertAll(Examen examenChoisit, ArrayList<Question> listQuestionHasard) throws SQLException, NamingException {
		boolean insertOk = false;
		//Crer une liste de question posée
		ArrayList<QuestionPosee> listQuestionPosee = new ArrayList<QuestionPosee>();
		
		//Enregistrer la liste des Questions
		try (Connection cnx = PoolConnection.getConnection()) {
			int position = 1;
			CallableStatement cmd = cnx.prepareCall("{ call INSERT_QUESTIONPOSEE (?,?,?)}");
			for (Question question : listQuestionHasard) 
			{
				cmd.setInt(1, examenChoisit.getId());
				cmd.setInt(2, question.getId());
				cmd.setInt(3, position);
				
				cmd.executeUpdate();
				cmd.clearParameters();
				
				position+=1;
			}
			insertOk = true;
		}	
		return insertOk;
	}


	public static QuestionPosee SelectOne(Examen examenChoisit, int numeroQuestion) throws SQLException, NamingException {
		
		//Crer une question
		QuestionPosee laQuestionEnEnregistrement = null;
		try (Connection cnx = PoolConnection.getConnection()) 
		{
			
			cnx.setAutoCommit(false);
			
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ONE_QUESTIONPOSEE (?,?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cmd.setInt(1, examenChoisit.getId());
			cmd.setInt(2, numeroQuestion);
			
			ResultSet rs = cmd.executeQuery();

			int taille = 0;
			while (rs.next()) {
				taille+=1;
			}
			
			//test si le ResultSet ne contient qu'une seule ligne
			if (taille==1)
				{
					rs.first();	
					laQuestionEnEnregistrement = new QuestionPosee();
					//Créer un Theme
					Theme leTheme = new Theme();
					leTheme.setId(rs.getInt("Theme_Id"));
					leTheme.setLibelle(rs.getString("Libelle"));					
					//Créer une Question
					Question laQuestion = new Question();
					laQuestion.setEnonce(rs.getString("Enonce"));
					laQuestion.setId(rs.getInt("Question_Id"));
					//laQuestion.setIllustration(illustration);
					laQuestion.setNbReponses(rs.getInt("NbReponses"));
					laQuestion.setTheme(leTheme);
					//Créer une Question posée
					laQuestionEnEnregistrement.setExamen(examenChoisit);
					laQuestionEnEnregistrement.setOrdre(numeroQuestion);
					laQuestionEnEnregistrement.setQuestion(laQuestion);
					laQuestionEnEnregistrement.setMarque(rs.getBoolean("Marque"));
					laQuestionEnEnregistrement.setMarque(rs.getBoolean("Repondu"));
				}	
			cnx.commit();
		}	
		return laQuestionEnEnregistrement;	
	}

	public static boolean UpdateRepondu(QuestionPosee questionPosee) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall("{ call UPDATE_REPONDU_QUESTIONPOSEE (?,?)}");
			cstmt.setInt(1, questionPosee.getOrdre());
			cstmt.setInt(2, questionPosee.getExamen().getId());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;	
	}

	public static boolean UpdateMarque(QuestionPosee questionPosee) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall("{ call UPDATE_MARQUE_QUESTIONPOSEE (?,?)}");
			cstmt.setInt(1, questionPosee.getOrdre());
			cstmt.setInt(2, questionPosee.getExamen().getId());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;	
	}
}
