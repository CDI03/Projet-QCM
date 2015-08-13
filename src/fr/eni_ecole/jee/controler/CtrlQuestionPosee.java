package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.dal.DalQuestion;
import fr.eni_ecole.jee.dal.DalQuestionPosee;
import fr.eni_ecole.jee.dal.DalSection;

public class CtrlQuestionPosee {

	public static boolean creerQuestionsExamen(Examen examenChoisit) throws SQLException, NamingException{
		
		boolean creationTest = false;
		
		//1 - Recup liste des Section
		ArrayList<Section> listSection = DalSection.SelectAll(examenChoisit);
		
		//2 - Recuperer la liste des questions de tte les sections du test
		ArrayList<Question> listQuestionSection = new ArrayList<Question>();
		ArrayList<Question> listQuestionHasard = new ArrayList<Question>();
		
		for (Section section : listSection) {
			listQuestionSection = DalQuestion.SelectAll(section);
			for (int i = 0; i < section.getNombreQuestion(); i++) {
				listQuestionHasard.add(listQuestionSection.get(i));
			}
			listQuestionSection.clear();
		}
		
		//3 - Choisir des questions au hasard dans cette liste
		System.out.println("melange");
		Collections.shuffle(listQuestionHasard);
		
		//4 - Constitue donc une liste de question posée
		//Enregistrer cette liste de questions dans la DAL
		if (DalQuestionPosee.InsertAll(examenChoisit, listQuestionHasard))
		{
			creationTest = true;
		}
		return creationTest;
	}
	
	public static QuestionPosee recupQuestionEnCours(Examen examenChoisit, int numeroQuestion) throws SQLException, NamingException {
		
		return DalQuestionPosee.SelectOne(examenChoisit,numeroQuestion);
	}

	public static boolean UpdateEtat(QuestionPosee questionPosee) throws SQLException, NamingException {
		return DalQuestionPosee.UpdateEtat(questionPosee);
	}

	public static ArrayList<QuestionPosee> recupExamenEnCours(
			Examen examenChoisit) throws SQLException, NamingException {
		return DalQuestionPosee.SelectAll(examenChoisit);
	}

	public static QuestionPosee recupDerniereQuestion(Examen examenChoisit) throws SQLException, NamingException {
		return DalQuestionPosee.SelectLast(examenChoisit);
	}

	public static int tailleDuTest(Examen examenChoisit) throws SQLException, NamingException {
		return DalQuestionPosee.Size(examenChoisit);
	}
}
