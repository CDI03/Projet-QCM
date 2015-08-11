package fr.eni_ecole.jee.controler;

import java.util.List;

import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.dal.DalSection;

public class CtrlSection {

	public static List<Section> SelectAllByTest(int idTest) {
		return DalSection.SelectAllByTest(idTest);
	}

}
