package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalCompetence;
import fr.eni_ecole.jee.dal.DalTheme;

public class CtrlTheme {

	public static List<Theme> SelectAllByCompetence(int idCompetence) throws SQLException, NamingException {
		return DalTheme.SelectAllByCompetence(idCompetence);
	}

	public static boolean Insert(Theme unTheme) throws SQLException, NamingException {
		return DalTheme.Insert(unTheme);
		
	}

	public static boolean Update(Theme unTheme) throws SQLException, NamingException {
		return DalTheme.Update(unTheme);
		
	}

	public static boolean Delete(int idTheme) throws SQLException, NamingException {
		return DalTheme.Delete(idTheme);
		
	}

	public static Theme SelectOne(int idTheme) throws SQLException, NamingException {
		return DalTheme.SelectOne(idTheme);
	}

}
