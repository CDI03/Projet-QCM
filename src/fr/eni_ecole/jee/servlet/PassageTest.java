package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.controler.CtrlExamen;
import fr.eni_ecole.jee.controler.CtrlTest;

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
				int numQuestionEnCours = 0;
				request.setAttribute("numQuestionEnCours", numQuestionEnCours);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void recupTestCandidat(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, NamingException  {
		try {
			int idExamen = Integer.parseInt(request.getParameter("lExamen"));
			Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
			ArrayList<Examen> examensDuCandidat = (ArrayList<Examen>)request.getAttribute("examenDuCandidat");
			Examen examenChoisit = null;
			for (Examen examen : examensDuCandidat) {
				if ((examen.getId()) == idExamen) {
					examenChoisit = examen;
				}
			}
			// recupérer via le test: les section, thèmes, questions, réponses et enregistrer questions poséees
			Map<String, ArrayList> hashMapDeLExamen = new HashMap<String, ArrayList>();
			hashMapDeLExamen = CtrlExamen.SelectOne(examenChoisit);

			request.setAttribute("listQuestionExamen", hashMapDeLExamen.get("listQuestionExamen"));
			request.setAttribute("listReponseExamen", hashMapDeLExamen.get("listReponseExamen"));
			request.setAttribute("lExamenEnCours", examenChoisit);
			
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/passageTest/passageTest.jsp");	
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
