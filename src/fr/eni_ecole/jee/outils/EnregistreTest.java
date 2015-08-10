package fr.eni_ecole.jee.outils;

import java.util.Timer;
import java.util.TimerTask;

public class EnregistreTest {

	Timer t;

	public EnregistreTest() {
		t = new Timer();
		t.schedule(new enregistrement(), 0, 60*100);
		
	}

	public class enregistrement extends TimerTask 
	{
		int tempsRestant;
		
		@Override
		public void run() {
			if (tempsRestant>0)
			{
				System.out.println("Enregistrement");
				tempsRestant--;
			}
			else
			{
				
				t.cancel();
			}
		}
	
		@Override
		public boolean cancel() {
			System.out.println("Fin enregistrement");
			return super.cancel();
		}
	}

	
}
