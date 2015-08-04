package fr.eni_ecole.jee.bo;


public class Test {
	
	private int id;
	private String libelle;
	private int duree;
	private int seuilHaut;
	private int seuilBas;
	
	public Test() {
		super();
	}

	public Test(int id, String libelle, int duree, int seuilHaut, int seuilBas) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public int getDuree() {
		return duree;
	}

	public int getSeuilHaut() {
		return seuilHaut;
	}

	public int getSeuilBas() {
		return seuilBas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setSeuilHaut(int seuilHaut) {
		this.seuilHaut = seuilHaut;
	}

	public void setSeuilBas(int seuilBas) {
		this.seuilBas = seuilBas;
	}
	
	
	
	
	

}
