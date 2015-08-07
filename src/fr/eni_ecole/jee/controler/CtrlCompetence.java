package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.dal.DalCompetence;
import fr.eni_ecole.jee.dal.DalFormation;

public class CtrlCompetence {

	public static List<Competence> SelectAllByFormation(String idFormation) throws SQLException, NamingException {
		return DalCompetence.SelectAllByFormation(idFormation);
	}

}
