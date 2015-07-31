package fr.eni_ecole.jee.bo;

public class Theme {
	
	private String libelle;
	private Competence competence;
	private Formation formation;
	
	public Theme() {
		super();
	}

	public Theme(String libelle, Competence competence, Formation formation) {
		super();
		this.libelle = libelle;
		this.competence = competence;
		this.formation = formation;
	}

	public String getLibelle() {
		return libelle;
	}

	public Competence getCompetence() {
		return competence;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	
	
	

}
