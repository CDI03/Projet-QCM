package fr.eni_ecole.jee.bo;

public class Reponse {
	
	private String identifiant; 
	private Question question;
	private String libelle;
	private boolean estCorrect;
	
	public Reponse() {
		super();
	}

	public Reponse(String identifiant, Question question, String libelle,
			boolean estCorrect) {
		super();
		this.identifiant = identifiant;
		this.question = question;
		this.libelle = libelle;
		this.estCorrect = estCorrect;
	}

	public String getIdentifiant() {
		return identifiant;
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

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
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
