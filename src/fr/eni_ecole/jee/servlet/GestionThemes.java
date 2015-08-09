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
		
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("formationSelectionnee"));
		System.out.println(request.getParameter("competenceSelectionnee"));
		System.out.println(request.getParameter("themeSelectionne"));
		System.out.println(request.getParameter("questionSelectionnee"));
		System.out.println(request.getParameter("reponseSelectionnee"));
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
		
		String idFormation = null;
		int idCompetence;
		int idTheme;
		int idQuestion;
		int idReponse;
		
		Formation formationSelectionnee = new Formation();
		Competence competenceSelectionnee = new Competence();
		Theme themeSelectionne = new Theme();
		Question questionSelectionnee = new Question();
		Reponse reponseSelectionnee = new Reponse();
		
		List<Formation> listFormations = new ArrayList<Formation>();
		List<Competence> listCompetences = new ArrayList<Competence>();
		List<Theme> listThemes = new ArrayList<Theme>();
		List<Question> listQuestions = new ArrayList<Question>();
		List<Reponse> listReponses = new ArrayList<Reponse>();
		
		try {
			
			listFormations = CtrlFormation.SelectAll();
			if (request.getParameter("formationSelectionnee") != null ) {
				idFormation = request.getParameter("formationSelectionnee");
				for (Formation f : listFormations) {
					if (f.getId().equalsIgnoreCase(idFormation)) {
						formationSelectionnee = f;
					}
				}
				

			} else {
				//TODO a corriger pour le cas de nullité
				//la vrai ligne cidessous
				// !!!!! formationSelectionnee = listFormations.get(0); !!!!!!!!!!!!
				formationSelectionnee = listFormations.get(1);
				idFormation = formationSelectionnee.getId();
			}
		
			listCompetences = CtrlCompetence.SelectAllByFormation(idFormation);
			if (request.getParameter("competenceSelectionnee") != null ) {
				idCompetence = Integer.parseInt(request.getParameter("competenceSelectionnee"));
				for (Competence c : listCompetences) {
					if (c.getId() == idCompetence) {
						competenceSelectionnee = c;
					}
				}
			} else {
				competenceSelectionnee = listCompetences.get(0);
				idCompetence = competenceSelectionnee.getId();
			}
			
			listThemes = CtrlTheme.SelectAllByCompetence(idCompetence);
			if (request.getParameter("themeSelectionne") != null ) {
				idTheme = Integer.parseInt(request.getParameter("themeSelectionne"));
				for (Theme t : listThemes) {
					if (idTheme == t.getId()) {
						themeSelectionne = t ;
					}
				}
			} else {
				themeSelectionne = listThemes.get(0);
				idTheme = themeSelectionne.getId();
			}
			
			listQuestions = CtrlQuestion.SelectAllByTheme(idTheme);
			if (request.getParameter("questionSelectionnee") != null ) {
				idQuestion = Integer.parseInt(request.getParameter("questionSelectionnee"));
				for (Question q : listQuestions) {
					if (idQuestion == q.getId()) {
						questionSelectionnee = q;
					}
				}
			} else {
				questionSelectionnee = listQuestions.get(0);
				idQuestion = questionSelectionnee.getId();
			}
			
			listReponses = CtrlReponse.SelectAllByQuestion(idQuestion);
			if (request.getParameter("reponseSelectionnee") != null) {
				idReponse = Integer.parseInt(request.getParameter("reponseSelectionnee"));
				for (Reponse r : listReponses) {
					if (idReponse == r.getId()) {
						reponseSelectionnee = r;
					}
				}
			} else {
				reponseSelectionnee = listReponses.get(0);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("formationSelectionnee", formationSelectionnee);
		request.setAttribute("competenceSelectionnee", competenceSelectionnee);
		request.setAttribute("themeSelectionne", themeSelectionne);
		request.setAttribute("questionSelectionnee", questionSelectionnee);
		request.setAttribute("reponseSelectionnee", reponseSelectionnee);	
		
		request.setAttribute("listFormations", listFormations);
		request.setAttribute("listCompetences", listCompetences);
		request.setAttribute("listThemes", listThemes);
		request.setAttribute("listQuestions", listQuestions);
		request.setAttribute("listReponses", listReponses);	
		
		System.out.println(((Formation)request.getAttribute("formationSelectionnee")).getId());
		System.out.println(((Competence)request.getAttribute("competenceSelectionnee")).getId());
		System.out.println(((Theme)request.getAttribute("themeSelectionne")).getId());
		System.out.println(((Question)request.getAttribute("questionSelectionnee")).getId());
		System.out.println(((Reponse)request.getAttribute("reponseSelectionnee")).getId());
		
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
