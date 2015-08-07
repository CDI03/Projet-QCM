package fr.eni_ecole.jee.bo;

public class Formation {

	private String id;
	private String titre;
	
	public Formation() {
		super();
	}

	public Formation(String id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	public String getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
