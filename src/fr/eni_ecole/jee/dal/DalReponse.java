package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalReponse {

	private final static String SELECTALLBYQUESTION = "{ call SelectAllByQuestion_Reponse (?) }";
	
	public static ArrayList<Reponse> SelectAll(Question question) throws SQLException, NamingException {
	
		ArrayList<Reponse> listReponseQuestion = new ArrayList<Reponse>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_REPONSE_QUESTION (?)}");
			cmd.setInt(1, question.getId());
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) {
			boolean estCorrect = rs.getBoolean("EstCorrect");
			String reponseLibelle = rs.getString("Libelle_Reponse");
			int reponseID = rs.getInt("Id_Reponse");
			//construction d'une reponse
			Reponse uneReponse = new Reponse();
			uneReponse.setid(reponseID);
			uneReponse.setLibelle(reponseLibelle);
			uneReponse.setEstCorrect(estCorrect);
			uneReponse.setQuestion(question);
			listReponseQuestion.add(uneReponse);
			}
		}
		return listReponseQuestion;
	}

	public static List<Reponse> SelectAllByQuestion(int idQuestion) throws SQLException, NamingException {
		ArrayList<Reponse> listReponseQuestion = new ArrayList<Reponse>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall(SELECTALLBYQUESTION);
			cmd.setInt(1, idQuestion);
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) {
				int reponseId = rs.getInt("Reponse_Id");
				int questionId = rs.getInt("Question_Id");
				String reponseLibelle = rs.getString("Reponse_Libelle");
				boolean reponseEstCorrect = rs.getBoolean("Reponse_EstCorrect");
				
				
				//construction d'une reponse
				Reponse uneReponse = new Reponse();
				uneReponse.setid(reponseId);
				uneReponse.setLibelle(reponseLibelle);
				uneReponse.setEstCorrect(reponseEstCorrect);
				Question uneQuestion = new Question();
				uneQuestion.setId(questionId);
				uneReponse.setQuestion(uneQuestion);
				listReponseQuestion.add(uneReponse);
			}
		}
		return listReponseQuestion;
	}
}
