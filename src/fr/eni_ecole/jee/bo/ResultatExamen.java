package fr.eni_ecole.jee.bo;

/**
 * @author abernard2015
 *
 */
public class ResultatExamen {

	private Examen examen;
	private Test test;
	private Theme theme;
	private int nbrQuestionsReussies;
	private int nbrQuestionsTotales;
	
	public ResultatExamen() {
		super();
	}

	public ResultatExamen(Examen examen, Test test, Theme theme,
			int nbrQuestionsReussies, int nbrQuestionsTotales) {
		super();
		this.examen = examen;
		this.test = test;
		this.theme = theme;
		this.nbrQuestionsReussies = nbrQuestionsReussies;
		this.nbrQuestionsTotales = nbrQuestionsTotales;
	}

	public Examen getExamen() {
		return examen;
	}

	public Test getTest() {
		return test;
	}

	public Theme getTheme() {
		return theme;
	}

	public int getNbrQuestionsReussies() {
		return nbrQuestionsReussies;
	}

	public int getNbrQuestionsTotales() {
		return nbrQuestionsTotales;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setNbrQuestionsReussies(int nbrQuestionsReussies) {
		this.nbrQuestionsReussies = nbrQuestionsReussies;
	}

	public void setNbrQuestionsTotales(int nbrQuestionsTotales) {
		this.nbrQuestionsTotales = nbrQuestionsTotales;
	}
	
	
}
