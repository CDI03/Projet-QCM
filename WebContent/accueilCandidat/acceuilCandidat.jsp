<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<% 
Candidat leCandidat = (Candidat)request.getSession().getAttribute("leCandidat");
ArrayList<Examen> listeExamenDuCandidat = (ArrayList<Examen>)request.getAttribute("listeExamenDuCandidat");
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Acceuil Candidat" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<h1>Bonjour <%=leCandidat.getPrenom()+" "+leCandidat.getNom() %></h1>
	<% for (Examen lExamen : listeExamenDuCandidat) 
				{ 
	%>
		<article class="examensCandidat">
			<form action="/Projet-QCM/TODO" method="post" class="selectExamen">
			<label for="libelleExamen"><%= lExamen.getTest().getLibelle()%></label>
			<input type="hidden" value=<%= lExamen.getid()%>>
			<button type="submit" name="commencerExamen">Commencer</button>
			<button type="submit" name="reprendreExamen">Reprendre</button>
			<button type="submit" name="resultatExamen">Résultats</button>
			</form>
		</article>
	<%
				}
	%>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>