package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
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
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	

	private void processRequestSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idFormation;
		int idCompetence;
		int idTheme;
		int idTest;
		
		Formation uneFormation = new Formation();
		Competence uneCompetence = new Competence();
		Theme unTheme = new Theme();
		Test unTest = new Test();
		
		List<Formation> listFormations = new ArrayList<Formation>();
		List<Competence> listCompetences = new ArrayList<Competence>();
		List<Theme> listThemes = new ArrayList<Theme>();
		List<Test> listTests = new ArrayList<Test>();

		try {
			listFormations = CtrlFormation.SelectAll();;
			uneFormation = RecupFormation(request, listFormations);
			
			listCompetences = CtrlCompetence.SelectAllByFormation(uneFormation.getId());
			uneCompetence = RecupCompetence(request, listCompetences);
			
			listThemes = CtrlTheme.SelectAllByCompetence(uneCompetence.getId());
			unTheme =  RecupTheme(request, uneCompetence, listThemes);
			
			listTests = CtrlTest.SelectAll();
			unTest =  RecupTest(request, listTests);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("formationSelectionnee", uneFormation);
		request.setAttribute("competenceSelectionnee", uneCompetence);
		request.setAttribute("themeSelectionne", unTheme);
		request.setAttribute("testSelectionne", unTest);
		
		request.setAttribute("listFormations", listFormations);
		request.setAttribute("listCompetences", listCompetences);
		request.setAttribute("listThemes", listThemes);
		request.setAttribute("listTests", listTests);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestionTests/gestionTests.jsp");
		rd.forward(request, response);	
		
	}
	
	
	
	
	
	
	
	
	/////////////////////////////////
	// RECUPERATION DES PARAMETRES //
	/////////////////////////////////
	
	private static Formation RecupFormation(HttpServletRequest request, List<Formation> listFormations) {
		Formation uneFormation = new Formation();
		String idFormationSelectionnee = request.getParameter("idFormationSelectionnee");
		if (idFormationSelectionnee != null) {
			uneFormation.setId(idFormationSelectionnee);
		} else {
			//TODO gérer le cas null
			uneFormation = listFormations.get(1);
		}
		return uneFormation;
	}
	
	private static Competence RecupCompetence(HttpServletRequest request, List<Competence> listCompetences) {
		Competence uneCompetence = new Competence();
		String idCompetenceSelectionnee = request.getParameter("idCompetenceSelectionnee");
		if (idCompetenceSelectionnee != null) {
			uneCompetence.setId(Integer.parseInt(idCompetenceSelectionnee));
		} else {
			uneCompetence = listCompetences.get(0);
		}
		return uneCompetence;
	}
	
	private static Theme RecupTheme(HttpServletRequest request, Competence uneCompetence, List<Theme> listThemes) {
		Theme unTheme =  new Theme();
		String idThemeSelectionne = request.getParameter("idThemeSelectionne");
		if (idThemeSelectionne != null) {
			unTheme.setId(Integer.parseInt(idThemeSelectionne));
		} else {
			unTheme = listThemes.get(0);
		}
		return unTheme;
	}
	
	private static Test RecupTest(HttpServletRequest request, List<Test> listTest) {
		Test unTest = new Test();
		String idTestSelectionne = request.getParameter("idTestSelectionne");
		if (idTestSelectionne != null) {
			unTest.setId(Integer.parseInt(idTestSelectionne) );
		} else {
			unTest = listTest.get(0);
		}	
		return unTest;
	}
	
	
	
	
	
}
