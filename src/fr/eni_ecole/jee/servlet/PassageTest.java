package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.bo.Examen;
import fr.eni_ecole.jee.bo.Question;
import fr.eni_ecole.jee.bo.QuestionPosee;
import fr.eni_ecole.jee.bo.Reponse;
import fr.eni_ecole.jee.bo.ReponseDonnee;
import fr.eni_ecole.jee.bo.Test;
import fr.eni_ecole.jee.controler.CtrlExamen;
import fr.eni_ecole.jee.controler.CtrlQuestionPosee;
import fr.eni_ecole.jee.controler.CtrlReponse;
import fr.eni_ecole.jee.controler.CtrlReponseDonnee;
import fr.eni_ecole.jee.controler.CtrlResultatsExamen;

/**
 * Servlet implementation class PassageTest
 */
public class PassageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Examen examenChoisit;
	private QuestionPosee questionSuivante;
	private int numQuestionSuivante;
	private QuestionPosee questionPrecedente;
	private int numQuestionPrecedente;
	private QuestionPosee derniereQuestionMarqueeOuValidee;
	private ArrayList<QuestionPosee> listeQuestionExamen;
	private ArrayList<Reponse> reponseQuestionSuivante;	
	private int tailleDuTest;
	private RequestDispatcher rd;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassageTest() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	this.questionPrecedente = new QuestionPosee();
    	this.questionSuivante = new QuestionPosee();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	// Récupérer le nom du submit :
	String action = request.getParameter("action");
	request.setAttribute("action", action);
		try {	
			//Récupérer l'examen choisit (avec les parametres de session du candidat)
			recupExamenCandidat(request,response);
			switch (action) 
			{
				case "commencerExamen":
					System.out.println("commence Examen");
					if (creerExamen(request,response))
						{
						recupInfoExamen(request,response);
						affichageQuestionSuivante(request, response);}
					break;
				case "reprendreExamen":
					System.out.println("reprend Examen");
					recupInfoExamen(request,response);
					this.numQuestionSuivante = this.derniereQuestionMarqueeOuValidee.getOrdre()+1;
					affichageQuestionSuivante(request, response);
					break;
				case "resultatExamen":
					System.out.println("affiche resultats Examen");	
					rd = this.getServletContext().getRequestDispatcher("/VisualisationResultats");	
					rd.forward(request, response);
					break;
				case "valider":
					System.out.println("valide les réponses à la question");
					this.questionPrecedente.setRepondu(true);
					this.questionPrecedente.setMarque(false);
					if (enregistrerReponses(request,response));
						{
							recupInfoExamen(request,response);
							affichageQuestionSuivante(request, response);}
					break;
				case "passer":
					System.out.println("passe la question");
					this.numQuestionPrecedente = Integer.parseInt(request.getParameter("numQuestionPosee"));
					this.numQuestionSuivante = this.numQuestionPrecedente+1; 
					recupInfoExamen(request,response);
					affichageQuestionSuivante(request, response);
					break;
				case "marquer":
					System.out.println("marque la question");
					this.questionPrecedente.setRepondu(true);
					this.questionPrecedente.setMarque(true);
					if (enregistrerReponses(request,response));
					{
						recupInfoExamen(request,response);
						affichageQuestionSuivante(request, response);}	
					break;
				case "repasserQuestion":
					System.out.println("repasse la question");
					this.numQuestionSuivante = Integer.parseInt(request.getParameter("choixNumQuestion"));
					recupInfoExamen(request,response);
					affichageQuestionSuivante(request, response);	
					break;
				case "finDuTest":
					terminerTest(request,response);	
					break;
				default:
					System.out.println("ERREUR CHOIX BOUTON !!!!!!");
					request.setAttribute("erreur", "Erreur Choix d'action");
					rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
					rd.forward(request, response);
					break;
				}		
			} catch (SQLException e1) {
				e1.printStackTrace();
				request.setAttribute("exceptionSQL", "Une exception SQL est survenue. Veuillez contacter votre administrateur");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
				rd.forward(request, response);
			} catch (NamingException e2) {
				e2.printStackTrace();
				request.setAttribute("exceptionNaming", "Une exception NAMING est survenue. Veuillez contacter votre administrateur");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
				rd.forward(request, response);
		 }
	}

	
	private void recupExamenCandidat(HttpServletRequest request,HttpServletResponse response) 
	{
		int idExamen = Integer.parseInt(request.getParameter("lExamen"));
		Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
		ArrayList<Examen> examensDuCandidat = (ArrayList<Examen>)request.getSession().getAttribute("examenDuCandidat");
			for (Examen examen : examensDuCandidat) {
				if ((examen.getId()) == idExamen) {
					examenChoisit = examen;
				}
			}
		request.setAttribute("lExamenEnCours", examenChoisit);	
	}
	
	private boolean creerExamen(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException, ServletException, IOException 
	{
		//Créer le test
		boolean commencerExamen = false;
		if (CtrlQuestionPosee.creerQuestionsExamen(examenChoisit))
		{
			this.numQuestionSuivante = 1;
			examenChoisit.setEtat("EC");
			if (CtrlExamen.updateEtatTest(examenChoisit))
				{commencerExamen = true;}
		}
		else 
		{
			request.setAttribute("erreur", "Erreur creation du test");
			rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
			rd.forward(request, response);
		}
		return commencerExamen;
	}
	
	private boolean enregistrerReponses(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException 
	{
		boolean updateEtatQuestion = false;
		Map<String, String[]> lesParametresRequeteHTTP = request.getParameterMap();	
		this.numQuestionPrecedente = Integer.parseInt(request.getParameter("numQuestionPosee"));
		this.questionPrecedente.setOrdre(this.numQuestionPrecedente);
		this.questionPrecedente.setExamen(examenChoisit);
		Question laQuestionPosee = new Question();
		laQuestionPosee.setId(Integer.parseInt(request.getParameter("idQuestion")));
		this.questionPrecedente.setQuestion(laQuestionPosee);
		
		for (Map.Entry<String, String[]> parametre : lesParametresRequeteHTTP.entrySet()) {
			if (parametre.getKey().startsWith("laReponse"))
			{
				ReponseDonnee reponseAEnregistrer = new ReponseDonnee();
				Reponse reponseQuestion = new Reponse();
				reponseQuestion.setid(Integer.parseInt(parametre.getValue()[0]));
				reponseAEnregistrer.setExamen(examenChoisit);
				reponseAEnregistrer.setQuestion(laQuestionPosee);
				reponseAEnregistrer.setQuestionPosee(this.questionPrecedente);
				reponseAEnregistrer.setReponse(reponseQuestion);
				//enregistrer chaque reponse dans la table reponse donnée
				CtrlReponseDonnee.enregistrerReponse(reponseAEnregistrer);
			}
		}	
		//enregistrer l'etat de la question posée
		if (CtrlQuestionPosee.UpdateEtat(this.questionPrecedente))
			{updateEtatQuestion = true;
			this.numQuestionSuivante = this.numQuestionPrecedente+1;}	
		return updateEtatQuestion;
	}
		
	private void recupInfoExamen(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException 
	{
		this.listeQuestionExamen = CtrlQuestionPosee.recupExamenEnCours(examenChoisit);
		this.derniereQuestionMarqueeOuValidee = CtrlQuestionPosee.recupDerniereQuestion(examenChoisit);
		if (this.derniereQuestionMarqueeOuValidee == null)
		{this.derniereQuestionMarqueeOuValidee = listeQuestionExamen.get(0);}
	}
	
	private void affichageQuestionSuivante(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException, ServletException, IOException
	{
		if (this.numQuestionSuivante<=CtrlQuestionPosee.tailleDuTest(examenChoisit))
		{
			this.questionSuivante = CtrlQuestionPosee.recupQuestionEnCours(examenChoisit,this.numQuestionSuivante);
			this.reponseQuestionSuivante = CtrlReponse.selectReponseQuestion(this.questionSuivante);			
			
			request.setAttribute("derniereQuestionMarqueeouValidee", this.derniereQuestionMarqueeOuValidee);
			request.setAttribute("questionEnCours", this.questionSuivante);
			request.setAttribute("listeQuestionExamen", this.listeQuestionExamen);
			request.setAttribute("listReponseQuestionEnCours", this.reponseQuestionSuivante);
			request.setAttribute("tailleDuTest", this.tailleDuTest);
			
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/passageTest/passageTest.jsp");	
			rd.forward(request, response);
		}
		else 
		{
			terminerTest(request,response);
		}
	}

	private void terminerTest(HttpServletRequest request,HttpServletResponse response) throws SQLException, NamingException, ServletException, IOException {
		//enregistrer etat
		examenChoisit.setEtat("FN");
		if (CtrlExamen.updateEtatTest(examenChoisit))
		{	//Enregistrer le résultat Examen
			CtrlResultatsExamen.enregistreResultats(examenChoisit);
		}
		//rediriger vers l'acceuil
		rd = this.getServletContext().getRequestDispatcher("/AccueilCandidat");
		rd.forward(request, response);	
	}









}
