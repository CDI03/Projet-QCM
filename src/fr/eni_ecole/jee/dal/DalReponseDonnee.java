package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.ReponseDonnee;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalReponseDonnee {

	public static boolean Insert(ReponseDonnee reponseAEnregistrer) throws SQLException, NamingException {
		boolean insertOk = false;
		CallableStatement rqt = null;
		
		try (Connection cnx = PoolConnection.getConnection();)
		{
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareCall("{ call INSERT_REPONSEDONNEE (?,?,?,?) }");
			rqt.setInt(1, reponseAEnregistrer.getExamen().getId());
			rqt.setInt(2, reponseAEnregistrer.getQuestionPosee().getOrdre());
			rqt.setInt(3, reponseAEnregistrer.getReponse().getId());
			rqt.setInt(4, reponseAEnregistrer.getQuestion().getId());
			
		    int nbLigneAffectee = rqt.executeUpdate();	
		    cnx.commit();
			if (nbLigneAffectee == 1) {
				insertOk = true;
			}
		}
		return insertOk;
	}

}
