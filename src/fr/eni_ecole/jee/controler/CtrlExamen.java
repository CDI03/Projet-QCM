package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.dal.DalExamen;

public class CtrlExamen {

	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		return DalExamen.SelectAll(leCandidat);
	}
}
