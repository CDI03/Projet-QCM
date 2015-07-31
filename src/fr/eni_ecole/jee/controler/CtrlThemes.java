package fr.eni_ecole.jee.controler;

import java.util.ArrayList;
import java.util.List;

import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.dal.DalThemes;

public class CtrlThemes {
	
	private List<Theme> listThemes;
	
	public static List<Theme> GetAll() {
		return DalThemes.GetAll();
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
