package fr.eni_ecole.jee.outils;

import java.util.TimerTask;

public class TimerTaskExamen extends TimerTask {

	private int tempsRestant; 
	
	public TimerTaskExamen() {
		super();
	}
	
	public TimerTaskExamen(int tempsRestant) {
		super();
		this.tempsRestant = tempsRestant;
	}

	public int getTempsRestant() {
		return tempsRestant;
	}

	public void setTempsRestant(int tempsRestant) {
		this.tempsRestant = tempsRestant;
	}

	@Override
	public void run() {
		this.tempsRestant = this.tempsRestant + 6000;
		System.out.println(tempsRestant);
	}
	
}
