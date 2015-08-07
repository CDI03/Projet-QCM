package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Competence;
import fr.eni_ecole.jee.bo.Formation;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.controler.CtrlCompetence;
import fr.eni_ecole.jee.controler.CtrlCompetences;
import fr.eni_ecole.jee.controler.CtrlFormation;
import fr.eni_ecole.jee.controler.CtrlQuestion;
import fr.eni_ecole.jee.controler.CtrlReponse;
import fr.eni_ecole.jee.controler.CtrlTheme;
import fr.eni_ecole.jee.controler.CtrlThemes;
import fr.eni_ecole.jee.dal.DalThemes;

/**
 * Servlet implementation class gestionThemes
 */
@WebServlet("/gestionThemes")
public class GestionThemes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionThemes() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("indexFormationSelectionne","0");
		request.setAttribute("indexCompetenceSelectionne","0");
		request.setAttribute("indexThemeSelectionne", "0");
		request.setAttribute("indexQuestionSelectionne", "0");
		request.setAttribute("indexReponseSelectionne", "0");
		request.setAttribute("action", "");
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequestSelectAll (request, response);
		/*
		if (request.getMethod().equalsIgnoreCase("GET") ) {
			processRequestSelectAll (request, response);
		} else if (request.getAttribute("action") == null && request.getParameter("action") == null){
			processRequestSelectAll (request, response);
		} else {
			if (request.getAttribute("action") != null) {
				if (request.getAttribute("action").toString().equalsIgnoreCase("ok")) {
					processRequestSelectAll (request, response);
				}
			} else {
				if (request.getParameter("action").toString().equalsIgnoreCase("insert")) {
					processRequestInsert (request, response);
				} else if (request.getParameter("action").toString().equalsIgnoreCase("update")) {
					processRequestUpdate (request, response);
				} else if (request.getParameter("action").toString().equalsIgnoreCase("delete")) {
					processRequestDelete (request, response);
				} else if (request.getParameter("action").toString().equalsIgnoreCase("load")) {
					processRequestLoad (request, response);
				} else {
					processRequestSelectAll (request, response);
				}
			}
		}*/
	}
	


	private void processRequestSelectAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String idFormation = "CDI";
		int idCompetence = 1;
		int idTheme = 1;
		int idQuestion = 1;
		
		List<Formation> listFormations = new ArrayList<Formation>();
		List<Competence> listCompetences = new ArrayList<Competence>();
		List<Theme> listThemes = new ArrayList<Theme>();
		List<Question> listQuestions = new ArrayList<Question>();
		List<Reponse> listReponses = new ArrayList<Reponse>();
		
		try {
			listFormations = CtrlFormation.SelectAll();
			listCompetences = CtrlCompetence.SelectAllByFormation(idFormation);
			listThemes = CtrlTheme.SelectAllByCompetence(idCompetence);
			listQuestions = CtrlQuestion.SelectAllByTheme(idTheme);
			listReponses = CtrlReponse.SelectAllByQuestion(idQuestion);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listFormations", listFormations);
		request.setAttribute("listCompetences", listCompetences);
		request.setAttribute("listThemes", listThemes);
		request.setAttribute("listQuestions", listQuestions);
		request.setAttribute("listReponses", listReponses);	
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestionThemes/gestionThemes.jsp");
		rd.forward(request, response);	
	}
	
	private void processRequestInsert (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déclaration d'un theme et de sa compétence associé
		Theme unTheme =  new Theme();
		Competence uneCompetence = new Competence();
	
		//Récupération et affection des données
		unTheme.setLibelle(request.getParameter("libelleThemeAAjouter"));
		uneCompetence.setId( Integer.parseInt(request.getParameter("uneCompetenceAssocie")) );
		unTheme.setCompetence(uneCompetence);
		
		//insertion dans la base		
		try {
			CtrlThemes.Insert(unTheme);
			request.setAttribute("action", "ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirection
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GestionThemes");
		rd.forward(request, response);
	}
	
	private void processRequestUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déclaration d'un theme et de sa compétence associé
		Theme unTheme =  new Theme();
		Competence uneCompetence = new Competence();
		//Récupération et affection des données
		unTheme.setId(Integer.parseInt(request.getParameter("unIdTheme")));
		unTheme.setLibelle(request.getParameter("unLibelleTheme"));
		uneCompetence.setId( Integer.parseInt(request.getParameter("lesCompetencesPourModification")) );
		unTheme.setCompetence(uneCompetence);
		//insertion dans la base		
		try {
			CtrlThemes.Update(unTheme);
			request.setAttribute("action", "ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GestionThemes");
		rd.forward(request, response);
	}

	private void processRequestDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Theme unTheme =  new Theme();
		unTheme.setId(Integer.parseInt(request.getParameter("unIdTheme")));
		request.setAttribute("action", "ok");
		try {
			CtrlThemes.Delete(unTheme);
			request.setAttribute("action", "ok");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GestionThemes");
		rd.forward(request, response);
	}
	
	private void processRequestLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Question> listQuestions = new ArrayList<Question>();
		Question uneQuestion =  new Question();
		Theme unTheme = new Theme();
		int idTheme = Integer.parseInt(request.getParameter("unIdTheme"));
		int indexThemeSelectionne = Integer.parseInt(request.getParameter("indexThemeSelectionne"));
		request.setAttribute("indexThemeSelectionne", indexThemeSelectionne);
		unTheme.setId(idTheme);
		try {
			listQuestions = CtrlQuestion.SelectAllByTheme(unTheme.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		request.setAttribute("listQuestions", listQuestions);
		request.setAttribute("action", "ok");
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GestionThemes");
		rd.forward(request, response);
	}
	
}
