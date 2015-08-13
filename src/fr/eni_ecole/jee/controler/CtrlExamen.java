package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.dal.DalExamen;
import fr.eni_ecole.jee.dal.DalTest;

public class CtrlExamen {

	public static ArrayList<Examen> SelectAll(Candidat leCandidat) throws SQLException, NamingException {
		return DalExamen.SelectAll(leCandidat);
	}

	public static boolean updateEtatTest(Examen examenChoisit) throws SQLException, NamingException {
		return DalExamen.Update(examenChoisit);
	}
	
	public static int getNbReponsesCorrectesExamen(Examen examenChoisit) throws SQLException, NamingException {
		return DalExamen.getNbReponsesCorrectesExamen(examenChoisit);
	}

	public static int getNbReponsesCorrectesCandidat(Examen examenChoisit,
			Candidat leCandidatChoisit) {
		return DalExamen.getNbReponsesCorrectesCandidat(examenChoisit, leCandidatChoisit);
	}

	public static List<Candidat> SelectAllCandidatsByTest(int idTest) throws SQLException, NamingException {
		return DalExamen.SelectAllCandidatsByTest(idTest);
	}
}
