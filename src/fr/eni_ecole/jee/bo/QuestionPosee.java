package fr.eni_ecole.jee.bo;

public class QuestionPosee {
	
	private Examen examen;
	private Question question;
	private int ordre;
	private boolean repondu;
	private boolean marque;
	public QuestionPosee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionPosee(Examen examen, Question question, int ordre,
			boolean repondu, boolean marque) {
		super();
		this.examen = examen;
		this.question = question;
		this.ordre = ordre;
		this.repondu = repondu;
		this.marque = marque;
	}
	public Examen getExamen() {
		return examen;
	}
	public Question getQuestion() {
		return question;
	}
	public int getOrdre() {
		return ordre;
	}
	public boolean isRepondu() {
		return repondu;
	}
	public boolean isMarque() {
		return marque;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public void setRepondu(boolean repondu) {
		this.repondu = repondu;
	}
	public void setMarque(boolean marque) {
		this.marque = marque;
	}
	
	
	
}
