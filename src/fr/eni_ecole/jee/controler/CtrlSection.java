package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.dal.DalSection;

public class CtrlSection {

	public static List<Section> SelectAllByTest(int idTest) throws SQLException, NamingException {
		return DalSection.SelectAllByTest(idTest);
	}

}
