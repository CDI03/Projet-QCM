package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalQuestion {
	
	private final static String SELECTALLBYTHEME = "{ call SelectAllByTheme_Question (?) }";
	private final static String INSERT = "{ call Insert_Question (?,?,?) }";
	private final static String DELETE = "{ call Delete_Question (?) }";
	private final static String UPDATE = "{ call Update_Question (?,?,?) }";

	public static ArrayList<Question> SelectAll(Section section) throws SQLException, NamingException {
		// recuperer une liste de question au hasard en fonction du nombre définit par la section	
		ArrayList<Question> listQuestionSection = new ArrayList<Question>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_QUESTION_SECTION (?)}");
			cmd.setInt(1, section.getTheme().getId());
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) {
				String enonce = rs.getString("Enonce");
				int questionID = rs.getInt("Id");

		//construction d'une question
				Question uneQuestion = new Question();
				uneQuestion.setId(questionID);
				uneQuestion.setEnonce(enonce);
				uneQuestion.setTheme(section.getTheme());
		//construction de la liste
				listQuestionSection.add(uneQuestion);
			}
		}	
		return listQuestionSection;	
	}


	public static List<Question> SelectAllByTheme(int idTheme) throws SQLException, NamingException {
		List<Question> listQuestions = new ArrayList<Question>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SELECTALLBYTHEME);
			cmd.setInt(1, idTheme);
			ResultSet rs = cmd.executeQuery();		
			while (rs.next()) {
				// TODO recup illustration Question
				int questionID = rs.getInt("Question_Id");
				String enonce = rs.getString("Enonce");
				
		//construction d'une question
				Question uneQuestion = new Question();
				uneQuestion.setId(questionID);
				uneQuestion.setEnonce(enonce);
				
		//construction de la liste
				listQuestions.add(uneQuestion);
			}
		}	
		return listQuestions;
	}


	public static Boolean Insert(Question uneQuestion) throws SQLException, NamingException {
		boolean insertOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(INSERT);
			cstmt.setInt(1, uneQuestion.getId());
			cstmt.setString(2, uneQuestion.getEnonce());
			cstmt.setInt(3, uneQuestion.getTheme().getId());
			//cstmt.setString(4, uneQuestion.getIllustration());
			int intInsert = cstmt.executeUpdate();
			insertOk = (intInsert != 0)?true:false;
			
		}
		return insertOk;
	}


	public static Boolean Update(Question uneQuestion) throws SQLException, NamingException {
		boolean updateOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(UPDATE);
			cstmt.setInt(1, uneQuestion.getId());
			cstmt.setString(2, uneQuestion.getEnonce());
			cstmt.setInt(3, uneQuestion.getTheme().getId());
			//cstmt.setString(4, uneQuestion.getIllustration());
			int intUpdate = cstmt.executeUpdate();
			updateOk = (intUpdate != 0)?true:false;
		}
		return updateOk;
	}


	public static Boolean Delete(int idQuestion) throws SQLException, NamingException {
		boolean deleteOk = false;
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = cnx.prepareCall(DELETE);
			cstmt.setInt(1, idQuestion);
			int intDelete = cstmt.executeUpdate();
			deleteOk = (intDelete != 0)?true:false;
		}
		return deleteOk;
	}

}
