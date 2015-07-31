package fr.eni_ecole.jee.bo;

import java.sql.Timestamp;
import java.util.Date;

public class Examen {
	
	private String identifiant;
	private Test test;
	private Candidat candidat;
	private Timestamp tempsRestant;
	private Date datePassage;
	private String etat;
	
	public Examen() {
		super();
	}

	public Examen(String identifiant, Test test, Candidat candidat,
			Timestamp tempsRestant, Date datePassage, String etat) {
		super();
		this.identifiant = identifiant;
		this.test = test;
		this.candidat = candidat;
		this.tempsRestant = tempsRestant;
		this.datePassage = datePassage;
		this.etat = etat;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public Test getTest() {
		return test;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public Timestamp getTempsRestant() {
		return tempsRestant;
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public String getEtat() {
		return etat;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public void setTempsRestant(Timestamp tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	


}
