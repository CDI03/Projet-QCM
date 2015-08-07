package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.dal.DalQuestion;
import fr.eni_ecole.jee.dal.DalReponse;

public class CtrlReponse {

	public static List<Reponse> SelectAllByQuestion(int idQuestion) throws SQLException, NamingException {
		return DalReponse.SelectAllByQuestion(idQuestion);
	}

}
