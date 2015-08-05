package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.dal.DalCompetences;


public class CtrlCompetences {
	
	private List<Competence> listCompetence;
	
	public static List<Competence> SelectAllSimple() throws SQLException, NamingException {
		return DalCompetences.SelectAllSimple();
	}
	
	public static List<Competence> SelectAll() throws SQLException, NamingException {
		return DalCompetences.SelectAll();
	}
	
	public static boolean Insert(Competence competence) throws SQLException, NamingException {
		return DalCompetences.Insert(competence);
	}
	
	public static boolean Update(Competence competence) throws SQLException, NamingException {
		return DalCompetences.Update(competence);
	}
	
	public static boolean Delete(Competence competence) {
		return DalCompetences.Delete(competence);
	}
	
	public static Competence SelectOne(Competence competence) {
		return DalCompetences.SelectOne(competence);
	}
}
