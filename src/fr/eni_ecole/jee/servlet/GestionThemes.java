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
import fr.eni_ecole.jee.controler.CtrlFormation;
import fr.eni_ecole.jee.controler.CtrlQuestion;
import fr.eni_ecole.jee.controler.CtrlReponse;
import fr.eni_ecole.jee.controler.CtrlTheme;

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
		} else {
			if (request.getParameter("action") == null){
				processRequestSelectAll (request, response);
			} else if(request.getParameter("action").toString().equalsIgnoreCase("insertQuestion")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestInsertQuestion (request, response);
				}
			} else if ( request.getParameter("action").toString().equalsIgnoreCase("updateQuestion")  ) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestUpdateQuestion (request, response);
				}
			} else if (request.getParameter("action").toString().equalsIgnoreCase("deleteQuestion")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestDeleteQuestion (request, response);
				}
			} else if(request.getParameter("action").toString().equalsIgnoreCase("insertReponse")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestInsertReponse (request, response);
				}
			} else if ( request.getParameter("action").toString().equalsIgnoreCase("updateReponse")  ) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestUpdateReponse (request, response);
				}
			} else if (request.getParameter("action").toString().equalsIgnoreCase("deleteReponse")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
				processRequestDeleteReponse (request, response);
				}
			} else if (request.getParameter("action").toString().equalsIgnoreCase("insertTheme")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestInsertTheme (request, response);
				}
				
			} else if (request.getParameter("action").toString().equalsIgnoreCase("updateTheme")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {		
					processRequestUpdateTheme (request, response);
				}
			} else if (request.getParameter("action").toString().equalsIgnoreCase("deleteTheme")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestDeleteTheme (request, response);
				}
			} else {
				processRequestSelectAll (request, response);
			}
		}
	}
	
	
	///////////////////////////
	// GESTION DES QUESTIONS //
	///////////////////////////
	
	private void processRequestDeleteQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//suppression dans la base		
		try {
			Boolean deleteOk = CtrlQuestion.Delete(uneQuestion.getId());
			request.setAttribute("action", "deleteQuestionOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		processRequestSelectAll (request, response);
		
	}

	private void processRequestUpdateQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//insertion dans la base		
		try {
			Boolean updateOk = CtrlQuestion.Update(uneQuestion);
			request.setAttribute("action", "updateQuestionOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//redirection
		processRequestSelectAll (request, response);
		
	}

	private void processRequestInsertQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des données du formulaire
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
				
		//insertion dans la base		
		try {
			Boolean insertOk = CtrlQuestion.Insert(uneQuestion);
				request.setAttribute("action", "insertQuestionOk");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//redirection
			processRequestSelectAll (request, response);
		
	}

	//////////////////////////
	// GESTION DES REPONSES //
	//////////////////////////
	
	private void processRequestUpdateReponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//insertion dans la base		
		try {
			Boolean updateOk = CtrlReponse.Update(uneReponse);
			request.setAttribute("action", "updateReponseOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//redirection
		processRequestSelectAll (request, response);

	}

	private void processRequestDeleteReponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//suppression dans la base		
		try {
			Boolean deleteOk = CtrlReponse.Delete(uneReponse.getId());
			request.setAttribute("action", "deleteReponseOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		processRequestSelectAll (request, response);
	}

	private void processRequestInsertReponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des données du formulaire
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//insertion dans la base		
		try {
			Boolean insertOk = CtrlReponse.Insert(uneReponse);
			request.setAttribute("action", "insertReponseOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//redirection
		processRequestSelectAll (request, response);
		
	}

	
	////////////////////////////
	// GESTION DES PARAMETRES //
	////////////////////////////
	
	private void EnvoiParametresObjets(HttpServletRequest request, Formation uneFormation, Competence uneCompetence, Theme unTheme, Question uneQuestion, Reponse uneReponse) {
		request.setAttribute("formationSelectionnee", uneFormation);
		request.setAttribute("competenceSelectionnee", uneCompetence);
		request.setAttribute("themeSelectionne", unTheme);
		request.setAttribute("questionSelectionnee", uneQuestion);
		request.setAttribute("reponseSelectionnee", uneReponse);	
	}

	///////////////////////
	// AFFICHAGE GENERAL //
	///////////////////////
	
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
			if (request.getParameter("idFormationSelectionnee") != null ) {
				idFormation = request.getParameter("idFormationSelectionnee");
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
			if (request.getParameter("idCompetenceSelectionnee") != null ) {
				idCompetence = Integer.parseInt(request.getParameter("idCompetenceSelectionnee"));
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
			if (request.getParameter("idThemeSelectionne") != null ) {
				idTheme = Integer.parseInt(request.getParameter("idThemeSelectionne"));
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
			if (request.getParameter("idQuestionSelectionnee") != null ) {
				idQuestion = Integer.parseInt(request.getParameter("idQuestionSelectionnee"));
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
			if ((request.getParameter("idReponseSelectionnee") != null) || (request.getAttribute("action") == "deleteReponseOk")) {
				idReponse = Integer.parseInt(request.getParameter("idReponseSelectionnee"));
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
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestionThemes/gestionThemes.jsp");
		rd.forward(request, response);	
	}
	
	
	
	////////////////////////
	// GESTION DES THEMES //
	////////////////////////
	private void processRequestInsertTheme (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déclaration d'un theme et de sa compétence associé
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//insertion dans la base		
		try {
			CtrlTheme.Insert(unTheme);
			request.setAttribute("action", "insertThemeOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirection
		processRequestSelectAll (request, response);
	}
	
	private void processRequestUpdateTheme (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déclaration d'un theme et de sa compétence associé
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		//insertion dans la base		
		try {
			CtrlTheme.Update(unTheme);
			request.setAttribute("action", "updateThemeOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		processRequestSelectAll (request, response);
	}

	private void processRequestDeleteTheme (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation uneFormation = RecupFormation(request);
		Competence uneCompetence = RecupCompetence(request);
		Theme unTheme =  RecupTheme(request, uneCompetence);
		Question uneQuestion = RecupQuestion(request, unTheme);
		Reponse uneReponse = RecupReponse(request, uneQuestion);
		
		try {
			CtrlTheme.Delete(unTheme.getId());
			request.setAttribute("action", "deleteThemeOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		processRequestSelectAll (request, response);
	}
	/*
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
	}*/
	
	
	
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
	
	private static Question RecupQuestion(HttpServletRequest request, Theme unTheme) {
		Question uneQuestion = new Question();
		uneQuestion.setId(Integer.parseInt(request.getParameter("idQuestionSelectionnee")) );
		uneQuestion.setEnonce(request.getParameter("enonceQuestionSelectionnee"));
		//uneQuestion.setIllustration(illustration);
		uneQuestion.setTheme(unTheme);
		return uneQuestion;
	}
	
	private static Reponse RecupReponse(HttpServletRequest request, Question uneQuestion) {
		Reponse uneReponse = new Reponse();
		uneReponse.setid(Integer.parseInt(request.getParameter("idReponseSelectionnee")) );
		uneReponse.setLibelle(request.getParameter("libelleReponseSelectionnee"));
		String validiteReponse = (request.getParameter("reponseCorrecteReponseSelectionnee"));
		uneReponse.setEstCorrect(validiteReponse.trim().equalsIgnoreCase("true"));
		uneReponse.setQuestion(uneQuestion);
		return uneReponse;
	}
	
	
	
}
