package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.dal.DalReponse;

public class CtrlReponse {

	public static ArrayList<Reponse> selectReponseQuestion(QuestionPosee questionEnCours) throws SQLException, NamingException {
		
		return DalReponse.SelectAll(questionEnCours.getQuestion());
	}



}
