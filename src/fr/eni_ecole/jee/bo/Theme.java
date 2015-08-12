package fr.eni_ecole.jee.bo;

public class Theme {
	
	private int id;
	private String libelle;
	private Competence competence;
	private int nbQuestions;
	
	public Theme() {
		super();
	}

	public Theme(int id, String libelle, Competence competence) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.competence = competence;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public int getNbQuestions() {
		return nbQuestions;
	}

	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	
	
	
	
	

}
