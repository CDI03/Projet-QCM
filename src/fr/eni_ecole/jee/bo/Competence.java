package fr.eni_ecole.jee.bo;

public class Competence {

	private String libelle;
	private Formation formation;
	
	public Competence() {
		super();
	}
	public Competence(String libelle, Formation formation) {
		super();
		this.libelle = libelle;
		this.formation = formation;
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

	
	
}
