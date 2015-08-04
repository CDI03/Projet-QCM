package fr.eni_ecole.jee.bo;

public class Employe {
	
	private String id;
	private String matricule;
	private String nom;
	private String prenom;
	private String courriel;
	private String fonction;
	
	public Employe() {
		super();
	}

	public Employe(String id, String matricule, String nom, String prenom,
			String courriel, String fonction) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.fonction = fonction;
	}

	
	
	public String getId() {
		return id;
	}

	public String getMatricule() {
		return matricule;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public String getFonction() {
		return fonction;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	public void setId(String id) {
		this.id = id;
	}

}
