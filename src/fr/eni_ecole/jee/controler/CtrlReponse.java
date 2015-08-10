package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.dal.DalQuestion;

import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.dal.DalReponse;

public class CtrlReponse {


	public static List<Reponse> SelectAllByQuestion(int idQuestion) throws SQLException, NamingException {
		return DalReponse.SelectAllByQuestion(idQuestion);
	}

	public static ArrayList<Reponse> selectReponseQuestion(QuestionPosee questionEnCours) throws SQLException, NamingException {
		
		return DalReponse.SelectAll(questionEnCours.getQuestion());
	}

	public static Boolean Insert(Reponse uneReponse) throws SQLException, NamingException {
		return DalReponse.Insert(uneReponse);
		
	}

	public static Boolean Delete(int idReponse) throws SQLException, NamingException {
		return DalReponse.Delete(idReponse);
	}

	public static Boolean Update(Reponse uneReponse) throws SQLException, NamingException {
		return DalReponse.Update(uneReponse);
	}

}
