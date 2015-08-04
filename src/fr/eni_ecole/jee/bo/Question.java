package fr.eni_ecole.jee.bo;

import java.awt.Image;

public class Question {
	
	private String id;
	private String enonce;
	private Theme theme;
	private int nbReponses;
	private Image illustration;
	
	public Question() {
		super();
	}

	public Question(String id, String enonce, Theme theme, int nbReponses, Image illustration) {
		super();
		this.id = id;
		this.enonce = enonce;
		this.theme = theme;
		this.nbReponses = nbReponses;
		this.illustration = illustration;
	}

	public String getid() {
		return id;
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

	public void setid(String id) {
		this.id = id;
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
