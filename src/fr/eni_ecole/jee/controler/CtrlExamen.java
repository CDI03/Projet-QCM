package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.dal.DalExamen;
import fr.eni_ecole.jee.dal.DalQuestion;
import fr.eni_ecole.jee.dal.DalQuestionPosee;
import fr.eni_ecole.jee.dal.DalReponse;
import fr.eni_ecole.jee.dal.DalSection;

public class CtrlExamen {

	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		return DalExamen.SelectAll(leCandidat);
	}

	public static Map<String, ArrayList> SelectOne(Examen examenChoisit) throws SQLException, NamingException {
		Map<String, ArrayList> hashMapDuTest = new HashMap<String, ArrayList>();
		
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
		Collections.shuffle(listQuestionHasard);
		
		//4 - Constitue donc une liste de question posée
		//Enregistrer cette liste de questions dans la DAL
		ArrayList<QuestionPosee> listQuestionExamen = new ArrayList<QuestionPosee>();
		listQuestionExamen = DalQuestionPosee.SelectAll(examenChoisit, listQuestionHasard);
		
		//5 -  récupérer la liste des réponses pour chaque question
		ArrayList<Reponse> listReponseExamen = new ArrayList<Reponse>();
		for (QuestionPosee questionPosee : listQuestionExamen) {
			listReponseExamen.addAll(DalReponse.SelectAll(questionPosee.getQuestion()));
		}
		
		//6 - remplir la HashMap	
		
		hashMapDuTest.put("listQuestionExamen", listQuestionExamen);
		hashMapDuTest.put("listReponseExamen", listReponseExamen);
		
		return hashMapDuTest;
	}
}
