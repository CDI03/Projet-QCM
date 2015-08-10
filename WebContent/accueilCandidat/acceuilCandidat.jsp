<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
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
				{ 
	%>
		<article class="examensCandidat">
			<form action="/Projet-QCM/PassageTest" method="post" class="selectExamen">
			<label for="libelleExamen"><%= lExamen.getTest().getLibelle()%></label>
			<input type="hidden" name="lExamen" value=<%= lExamen.getId()%>>
			<%if (lExamen.getEtat().equals("EA")) {%>
			<button type="button" name="commencerExamen" onclick="choixBouton(this.form,'commencerExamen');" >Commencer</button>
			<%} else if (lExamen.getEtat().equals("EC")) {%>
			<button type="button" name="reprendreExamen" onclick="choixBouton(this.form,'reprendreExamen');">Reprendre</button>
			<%} else if (lExamen.getEtat().equals("FN")) {%>
			<button type="button" name="resultatExamen" onclick="choixBouton(this.form,'resultatExamen');">Résultats</button>
			<%}%>
			<input type="hidden" name="hiddenField" id="hiddenField"/>
			</form>
		</article>
	<%
				}
	%>
</section>

<script type="text/javascript" src="./javascript/choixBouton.js"></script>

<jsp:include page="<%=piedDePage%>"></jsp:include>