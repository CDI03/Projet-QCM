package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Formation;
import fr.eni_ecole.jee.dal.DalFormation;

public class CtrlFormation {

	public static List<Formation> SelectAll() throws SQLException, NamingException {
		return DalFormation.SelectAll();
	}

}
