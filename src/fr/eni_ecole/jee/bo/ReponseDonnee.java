package fr.eni_ecole.jee.bo;

public class ReponseDonnee {
	
	private Examen examen;
	private QuestionPosee questionPosee;
	private Reponse reponse;
	private Question question;
	
	public ReponseDonnee() {
		super();
	}

	public ReponseDonnee(Examen examen, QuestionPosee questionPosee,
			Reponse reponse, Question question) {
		super();
		this.examen = examen;
		this.questionPosee = questionPosee;
		this.reponse = reponse;
		this.question = question;
	}

	public Examen getExamen() {
		return examen;
	}

	public QuestionPosee getQuestionPosee() {
		return questionPosee;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public Question getQuestion() {
		return question;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public void setQuestionPosee(QuestionPosee questionPosee) {
		this.questionPosee = questionPosee;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	
}
