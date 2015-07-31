package fr.eni_ecole.jee.bo;

public class ReponseDonnee {
	
	private QuestionPosee questionPosee;
	private Reponse reponse;
	
	public ReponseDonnee() {
		super();
	}

	public ReponseDonnee(QuestionPosee questionPosee, Reponse reponse) {
		super();
		this.questionPosee = questionPosee;
		this.reponse = reponse;
	}

	public QuestionPosee getQuestionPosee() {
		return questionPosee;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setQuestionPosee(QuestionPosee questionPosee) {
		this.questionPosee = questionPosee;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}
	
}
