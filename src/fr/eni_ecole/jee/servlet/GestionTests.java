package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Formation;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.controler.CtrlCompetence;
import fr.eni_ecole.jee.controler.CtrlFormation;
import fr.eni_ecole.jee.controler.CtrlTest;
import fr.eni_ecole.jee.controler.CtrlTheme;

/**
 * Servlet implementation class GestionTests
 */
public class GestionTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionTests() {
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
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		if (request.getMethod().equalsIgnoreCase("GET") ) {
			processRequestSelectAll (request, response);
		} else {
			if (request.getParameter("action") == null){
				processRequestSelectAll (request, response);
			} else if(request.getParameter("action").toString().equalsIgnoreCase("insertQuestion")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					//processRequestInsertQuestion (request, response);
				}
			} else {
				processRequestSelectAll (request, response);
			}
		}
	}
	
	

	private void processRequestSelectAll(HttpServletRequest request, HttpServletResponse response) {
		
		
		List<Formation> listFormations = CtrlFormation.SelectAll();;
		Formation uneFormation = RecupFormation(request);
		
		String idFormation = "CDI";
		List<Competence> listCompetences = CtrlCompetence.SelectAllByFormation(idFormation);
		Competence uneCompetence = RecupCompetence(request);
		
		int idCompetence = 1;
		List<Theme> listThemes = CtrlTheme.SelectAllByCompetence(idCompetence);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		
		List<Test> listTests = CtrlTest.SelectAllByCompetence(idCompetence);
		Test unTest =  RecupTest(request);
		
		
		
		/*
		request.setAttribute("formationSelectionnee", formationSelectionnee);
		request.setAttribute("competenceSelectionnee", competenceSelectionnee);
		request.setAttribute("themeSelectionne", themeSelectionne);
		request.setAttribute("questionSelectionnee", questionSelectionnee);
		request.setAttribute("reponseSelectionnee", reponseSelectionnee);	
		
		request.setAttribute("listFormations", listFormations);
		request.setAttribute("listCompetences", listCompetences);
		request.setAttribute("listThemes", listThemes);
		request.setAttribute("listQuestions", listQuestions);
		request.setAttribute("listReponses", listReponses);*/
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestionTests/gestionTests.jsp");
		rd.forward(request, response);	
		
	}
	
	
	
	
	
	
	
	
	/////////////////////////////////
	// RECUPERATION DES PARAMETRES //
	/////////////////////////////////
	
	private static Formation RecupFormation(HttpServletRequest request) {
		Formation uneFormation = new Formation();
		uneFormation.setId(request.getParameter("idFormationSelectionnee"));
		return uneFormation;
	}
	
	private static Competence RecupCompetence(HttpServletRequest request) {
		Competence uneCompetence = new Competence();
		uneCompetence.setId(Integer.parseInt(request.getParameter("idCompetenceSelectionnee")) );
		return uneCompetence;
	}
	
	private static Theme RecupTheme(HttpServletRequest request, Competence uneCompetence) {
		Theme unTheme =  new Theme();
		unTheme.setId(Integer.parseInt(request.getParameter("idThemeSelectionne")) );
		unTheme.setLibelle(request.getParameter("libelleThemeSelectionne"));
		unTheme.setCompetence(uneCompetence);
		return unTheme;
	}
	
	private static Test RecupTest(HttpServletRequest request) {
		Test unTest = new Test();
		unTest.setId(Integer.parseInt(request.getParameter("idTestSelectionne")) );
		return unTest;
	}
	
	
	
	
	
}
