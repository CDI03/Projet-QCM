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

import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalQuestionPosee {

	public static ArrayList<QuestionPosee> SelectAll(Examen examenChoisit, ArrayList<Question> listQuestionHasard) throws SQLException, NamingException {

		//Crer une liste de question posée
		ArrayList<QuestionPosee> listQuestionPosee = new ArrayList<QuestionPosee>();
		
		//Enregistrer la liste des Questions
		try (Connection cnx = PoolConnection.getConnection()) {
			int position = 0;
			CallableStatement cmd = cnx.prepareCall("{ call INSERT_QUESTIONPOSEE (?,?,?)}");
			for (Question question : listQuestionHasard) 
			{
				cmd.setInt(1, examenChoisit.getId());
				cmd.setInt(2, question.getId());
				cmd.setInt(3, position);
				
				cmd.executeUpdate();
				cmd.clearParameters();
				
				//En même temps faire la création de la liste de question posée
				QuestionPosee laQuestionEnEnregistrement = new QuestionPosee();
				laQuestionEnEnregistrement.setExamen(examenChoisit);
				laQuestionEnEnregistrement.setMarque(false);
				laQuestionEnEnregistrement.setRepondu(false);
				laQuestionEnEnregistrement.setQuestion(question);
				laQuestionEnEnregistrement.setOrdre(position);
				
				position+=1;
			}
		}	
		return listQuestionPosee;	
	}
}
