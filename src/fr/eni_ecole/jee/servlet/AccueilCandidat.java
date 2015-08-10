package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.controler.CtrlExamen;

/**
 * Servlet implementation class AccueilCandidat
 */
public class AccueilCandidat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilCandidat() {
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
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
			HttpSession session = request.getSession(true);   
			
			if (leCandidatEnCours != null)
				{
					ArrayList<Examen> examenDuCandidat = CtrlExamen.SelectAll(leCandidatEnCours);
					session.setAttribute("examenDuCandidat", examenDuCandidat);
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/accueilCandidat/acceuilCandidat.jsp");	
					rd.forward(request, response);
				}
			else
			{
				//Pb d'accès - candidat non connecté
				request.setAttribute("erreur", "Vous n'avez pas le droit d'accéder à cette page");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionSQL", "Une exception SQL est survenue. Veuillez contacter votre administrateur");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
			rd.forward(request, response);
		}		
	}

	
}
