package fr.eni_ecole.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Formation;
import fr.eni_ecole.jee.bo.Inscription;
import fr.eni_ecole.jee.bo.Promotion;
import fr.eni_ecole.jee.outils.PoolConnection;

public class DalInscription {

	public static ArrayList<Inscription> SelectAll() throws SQLException, NamingException {
		
		ArrayList<Inscription> listDesInscrits = new ArrayList<Inscription>();
		
		try (Connection cnx = PoolConnection.getConnection()) {
			CallableStatement cstmt = null;
			cstmt = cnx.prepareCall("{ call SELECT_ALL_INSCRIPTION }");
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				String Code_Promotion = rs.getString("Code_Promotion");
				int Numero_Promotion = rs.getInt("Numero_Promotion");
				String Id_Candidat = rs.getString("Id_Candidat");
				String Nom_Candidat = rs.getString("Nom_Candidat");
				String Prenom_Candidat = rs.getString("Prenom_Candidat");
				String Id_Formation = rs.getString("Id_Formation");
				String Titre_Formation = rs.getString("Titre_Formation");
				
				//construction d'une Promotion
				Promotion laPromotion = new Promotion();
					laPromotion.setCode(Code_Promotion);
					laPromotion.setNumero(Numero_Promotion);
				//construction d'un Candidat
				Candidat leCandidat = new Candidat();
					leCandidat.setId(Id_Candidat);
					leCandidat.setNom(Nom_Candidat);
					leCandidat.setPrenom(Prenom_Candidat);
				//construction d'une Formation
				Formation laFormation = new Formation();
					laFormation.setId(Id_Formation);
					laFormation.setTitre(Titre_Formation);
					laPromotion.setFormation(laFormation);
				//construction d'une Inscription
				Inscription lInscription = new Inscription();
					lInscription.setCandidat(leCandidat);
					lInscription.setFormation(laFormation);
					lInscription.setPromotion(laPromotion);	
				//construction de la liste des Inscriptions
				listDesInscrits.add(lInscription);
			}
		}
		return listDesInscrits;
	}

}
