package fr.eni_ecole.jee.bo;

public class Inscription {
	private Promotion promotion;
	private Formation formation;
	private Candidat candidat;
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inscription(Promotion promotion, Formation formation,
			Candidat candidat) {
		super();
		this.promotion = promotion;
		this.formation = formation;
		this.candidat = candidat;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public Formation getFormation() {
		return formation;
	}
	public Candidat getCandidat() {
		return candidat;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	
}
