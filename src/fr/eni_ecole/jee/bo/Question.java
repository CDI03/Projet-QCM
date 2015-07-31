package fr.eni_ecole.jee.bo;

import java.awt.Image;

public class Question {
	
	private String identifiant;
	private String libelle;
	private String enonce;
	private Theme theme;
	private int nbReponses;
	private Image illustration;
	
	public Question() {
		super();
	}

	public Question(String identifiant, String libelle, String enonce,
			Theme theme, int nbReponses, Image illustration) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.enonce = enonce;
		this.theme = theme;
		this.nbReponses = nbReponses;
		this.illustration = illustration;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getLibelle() {
		return libelle;
	}

	public String getEnonce() {
		return enonce;
	}

	public Theme getTheme() {
		return theme;
	}

	public int getNbReponses() {
		return nbReponses;
	}

	public Image getIllustration() {
		return illustration;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setNbReponses(int nbReponses) {
		this.nbReponses = nbReponses;
	}

	public void setIllustration(Image illustration) {
		this.illustration = illustration;
	}
	
	
	
	
}
