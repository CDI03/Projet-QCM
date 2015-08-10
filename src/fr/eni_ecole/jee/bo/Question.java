package fr.eni_ecole.jee.bo;

import java.awt.Image;

public class Question {
	
	private int id;
	private String enonce;
	private Theme theme;
	private int nbReponses;
	private Image illustration;
	
	public Question() {
		super();
	}

	public Question(int id, String enonce, Theme theme, int nbReponses, Image illustration) {
		super();
		this.id = id;
		this.enonce = enonce;
		this.theme = theme;
		this.illustration = illustration;
	}

	public int getId() {
		return id;
	}

	public String getEnonce() {
		return enonce;
	}

	public Theme getTheme() {
		return theme;
	}

	public Image getIllustration() {
		return illustration;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public void setIllustration(Image illustration) {
		this.illustration = illustration;
	}
	
	
	
	
}
