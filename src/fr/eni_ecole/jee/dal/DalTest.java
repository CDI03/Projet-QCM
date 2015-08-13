package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import fr.eni_ecole.jee.bo.Competence;

import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalTest {

	private final static String SELECTALL = "{ call SelectAll_Test }";
	private final static String SELECTONE = "{ call SelectOne_Test (?) }";
	
	public static List<Test> SelectAll() throws SQLException, NamingException {
		
		List<Test> listTests = new ArrayList<Test>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALL);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Id");
				String libelle = rs.getString("Libelle");
				int duree = rs.getInt("Duree");
				int seuilHaut = rs.getInt("SeuilHaut");
				int seuilBas = rs.getInt("SeuilBas");
				
				Test unTest = new Test();
				unTest.setId(id);
				unTest.setLibelle(libelle);
				unTest.setDuree(duree);
				unTest.setSeuilHaut(seuilHaut);
				unTest.setSeuilBas(seuilHaut);

				//construction de la liste des themes
				listTests.add(unTest);
			}
		}	

		return listTests;
	}

	public static Test SelectOne(int idTestSelectionne) throws SQLException, NamingException {
		Test unTest = new Test();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTONE);
			cstmt.setInt(1, idTestSelectionne);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Id");
				String libelle = rs.getString("Libelle");
				int duree = rs.getInt("Duree");
				int seuilHaut = rs.getInt("SeuilHaut");
				int seuilBas = rs.getInt("SeuilBas");
				
				unTest = new Test();
				unTest.setId(id);
				unTest.setLibelle(libelle);
				unTest.setDuree(duree);
				unTest.setSeuilHaut(seuilHaut);
				unTest.setSeuilBas(seuilHaut);
			}
		}
		return unTest;	
	}
}
