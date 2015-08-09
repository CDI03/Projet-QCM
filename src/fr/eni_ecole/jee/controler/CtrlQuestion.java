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

}
