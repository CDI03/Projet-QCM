package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Inscription;
import fr.eni_ecole.jee.dal.DalInscription;

public class CtrlInscription {

	public static ArrayList<Inscription> SelectAll() throws SQLException, NamingException {
		return DalInscription.SelectAll();
	}

}
