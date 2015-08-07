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
	
	private final static String SELECTBYTHEME = "{ call SelectByTheme_Questions (?) }";

	public static ArrayList<Question> SelectAll(Section section) throws SQLException, NamingException {
		// recuperer une liste de question au hasard en fonction du nombre définit par la section	
		ArrayList<Question> listQuestionSection = new ArrayList<Question>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_QUESTION_SECTION (?)}");
			cmd.setInt(1, section.getTheme().getId());
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) {
				int questionID = rs.getInt("Question_Id");
				String enonce = rs.getString("Enonce");
				int nbReponse = rs.getInt("NbReponses");
				
				
		//construction d'une question
				Question uneQuestion = new Question();
				uneQuestion.setId(questionID);
				uneQuestion.setEnonce(enonce);
				uneQuestion.setNbReponses(nbReponse);
				uneQuestion.setTheme(section.getTheme());
		//construction de la liste
				listQuestionSection.add(uneQuestion);
			}
		}	
		return listQuestionSection;	
	}

	public static List<Question> SelectByTheme(Theme theme) throws SQLException, NamingException {
		List<Question> listQuestionTheme = new ArrayList<Question>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SELECTBYTHEME);
			cmd.setInt(1, theme.getId());
			ResultSet rs = cmd.executeQuery();		
			while (rs.next()) {
				// TODO recup illustration Question
				int questionID = rs.getInt("Question_Id");
				String enonce = rs.getString("Enonce");
				int nbReponse = rs.getInt("NbReponses");
				
		//construction d'une question
				Question uneQuestion = new Question();
				uneQuestion.setId(questionID);
				uneQuestion.setEnonce(enonce);
				uneQuestion.setNbReponses(nbReponse);
				
		//construction de la liste
				listQuestionTheme.add(uneQuestion);
			}
		}	
		return listQuestionTheme;
	}

}
