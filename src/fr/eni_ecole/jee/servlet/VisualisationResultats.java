package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Inscription;
import fr.eni_ecole.jee.bo.ResultatExamen;
import fr.eni_ecole.jee.controler.CtrlExamen;
import fr.eni_ecole.jee.controler.CtrlInscription;
import fr.eni_ecole.jee.controler.CtrlResultatsExamen;
import fr.eni_ecole.jee.controler.CtrlTest;

/**
 * Servlet implementation class VisualisationResultats
 */
public class VisualisationResultats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Examen examenChoisit;
	private Candidat leCandidatChoisit;
	private ArrayList<ResultatExamen> resultatsDuCandidat;
	
	private ArrayList<Inscription> listDesInscrits;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualisationResultats() {
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

	
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {			
			//Brouillon à revoir avec la mise en forme pour l'acces formateur
			
			leCandidatChoisit = (Candidat)request.getSession().getAttribute("candidatConnecte");
			request.setAttribute("leCandidatChoisit", leCandidatChoisit);
			
			
			examenChoisit = (Examen) request.getAttribute("lExamenEnCours");
			request.setAttribute("examenChoisit", examenChoisit);
			
			resultatsDuCandidat = CtrlResultatsExamen.SelectAll(examenChoisit);
			request.setAttribute("resultatsDuCandidat", resultatsDuCandidat);
			
			listDesInscrits = CtrlInscription.SelectAll();
			request.setAttribute("listDesInscrits", listDesInscrits);
			
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/visualisationResultats/visualisationResultats.jsp");	
			rd.forward(request, response);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
