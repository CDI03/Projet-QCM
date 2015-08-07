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

public class DalCompetence {

	private final static String SELECTALLBYFORMATION = "{ call SelectAllByFormation_Competences (?) }";
	
	public static List<Competence> SelectAllByFormation(String idFormation) throws SQLException, NamingException {
		
		List<Competence> listCompetences = new ArrayList<Competence>();
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall(SELECTALLBYFORMATION);
			cstmt.setString(1, idFormation);
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				int competenceId = rs.getInt("Competence_Id");
				String competenceLibelle = rs.getString("Competence_Libelle");
		//construction d'une compétence
				Competence uneCompetence = new Competence();
				uneCompetence.setId(competenceId);
				uneCompetence.setLibelle(competenceLibelle);
				Formation uneFormation = new Formation();
				uneFormation.setId(idFormation);
				uneCompetence.setFormation(uneFormation);
		//construction de la liste des themes
				listCompetences.add(uneCompetence);
			}
		}
		
		return listCompetences;
	}

}
