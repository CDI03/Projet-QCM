package fr.eni_ecole.jee.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalThemes;

public class CtrlThemes {
	
	private List<Theme> listThemes;
	
	public static Map<String, ArrayList> SelectAll() throws SQLException, NamingException {
		return DalThemes.SelectAll();
	}
	
	public static boolean Insert(Theme theme) {
		return DalThemes.Insert(theme);
	}
	
	public static boolean Update(Theme theme) {
		return DalThemes.Update(theme);
	}
	
	public static boolean Delete(Theme theme) {
		return DalThemes.Delete(theme);
	}
	
	public static Theme GetOne(Theme theme) {
		return DalThemes.GetOne(theme);
	}
	
	
	
	
	
}
