package fr.eni_ecole.jee.bo;

public class Candidat {
	
	private String identifiant;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	public Candidat() {
		super();
	}

	public Candidat(String identifiant, String nom, String prenom,
			String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
