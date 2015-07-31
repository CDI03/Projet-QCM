package fr.eni_ecole.jee.bo;

public class Formation {

	private String code;
	private String titre;
	
	public Formation() {
		super();
	}

	public Formation(String code, String titre) {
		super();
		this.code = code;
		this.titre = titre;
	}

	public String getCode() {
		return code;
	}

	public String getTitre() {
		return titre;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
