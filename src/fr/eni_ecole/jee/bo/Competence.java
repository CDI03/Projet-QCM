package fr.eni_ecole.jee.bo;

public class Competence {

	private int id;
	private String libelle;
	private Formation formation;
	
	public Competence() {
		super();
	}

	public Competence(int id, String libelle, Formation formation) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.formation = formation;
	}

	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
