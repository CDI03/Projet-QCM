package fr.eni_ecole.jee.controler;

import java.util.List;

import fr.eni_ecole.jee.bo.Question;

public class CtrlQuestions {

	public static List<Question> SelectByTheme() {
		return DalQuestion.SelectByTheme();
	}

}
