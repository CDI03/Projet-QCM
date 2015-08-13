package fr.eni_ecole.jee.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.jee.bo.Candidat;
import fr.eni_ecole.jee.controler.CtrlCandidat;
import fr.eni_ecole.jee.dal.DalCandidat;

/**
 * Servlet implementation class AuthentificationCandidat
 */

public class AuthentificationCandidat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationCandidat() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/connexionCandidat/connexionCandidat.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("idCandidat");
			String mdp = request.getParameter("mdpCandidat");
			if (mdp == null && id == null)
			{
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/connexionCandidat/connexionCandidat.jsp");
				rd.forward(request, response);
			}
			else 
				{
				Candidat candidatConnecte = CtrlCandidat.SelectOne(id, mdp);
					if(candidatConnecte!=null)
					{
						//C'est qu'on a reçu un bon couple login/mdp
						request.getSession().setAttribute("candidatConnecte", candidatConnecte);
						request.getSession().setMaxInactiveInterval(600);
						RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AccueilCandidat");
						rd.forward(request, response);
					}
					else
					{
						//Pb d'authentification: le couple login/mdp pas bon
						request.setAttribute("erreur", "Le login et/ou le mot de passe sont erronés");
						RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/connexionCandidat/connexionCandidat.jsp");
						rd.forward(request, response);
					}
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

}
