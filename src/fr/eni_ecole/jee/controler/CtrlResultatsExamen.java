package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.bo.ResultatExamen;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalQuestion;
import fr.eni_ecole.jee.dal.DalReponse;
import fr.eni_ecole.jee.dal.DalResultatsExamen;
import fr.eni_ecole.jee.dal.DalTheme;

public class CtrlResultatsExamen {

	public static boolean enregistreResultats(Examen examenChoisit) throws SQLException, NamingException {
		boolean enregistrementResultat = false;
		
		ArrayList<Theme> lesThemesDuTest = DalTheme.SelectAllByExamen(examenChoisit);
		ArrayList<Question> listeQuestionThemeTest = null;
		ArrayList<Reponse> reponseCorrecteQuestion = null;
		ArrayList<Reponse> reponseDonneesQuestion = null;
		int nbQuestionsReussies = 0;
		int nbQuestionsTotales = 0;
		
		for (int i = 0; i < lesThemesDuTest.size(); i++) {
			listeQuestionThemeTest = DalQuestion.SelectAllByThemeExamen(examenChoisit,lesThemesDuTest.get(i));
			nbQuestionsTotales = listeQuestionThemeTest.size();
			for (Question question : listeQuestionThemeTest) {
				reponseCorrecteQuestion = DalReponse.selectAllCorrecteExamenQuestion(examenChoisit, question);
				reponseDonneesQuestion = DalReponse.selectAllDonneesExamenQuestion(examenChoisit, question);
				if (reponseCorrecteQuestion.containsAll(reponseDonneesQuestion) && reponseDonneesQuestion.containsAll(reponseCorrecteQuestion))
				{nbQuestionsReussies+=1;}
			}
			DalResultatsExamen.Insert(examenChoisit,lesThemesDuTest.get(i),nbQuestionsTotales,nbQuestionsReussies);
			
			//Remettre à zero
			listeQuestionThemeTest.clear();
			nbQuestionsTotales = 0;
			nbQuestionsReussies = 0;
			reponseCorrecteQuestion.clear();
			reponseDonneesQuestion.clear();
		}
		
		enregistrementResultat = true;
		return enregistrementResultat;
	}

	public static ArrayList<ResultatExamen> SelectAll(Examen examenChoisit) throws SQLException, NamingException {
		return DalResultatsExamen.SelectAll(examenChoisit);
	}

}
