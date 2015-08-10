package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalQuestion;

public class CtrlQuestion {

	public static List<Question> SelectAllByTheme(int idTheme) throws SQLException, NamingException {
		return DalQuestion.SelectAllByTheme(idTheme);
	}

	public static Boolean Insert(Question uneQuestion) throws SQLException, NamingException {
		return DalQuestion.Insert(uneQuestion);
	}

	public static Boolean Update(Question uneQuestion) throws SQLException, NamingException {
		return DalQuestion.Update(uneQuestion);
	}

	public static Boolean Delete(int idQuestion) throws SQLException, NamingException {
		return DalQuestion.Delete(idQuestion);
	}

}
