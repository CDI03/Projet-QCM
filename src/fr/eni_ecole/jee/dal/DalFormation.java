package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Formation;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalFormation {

	private final static String SELECTALL = "{ call SelectAll_Formation }";
	
	public static List<Formation> SelectAll() throws SQLException, NamingException {
		List<Formation> listFormations = new ArrayList<Formation>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALL);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				String formationId = rs.getString("Formation_Id");
				String formationTitre = rs.getString("Formation_Titre");
		//construction d'une compétence
				Formation uneFormation = new Formation();
				uneFormation.setId(formationId);
				uneFormation.setTitre(formationTitre);
		//construction de la liste des themes
				listFormations.add(uneFormation);
			}
		}
		return listFormations;
	}

}
