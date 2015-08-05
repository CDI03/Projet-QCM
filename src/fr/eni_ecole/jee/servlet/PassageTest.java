package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassageTest
 */
public class PassageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassageTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// Récupérer le nom du submit :
		String choixBouton = request.getParameter("hiddenField");
		if(choixBouton.equals("commencerExamen"))
		{
			System.out.println("commence Examen");
		}
		else if (choixBouton.equals("reprendreExamen"))
		{
			System.out.println("reprend Examen");
		}
		else if (choixBouton.equals("resultatExamen"))
		{
			System.out.println("affiche resultats Examen");
		}
		else
		{System.out.println("ERREUR CHOIX BOUTON!!!!!!");}
	}

}
