package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalCompetences {

	private final static String SELECTALLSIMPLE = "{ call SelectAllSimple_Competences }";

	public static ArrayList<Competence> SelectAllSimple() throws SQLException, NamingException {
		ArrayList<Competence> listCompetence = new ArrayList<Competence>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALLSIMPLE);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int competenceId = rs.getInt("Competence_Id");
				String competenceLibelle = rs.getString("Competence_Libelle");
		//construction d'une compétence
				Competence uneCompetence = new Competence();
				uneCompetence.setId(competenceId);
				uneCompetence.setLibelle(competenceLibelle);
		//construction de la liste des themes
				listCompetence.add(uneCompetence);
			}
		}
		return listCompetence;
	}

	public static List<Competence> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean Insert(Competence competence) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean Update(Competence competence) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean Delete(Competence competence) {
		// TODO Auto-generated method stub
		return false;
	}

	public static Competence SelectOne(Competence competence) {
		// TODO Auto-generated method stub
		return null;
	}
}
