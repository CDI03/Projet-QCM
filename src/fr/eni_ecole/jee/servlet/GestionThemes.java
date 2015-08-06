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
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.controler.CtrlQuestions;
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
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		}
	}
	


	private void processRequestSelectAll (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, ArrayList> hashMapThemes = new HashMap<String, ArrayList>();
		try {
			hashMapThemes = CtrlThemes.SelectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		request.setAttribute("listThemes", hashMapThemes.get("listThemes"));
		request.setAttribute("listCompetences", hashMapThemes.get("listCompetences"));
		request.setAttribute("listAllCompetences", hashMapThemes.get("listAllCompetences"));
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
		Question uneQuestion =  new Question();
		List<Question> listQuestions = new ArrayList<Question>();
		listQuestions = CtrlQuestions.SelectByTheme();
		request.setAttribute("listQuestions", listQuestions);
		request.setAttribute("action", "ok");
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GestionThemes");
		rd.forward(request, response);
	}
	
	
	
}
