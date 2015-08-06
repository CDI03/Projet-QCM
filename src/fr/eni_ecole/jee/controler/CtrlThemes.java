package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalCompetences;
import fr.eni_ecole.jee.dal.DalThemes;

public class CtrlThemes {
	
	private List<Theme> listThemes;
	
	public static Map<String, ArrayList> SelectAll() throws SQLException, NamingException {
		Map<String, ArrayList> mapThemes = DalThemes.SelectAll();
		ArrayList<Competence> listAllCompetences = DalCompetences.SelectAllSimple();
		mapThemes.put("listAllCompetences", (ArrayList) listAllCompetences);
		return mapThemes;
	}
	
	public static boolean Insert(Theme theme) throws SQLException, NamingException {
		return DalThemes.Insert(theme);
	}
	
	public static boolean Update(Theme theme) throws SQLException, NamingException {
		return DalThemes.Update(theme);
	}
	
	public static boolean Delete(Theme theme) throws SQLException, NamingException {
		return DalThemes.Delete(theme);
	}
	
	public static Theme SelectOne(Theme theme) {
		return DalThemes.SelectOne(theme);
	}
	
	
	
	
	
}
