package fr.eni_ecole.jee.bo;

public class Promotion {
	private int numero;
	private String code;
	private Formation formation;
	private Employe employe;
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(int numero, String code, Formation formation,
			Employe employe) {
		super();
		this.numero = numero;
		this.code = code;
		this.formation = formation;
		this.employe = employe;
	}
	public int getNumero() {
		return numero;
	}
	public String getCode() {
		return code;
	}
	public Formation getFormation() {
		return formation;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
