package fr.eni_ecole.jee.controler;

import java.sql.SQLException;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.dal.DalCandidat;

public class CtrlCandidat {

	public static boolean Insert(Candidat candidat) throws SQLException, NamingException
	{
		return DalCandidat.Insert(candidat);
	}

	public static Candidat SelectOne(String id, String mdp) throws SQLException, NamingException 
	{
		return DalCandidat.SelectOne(id, mdp);
	}
}
