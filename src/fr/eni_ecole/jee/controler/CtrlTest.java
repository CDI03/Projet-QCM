package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;


import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.dal.DalTest;

public class CtrlTest {

	public static List<Test> SelectAll() throws SQLException, NamingException {
		return DalTest.SelectAll();
	}

	public static Test SelectOne(int idTestSelectionne) throws SQLException, NamingException {
		return DalTest.SelectOne(idTestSelectionne);
	}

}
