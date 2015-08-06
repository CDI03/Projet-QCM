package fr.eni_ecole.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.controler.CtrlExamen;

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
			HttpServletResponse response)  {
		// Récupérer le nom du submit :
		try {
			String choixBouton = request.getParameter("hiddenField");
			request.setAttribute("choixBouton", choixBouton);
			if(choixBouton.equals("commencerExamen"))
			{
				System.out.println("commence Examen");
				recupTestCandidat(request,response);
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
			{
				System.out.println("ERREUR CHOIX BOUTON!!!!!!");
				request.setAttribute("erreur", "Erreur Choix d'action");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
				rd.forward(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void recupTestCandidat(HttpServletRequest request,
			HttpServletResponse response)  {
		try {
			int idExamen = Integer.parseInt(request.getParameter("lExamen"));
			Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
			Examen lExamen = new Examen();
			lExamen.setId(idExamen);
			lExamen.setCandidat(leCandidatEnCours);
			
			// recupérer via l'examen : le test, les section, thèmes, questions, réponses et enregistrer questions poséees
			CtrlExamen.SelectOne(lExamen);
			
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/passageTest/passageTest.jsp");	
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
