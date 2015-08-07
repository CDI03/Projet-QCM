package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalReponse {

	public static ArrayList<Reponse> SelectAll(Question question) throws SQLException, NamingException {
	
		ArrayList<Reponse> listReponseQuestion = new ArrayList<Reponse>();
		//Récupération des données
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cmd = cnx.prepareCall("{ call SELECT_ALL_REPONSE_QUESTION (?)}");
			cmd.setInt(1, question.getId());
			ResultSet rs = cmd.executeQuery();		
			
			while (rs.next()) {
			boolean estCorrect = rs.getBoolean("EstCorrect");
			String reponseLibelle = rs.getString("Libelle");
			int reponseID = rs.getInt("Id");
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
}
