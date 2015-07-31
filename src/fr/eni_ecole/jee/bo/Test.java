package fr.eni_ecole.jee.bo;

import java.sql.Timestamp;

public class Test {
	
	private String libelle;
	private Timestamp duree;
	private int seuilHaut;
	private int seuilBas;
	
	public Test() {
		super();
	}

	public Test(String libelle, Timestamp duree, int seuilHaut, int seuilBas) {
		super();
		this.libelle = libelle;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
	}

	public String getLibelle() {
		return libelle;
	}

	public Timestamp getDuree() {
		return duree;
	}

	public int getSeuilHaut() {
		return seuilHaut;
	}

	public int getSeuilBas() {
		return seuilBas;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDuree(Timestamp duree) {
		this.duree = duree;
	}

	public void setSeuilHaut(int seuilHaut) {
		this.seuilHaut = seuilHaut;
	}

	public void setSeuilBas(int seuilBas) {
		this.seuilBas = seuilBas;
	}

	
	
	

}
