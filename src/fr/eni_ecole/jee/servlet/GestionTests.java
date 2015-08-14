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
import fr.eni_ecole.jee.bo.Section;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.bo.Theme;
import fr.eni_ecole.jee.controler.CtrlCompetence;
import fr.eni_ecole.jee.controler.CtrlFormation;
import fr.eni_ecole.jee.controler.CtrlQuestion;
import fr.eni_ecole.jee.controler.CtrlSection;
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
			} else if(request.getParameter("action").toString().equalsIgnoreCase("insertSection")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestInsertSection (request, response);
				}
			} else if(request.getParameter("action").toString().equalsIgnoreCase("deleteSection")) {
				if (request.getAttribute("action") != null) {
					processRequestSelectAll (request, response);
				} else {
					processRequestdeleteSection (request, response);
				}
			} else {
				processRequestSelectAll (request, response);
			}
		}
	}
	
	

	///////////////////////////
	// CHARGEMENT DE LA PAGE //
	///////////////////////////
	
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
		List<Section> listSections = new ArrayList<Section>();

		try {
			listFormations = CtrlFormation.SelectAll();;
			if (listFormations != null) {
				uneFormation = RecupFormation(request, listFormations);
			}
			if (uneFormation != null) {
				listCompetences = CtrlCompetence.SelectAllByFormation(uneFormation.getId());
			}
			if (listCompetences != null) {
				uneCompetence = RecupCompetence(request, listCompetences);
			}
			if (uneCompetence != null) {
				listThemes = CtrlTheme.SelectAllByCompetence(uneCompetence.getId());
			}
			if (listThemes != null) {
				unTheme =  RecupTheme(request, uneCompetence, listThemes);
			}
			
			listTests = CtrlTest.SelectAll();
			if (listTests != null) {
				unTest =  RecupTest(request, listTests);
			}
			if (unTest != null) {
				listSections = CtrlSection.SelectAllByTest(unTest.getId());
			}
			
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
		request.setAttribute("listSections", listSections);
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestionTests/gestionTests.jsp");
		rd.forward(request, response);	
		
	}
	
	//////////////
	// SECTIONS //
	//////////////
	
	private void processRequestInsertSection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//Récupération des données du formulaire
		Formation uneFormation = RecupJSPFormation(request);
		Competence uneCompetence = RecupJSPCompetence(request);
		Theme unTheme =  RecupJSPTheme(request, uneCompetence);
		Test unTest = RecupJSPTest(request);
		Section uneSection = RecupJSPSection(request, unTest, unTheme);
						
		//insertion dans la base		
		try {
			Boolean insertOk = CtrlSection.Insert(uneSection);
				request.setAttribute("action", "insertSectionOk");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//redirection
			processRequestSelectAll (request, response);
	}

	private void processRequestdeleteSection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des données du formulaire
		Formation uneFormation = RecupJSPFormation(request);
		Competence uneCompetence = RecupJSPCompetence(request);
		Theme unTheme =  RecupJSPTheme(request, uneCompetence);
		Test unTest = RecupJSPTest(request);
		Section uneSection = RecupJSPSection(request, unTest, unTheme);
		try {
			CtrlSection.Delete(uneSection);
			request.setAttribute("action", "deleteSectionOk");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		processRequestSelectAll (request, response);
		
	}

	
	
	private Formation RecupJSPFormation(HttpServletRequest request) {
		Formation uneFormation = new Formation();
		uneFormation.setId(request.getParameter("idFormationSelectionnee"));
		return uneFormation;
	}

	private static Competence RecupJSPCompetence(HttpServletRequest request) {
		Competence uneCompetence = new Competence();
		uneCompetence.setId(Integer.parseInt(request.getParameter("idCompetenceSelectionnee")) );
		return uneCompetence;
	}
	
	private static Theme RecupJSPTheme(HttpServletRequest request, Competence uneCompetence) {
		Theme unTheme =  new Theme();
		unTheme.setId(Integer.parseInt(request.getParameter("idThemeSelectionne")) );
		unTheme.setLibelle(request.getParameter("libelleThemeSelectionne"));
		unTheme.setCompetence(uneCompetence);
		return unTheme;
	}
	
	private static Test RecupJSPTest(HttpServletRequest request) {
		Test unTest = new Test();
		unTest.setId(Integer.parseInt(request.getParameter("idTestSelectionne")) );
		unTest.setLibelle(request.getParameter("libelleTestSelectionne"));
		unTest.setDuree(Integer.parseInt(request.getParameter("dureeTestSelectionne")) );
		unTest.setSeuilBas(Integer.parseInt(request.getParameter("seuilBasTestSelectionne")) );
		unTest.setSeuilHaut(Integer.parseInt(request.getParameter("seuilHautTestSelectionne")) );
		return unTest;
	}
	
	private static Section RecupJSPSection (HttpServletRequest request, Test unTest, Theme unTheme) {
		Section uneSection = new Section();
		uneSection.setTest(unTest);
		uneSection.setTheme(unTheme);
		if (request.getParameter("nbQuestionsSection").equalsIgnoreCase("")) {
			uneSection.setNombreQuestion(1);
		} else {
			uneSection.setNombreQuestion(Integer.parseInt(request.getParameter("nbQuestionsSection")));
		}
		return uneSection;
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
	
	private static Theme RecupTheme(HttpServletRequest request, Competence uneCompetence, List<Theme> listThemes) throws SQLException, NamingException {
		Theme unTheme =  new Theme();
		String idThemeSelectionne = request.getParameter("idThemeSelectionne");
		if (idThemeSelectionne != null) {
			unTheme.setId(Integer.parseInt(idThemeSelectionne));
			unTheme =  CtrlTheme.SelectOne(unTheme.getId());
		} else {
			unTheme = listThemes.get(0);
		}
		return unTheme;
	}
	
	private static Test RecupTest(HttpServletRequest request, List<Test> listTest) throws SQLException, NamingException {
		Test unTest = new Test();
		String idTestSelectionne = request.getParameter("idTestSelectionne");
		if (idTestSelectionne != null) {
			int intIdTestSelectionne = Integer.parseInt(idTestSelectionne) ;
			unTest = CtrlTest.SelectOne(intIdTestSelectionne);
		} else {
			unTest = listTest.get(0);
		}	
		return unTest;
	}
	
	
	
	
	
}
