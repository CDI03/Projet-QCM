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

/**
 * Servlet implementation class PassageTest
 */
public class PassageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Examen examenChoisit;
	private QuestionPosee questionEnCours;
	private ArrayList<Reponse> reponseQuestionEnCours;
	private int numQuestionEnCours;
	private int tailleDuTest;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassageTest() {
        super();
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

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// Récupérer le nom du submit :
		try {	
			int idExamen = Integer.parseInt(request.getParameter("lExamen"));
			Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
			ArrayList<Examen> examensDuCandidat = (ArrayList<Examen>)request.getSession().getAttribute("examenDuCandidat");
			for (Examen examen : examensDuCandidat) {
				if ((examen.getId()) == idExamen) {
					examenChoisit = examen;
				}
			}
			request.setAttribute("lExamenEnCours", examenChoisit);
			
			String choixBouton = request.getParameter("hiddenField");
			request.setAttribute("choixBouton", choixBouton);
			
			switch (choixBouton) {
			case "commencerExamen":
				System.out.println("commence Examen");
				//Créer le test ici
				tailleDuTest = CtrlQuestionPosee.creerQuestionsExamen(examenChoisit);
				if (tailleDuTest != 0)
				{
					numQuestionEnCours = 1;
					affichageQuestion(request, response);		
				}
				else 
				{
					request.setAttribute("erreur", "Erreur creation du test");
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
					rd.forward(request, response);
				}
				break;
			case "reprendreExamen":
				System.out.println("reprend Examen");
				break;
			case "resultatExamen":
				System.out.println("affiche resultats Examen");			
							break;
			case "valider":
				System.out.println("valide les réponses à la question");
				Map<String, String[]> lesParametres = request.getParameterMap();
				
				int numQuestionPosee = Integer.parseInt(request.getParameter("numQuestionPosee"));
				QuestionPosee questionPosee = new QuestionPosee();
				questionPosee.setOrdre(numQuestionPosee);
				questionPosee.setExamen(examenChoisit);
				Question laQuestion = new Question();
				laQuestion.setId(Integer.parseInt(request.getParameter("idQuestion")));
				
				for (Map.Entry<String, String[]> parametre : lesParametres.entrySet()) {
					if (parametre.getKey().startsWith("laReponse"))
					{
						ReponseDonnee reponseAEnregistrer = new ReponseDonnee();
						Reponse reponseQuestion = new Reponse();
						reponseQuestion.setid(Integer.parseInt(parametre.getValue()[0]));
						reponseAEnregistrer.setExamen(examenChoisit);
						reponseAEnregistrer.setQuestion(laQuestion);
						reponseAEnregistrer.setQuestionPosee(questionPosee);
						reponseAEnregistrer.setReponse(reponseQuestion);
						//enregistrer chaque reponse dans la table reponse donnée
						CtrlReponseDonnee.enregistrerReponse(reponseAEnregistrer);
					}
				}
				//enregistrer l'etat de la question posée
				questionPosee.setRepondu(true);
				CtrlQuestionPosee.UpdateRepondu(questionPosee);
				numQuestionEnCours = numQuestionPosee+1;
				if (numQuestionEnCours<=tailleDuTest)
				{
					affichageQuestion(request, response);
				}
				else 
				{
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AccueilCandidat");
					rd.forward(request, response);
				}
				break;
			case "passer":
				System.out.println("passe la question");
				int numQuestionPosee2 = Integer.parseInt(request.getParameter("numQuestionPosee"));
				numQuestionEnCours = numQuestionPosee2+1;
				if (numQuestionEnCours<=tailleDuTest)
				{
					affichageQuestion(request, response);
				}
				else 
				{
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AccueilCandidat");
					rd.forward(request, response);
				}
				break;
			case "marquer":
				System.out.println("marque la question");
				Map<String, String[]> lesParametres3 = request.getParameterMap();
				
				int numQuestionPosee3 = Integer.parseInt(request.getParameter("numQuestionPosee"));
				QuestionPosee questionPosee3 = new QuestionPosee();
				questionPosee3.setOrdre(numQuestionPosee3);
				questionPosee3.setExamen(examenChoisit);
				Question laQuestion3 = new Question();
				laQuestion3.setId(Integer.parseInt(request.getParameter("idQuestion")));
				
				for (Map.Entry<String, String[]> parametre : lesParametres3.entrySet()) {
					if (parametre.getKey().startsWith("laReponse"))
					{
						ReponseDonnee reponseAEnregistrer = new ReponseDonnee();
						Reponse reponseQuestion = new Reponse();
						reponseQuestion.setid(Integer.parseInt(parametre.getValue()[0]));
						reponseAEnregistrer.setExamen(examenChoisit);
						reponseAEnregistrer.setQuestion(laQuestion3);
						reponseAEnregistrer.setQuestionPosee(questionPosee3);
						reponseAEnregistrer.setReponse(reponseQuestion);
						//enregistrer chaque reponse dans la table reponse donnée
						CtrlReponseDonnee.enregistrerReponse(reponseAEnregistrer);
					}
				}
				//enregistrer l'etat de la question posée
				questionPosee3.setRepondu(true);
				CtrlQuestionPosee.UpdateMarque(questionPosee3);
				numQuestionEnCours = numQuestionPosee3+1;
				if (numQuestionEnCours<=tailleDuTest)
				{
					affichageQuestion(request, response);
				}
				else 
				{
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AccueilCandidat");
					rd.forward(request, response);
				}
				break;
			default:
				System.out.println("ERREUR CHOIX BOUTON!!!!!!");
				request.setAttribute("erreur", "Erreur Choix d'action");
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/erreur/erreur.jsp");
				rd.forward(request, response);
				break;
			}		
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{}
	}

	private void affichageQuestion(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			questionEnCours = CtrlQuestionPosee.recupQuestionEnCours(examenChoisit,numQuestionEnCours);
			reponseQuestionEnCours = CtrlReponse.selectReponseQuestion(questionEnCours);
			request.setAttribute("questionEnCours", questionEnCours);
			request.setAttribute("listReponseQuestionEnCours", reponseQuestionEnCours);
			request.setAttribute("tailleDuTest", tailleDuTest);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/passageTest/passageTest.jsp");	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
