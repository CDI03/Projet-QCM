<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menuCandidat.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<% 
Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
ArrayList<Examen> examenDuCandidat = (ArrayList<Examen>)request.getSession().getAttribute("examenDuCandidat");
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Acceuil Candidat" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<h1>Bonjour <%=leCandidatEnCours.getPrenom()+" "+leCandidatEnCours.getNom() %></h1>
	<% for (Examen lExamen : examenDuCandidat)
				{ 	String commence = "disabled";
					String reprend = "disabled";
					String resultat = "disabled";
	%>
		<fieldset>
			<article class="examensCandidat">
				<form action="/Projet-QCM/PassageTest" method="post" class="selectExamen">
				<label for="libelleExamen"><%= lExamen.getTest().getLibelle()%></label>
				<input type="hidden" name="lExamen" value=<%= lExamen.getId()%>>
				<%if (lExamen.getEtat().equals("EA")) 
					{
						commence="";
					} 
				else if (lExamen.getEtat().equals("EC")) 
					{
						reprend ="";
					} 
				else if (lExamen.getEtat().equals("FN")) 
					{
						resultat ="";
					}
				%>
				<button type="button" name="commencerExamen" onclick="choixBouton(this.form,'commencerExamen');" <%=commence%>>Commencer</button>
				<button type="button" name="reprendreExamen" onclick="choixBouton(this.form,'reprendreExamen');" <%=reprend%>>Reprendre</button>
				<button type="button" name="resultatExamen" onclick="choixBouton(this.form,'resultatExamen');" <%=resultat%>>Résultats</button>
				<input type="hidden" name="action" id="action"/>
				</form>
			</article>
		</fieldset>
		<br>
	<%
				}
	%>
</section>

<script type="text/javascript" src="./javascript/choixBouton.js"></script>

<jsp:include page="<%=piedDePage%>"></jsp:include>