package fr.eni_ecole.jee.bo;

import java.util.Date;

public class Examen {
	
	private int id;
	private Test test;
	private Candidat candidat;
	private int tempsRestant;
	private Date datePassage;
	private String etat;
	
	public Examen() {
		super();
	}

	public Examen(int id, Test test, Candidat candidat,
			int tempsRestant, Date datePassage, String etat) {
		super();
		this.id = id;
		this.test = test;
		this.candidat = candidat;
		this.tempsRestant = tempsRestant;
		this.datePassage = datePassage;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public Test getTest() {
		return test;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public String getEtat() {
		return etat;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	


}
