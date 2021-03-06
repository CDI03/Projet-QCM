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
import javax.swing.JApplet;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalQuestionPosee {

	public static ArrayList<QuestionPosee> SelectAll(Examen examenChoisit) throws SQLException, NamingException {

		//Crer une liste de question pos�e
		ArrayList<QuestionPosee> listQuestionPosee = new ArrayList<QuestionPosee>();
		
		//Enregistrer la liste des Questions
		try (Connection cnx = PoolConnection.getConnection()) {
			int position = 0;
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_QUESTIONPOSEE (?)}");
			cmd.setInt(1, examenChoisit.getId());
			ResultSet rs = cmd.executeQuery();
			
			while (rs.next())
			{
				//faire la cr�ation de la liste de question pos�e
				QuestionPosee laQuestionEnEnregistrement = new QuestionPosee();
				laQuestionEnEnregistrement.setExamen(examenChoisit);
				laQuestionEnEnregistrement.setMarque(rs.getBoolean("Marque"));
				laQuestionEnEnregistrement.setRepondu(rs.getBoolean("Repondu"));
				laQuestionEnEnregistrement.setOrdre(rs.getInt("Ordre"));
				
				listQuestionPosee.add(laQuestionEnEnregistrement);
			}
		}	
		return listQuestionPosee;	
	}

	public static boolean InsertAll(Examen examenChoisit, ArrayList<Question> listQuestionHasard) throws SQLException, NamingException {
		boolean insertOk = false;
		//Crer une liste de question pos�e
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
					//Cr�er un Theme
					Theme leTheme = new Theme();
					leTheme.setId(rs.getInt("Theme_Id"));
					leTheme.setLibelle(rs.getString("Libelle"));					
					//Cr�er une Question
					Question laQuestion = new Question();
					laQuestion.setEnonce(rs.getString("Enonce"));
					laQuestion.setId(rs.getInt("Question_Id"));
					//laQuestion.setIllustration(illustration);
					laQuestion.setTheme(leTheme);
					//Cr�er une Question pos�e
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

	public static boolean UpdateEtat(QuestionPosee questionPosee) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall("{ call UPDATE_ETAT_QUESTIONPOSEE (?,?,?,?)}");
			cstmt.setInt(1, questionPosee.getOrdre());
			cstmt.setInt(2, questionPosee.getExamen().getId());
			cstmt.setBoolean(3, questionPosee.isRepondu());
			cstmt.setBoolean(4, questionPosee.isMarque());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;	
	}

	public static QuestionPosee SelectLast(Examen examenChoisit) throws SQLException, NamingException {
		//Crer une question
		QuestionPosee laQuestionEnEnregistrement = null;
		try (Connection cnx = PoolConnection.getConnection()) 
		{	
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_LAST_QUESTIONPOSEE (?)}", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cmd.setInt(1, examenChoisit.getId());
			
			if (cmd.execute())
			{ResultSet rs = cmd.getResultSet();
			if (rs.last())	
			{
				rs.last();
				laQuestionEnEnregistrement = new QuestionPosee();
			//Cr�er un Theme
			//Theme leTheme = new Theme();
			//leTheme.setId(rs.getInt("Theme_Id"));
			//leTheme.setLibelle(rs.getString("Libelle"));					
			//Cr�er une Question
			//Question laQuestion = new Question();
			//laQuestion.setEnonce(rs.getString("Enonce"));
			//laQuestion.setId(rs.getInt("Question_Id"));
			//laQuestion.setIllustration(illustration);
			//laQuestion.setNbReponses(rs.getInt("NbReponses"));
			//laQuestion.setTheme(leTheme);
			//Cr�er une Question pos�e
			laQuestionEnEnregistrement.setExamen(examenChoisit);
			laQuestionEnEnregistrement.setOrdre(rs.getInt("Ordre"));
			//laQuestionEnEnregistrement.setQuestion(laQuestion);
			//laQuestionEnEnregistrement.setMarque(rs.getBoolean("Marque"));
			//laQuestionEnEnregistrement.setMarque(rs.getBoolean("Repondu"));
			}}
		}	
		return laQuestionEnEnregistrement;	
	}

	
	public static int Size(Examen examenChoisit) throws SQLException, NamingException {
		int taille = 0;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall("{ ?=call NBQUESTIONPOSEE_BY_EXAMEN (?)}");
			cstmt.setInt(2, examenChoisit.getId());
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.execute();
			taille = cstmt.getInt(1);}	
		return taille;	
	}
}
