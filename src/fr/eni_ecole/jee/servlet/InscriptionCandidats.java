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

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.controler.CtrlCandidat;
import fr.eni_ecole.jee.controler.CtrlExamen;
import fr.eni_ecole.jee.controler.CtrlTest;
import fr.eni_ecole.jee.dal.DalCandidat;
import fr.eni_ecole.jee.dal.DalExamen;
import fr.eni_ecole.jee.dal.DalTest;

/**
 * Servlet implementation class InscriptionCandidats
 */
public class InscriptionCandidats extends HttpServlet {
	
	private List<Test> listTests;
	private List<Candidat> listCandidats;
	private List<Candidat> listCandidatsInscrits;
	private Test testSelectionne;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionCandidats() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	listTests = new ArrayList<Test>();
    	listCandidats = new ArrayList<Candidat>();
    	listCandidatsInscrits = new ArrayList<Candidat>();
    	testSelectionne = new Test();
    	
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
	
	/**
	 * FONCTION D'AFFICHAGE DE LA PAGE
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws NamingException 
	 * @throws SQLException 
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//choix du test selectionne
		int idTestSelectionne = choixDuTestSelectionne(request);
		
		try {
			this.listTests = CtrlTest.SelectAll();
			this.listCandidats = CtrlCandidat.SelectAll();
			this.testSelectionne = CtrlTest.SelectOne(idTestSelectionne);
			this.listCandidatsInscrits = CtrlExamen.SelectAllCandidatsByTest(this.testSelectionne.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//Affecté toutes les varibales à la request
		request = SetAttibute(request);
		//Redirection de la requete sur la page JSP
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/inscriptionCandidat/inscriptionCandidat.jsp");
		rd.forward(request, response);	
	}
	
	/**
	 * CHOIX DU TEST
	 */
	private int choixDuTestSelectionne(HttpServletRequest request) {
		int idTestSelectionne;
		if (request.getParameter("idTestSelectionne") != null) {
			idTestSelectionne = Integer.parseInt(request.getParameter("idTestSelectionne"));
		} else {
			idTestSelectionne = 1;
		}
		return idTestSelectionne;
	}


	/**
	 *  AFFECTATION DES VARIABLES
	 */
	private HttpServletRequest SetAttibute(HttpServletRequest request) {
		request.setAttribute("listTests", this.listTests);
		request.setAttribute("listCandidats", this.listCandidats);
		request.setAttribute("testSelectionne", this.testSelectionne);
		request.setAttribute("listCandidatsInscrits", this.listCandidatsInscrits);
		return request;
	}
	
	
	
	
}
