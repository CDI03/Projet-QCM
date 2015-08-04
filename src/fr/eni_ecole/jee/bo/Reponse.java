package fr.eni_ecole.jee.bo;

public class Reponse {
	
	private String id; 
	private Question question;
	private String libelle;
	private boolean estCorrect;
	
	public Reponse() {
		super();
	}

	public Reponse(String id, Question question, String libelle,
			boolean estCorrect) {
		super();
		this.id = id;
		this.question = question;
		this.libelle = libelle;
		this.estCorrect = estCorrect;
	}

	public String getid() {
		return id;
	}

	public Question getQuestion() {
		return question;
	}

	public String getLibelle() {
		return libelle;
	}

	public boolean isEstCorrect() {
		return estCorrect;
	}

	public void setid(String id) {
		this.id = id;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setEstCorrect(boolean estCorrect) {
		this.estCorrect = estCorrect;
	}
	
	
	
	
}
