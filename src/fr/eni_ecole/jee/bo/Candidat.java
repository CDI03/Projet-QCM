package fr.eni_ecole.jee.bo;

public class Candidat {
	
	private String id;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	public Candidat() {
		super();
	}

	public Candidat(String id, String nom, String prenom,
			String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	public String getId() {
		return id;
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

	public void setId(String id) {
		this.id = id;
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
