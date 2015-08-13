package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private int idTestSelectionne;
	
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
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		//choix du test selectionne
		choixDuTestSelectionne(request);
		
		//réalisation d'une action si le parametre est défini
		RealisationAction(request);
		
		try {
			this.listTests = CtrlTest.SelectAll();
			this.listCandidats = CtrlCandidat.SelectAll();
			this.testSelectionne = CtrlTest.SelectOne(this.idTestSelectionne);
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
	 * Realisation d'une inscription ou d'une desinscription
	 */
	private void RealisationAction(HttpServletRequest request) {
		String idCandidat;
		if (request.getParameter("action") != null) {
			
			
			
			if (request.getParameter("action").equalsIgnoreCase("inscrire")) {
				//récupération parametre
				idCandidat = request.getParameter("idCandidatAInscrire");
				int jourDateExamen = Integer.parseInt(request.getParameter("jourDateExamen"));
				int moisDateExamen = Integer.parseInt(request.getParameter("moisDateExamen"));
				int anDateExamen = Integer.parseInt(request.getParameter("anDateExamen"));
				String chaineDate = jourDateExamen + "-" + moisDateExamen + "-20" + anDateExamen;
				//création de la date
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				Date datePassage = null;
				try {
					datePassage = simpleDateFormat.parse(chaineDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//insertion de l'examen
				try {
					CtrlExamen.Insert(this.idTestSelectionne, idCandidat, datePassage);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			} else if (request.getParameter("action").equalsIgnoreCase("desinscrire")) {
				idCandidat = request.getParameter("idCandidatInscrit");
				String dateExamen = request.getParameter("dateExamen");
				//création de la date
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date datePassage = null;
				try {
					datePassage = simpleDateFormat.parse(dateExamen);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//suppression de l'examen
				try {
					CtrlExamen.Delete(this.idTestSelectionne, idCandidat, datePassage);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	/**
	 * CHOIX DU TEST
	 */
	private void choixDuTestSelectionne(HttpServletRequest request) {
		if (request.getParameter("idTestSelectionne") != null) {
			this.idTestSelectionne = Integer.parseInt(request.getParameter("idTestSelectionne"));
		} else {
			this.idTestSelectionne = 1;
		}
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
