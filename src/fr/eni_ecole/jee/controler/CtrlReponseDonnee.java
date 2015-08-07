package fr.eni_ecole.jee.controler;

import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.ReponseDonnee;
import fr.eni_ecole.jee.dal.DalReponseDonnee;

public class CtrlReponseDonnee {

	public static boolean enregistrerReponse(ReponseDonnee reponseAEnregistrer) throws SQLException, NamingException {
		return DalReponseDonnee.Insert(reponseAEnregistrer);
	}
}
