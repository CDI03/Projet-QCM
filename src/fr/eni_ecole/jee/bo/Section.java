package fr.eni_ecole.jee.bo;

public class Section {

	private Test test;
	private Theme theme;
	private int nombreQuestion;
	
	public Section() {
		super();
	}

	public Section(Test test, Theme theme, int nombreQuestion) {
		super();
		this.test = test;
		this.theme = theme;
		this.nombreQuestion = nombreQuestion;
	}

	public Test getTest() {
		return test;
	}

	public Theme getTheme() {
		return theme;
	}

	public int getNombreQuestion() {
		return nombreQuestion;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setNombreQuestion(int nombreQuestion) {
		this.nombreQuestion = nombreQuestion;
	}
	
	
	
	
}
