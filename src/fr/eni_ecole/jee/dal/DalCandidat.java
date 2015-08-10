package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalCandidat {
	
	//TODO A r�fl�chir : transaction(commit) au sein de java utile? ou d�j� effetu� au sein des proc�dures stock�es

	//Ajouter un candidat
	public static boolean Insert(Candidat candidat) throws SQLException, NamingException {
		boolean insertOk = false;
		CallableStatement rqt = null;
		try (Connection cnx = PoolConnection.getConnection();)
		{
			cnx.setAutoCommit(false);
			//Procedure stock�e qui ins�re un candidat en passant son nom, prenom, mot de passe
			//Id cr�er dans la proc�dure stock�e : 3 premi�res lettres du nom + chiffres qui s'incr�mente
			rqt = cnx.prepareCall("{ call INSERT_CANDIDAT (?,?,?) }");
			rqt.setString(1, candidat.getNom());
			rqt.setString(2, candidat.getPrenom());
			rqt.setString(3, candidat.getMotDePasse());
		    int nbLigneAffectee = rqt.executeUpdate();	
		    cnx.commit();
			if (nbLigneAffectee == 1) {
				insertOk = true;
			}
		}
		return insertOk;
	}

	//R�cup�rer le candidat gr�ce � son id et son mot de passe
	public static Candidat SelectOne(String id, String motDePasse) throws SQLException, NamingException {
		Candidat leCandidat = null;
		try (Connection cnx = PoolConnection.getConnection();)
		{
			cnx.setAutoCommit(false);
			
			CallableStatement cmd = cnx.prepareCall("{call SELECT_ONE_CANDIDAT (?,?) }", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cmd.setString(1, id);
			cmd.setString(2, motDePasse);
			
			ResultSet rs = cmd.executeQuery();
			
			int taille = 0;
			while (rs.next()) {
				taille+=1;
			}
			
			//test si le ResultSet ne contient qu'une seule ligne
			if (taille==1)
				{
					rs.first();	
					leCandidat = new Candidat();
					leCandidat.setId(id);
					leCandidat.setNom(rs.getString("Nom"));
					leCandidat.setPrenom(rs.getString("Prenom"));
				}					
			cnx.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return leCandidat;
	}
}
