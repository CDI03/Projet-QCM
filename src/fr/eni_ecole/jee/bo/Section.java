package fr.eni_ecole.jee.bo;

public class Section {

	private int numero;
	private Test test;
	private Theme theme;
	private int nombreQuestion;
	
	public Section() {
		super();
	}

	public Section(int numero, Test test, Theme theme, int nombreQuestion) {
		super();
		this.numero = numero;
		this.test = test;
		this.theme = theme;
		this.nombreQuestion = nombreQuestion;
	}

	public int getNumero() {
		return numero;
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

	public void setNumero(int numero) {
		this.numero = numero;
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
