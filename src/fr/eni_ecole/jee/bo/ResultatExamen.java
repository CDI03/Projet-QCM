package fr.eni_ecole.jee.bo;

public class ResultatExamen {

	private Examen examen;
	private Section section;
	private int nbrQuestionsReussies;
	private int nbrQuestionsTotales;
	
	public ResultatExamen() {
		super();
	}

	public ResultatExamen(Examen examen, Section section,
			int nbrQuestionsReussies, int nbrQuestionsTotales) {
		super();
		this.examen = examen;
		this.section = section;
		this.nbrQuestionsReussies = nbrQuestionsReussies;
		this.nbrQuestionsTotales = nbrQuestionsTotales;
	}

	public Examen getExamen() {
		return examen;
	}

	public Section getSection() {
		return section;
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

	public void setSection(Section section) {
		this.section = section;
	}

	public void setNbrQuestionsReussies(int nbrQuestionsReussies) {
		this.nbrQuestionsReussies = nbrQuestionsReussies;
	}

	public void setNbrQuestionsTotales(int nbrQuestionsTotales) {
		this.nbrQuestionsTotales = nbrQuestionsTotales;
	}
	
	
}
