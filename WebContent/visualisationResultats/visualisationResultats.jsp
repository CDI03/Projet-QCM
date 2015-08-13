<%@page import="fr.eni_ecole.jee.bo.Employe"%>
<%@page import="fr.eni_ecole.jee.bo.Candidat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
String leTitre = "Projet QCM - Résultats";
Candidat leCandidatChoisit = (Candidat)request.getAttribute("leCandidatChoisit");
Candidat leCandidatEnCours = (Candidat)request.getSession().getAttribute("candidatConnecte");
%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%
String menu = "";
if (leCandidatEnCours != null) 
	{menu = "/fragment/menuCandidat.jsp"; }
else {menu = "/fragment/menuEmploye.jsp"; }
	
%>
	
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<jsp:include page="<%=enTete%>">
	<jsp:param value="<%=leTitre%>" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<%if (leCandidatEnCours == null) {%>
	<jsp:include page="./choixCandidats.jsp"></jsp:include>
	<%} %>
	<jsp:include page="./affichageResultats.jsp"></jsp:include>
</section>

<script type="text/javascript" src="./javascript/visualisationResultats.js"></script>
<jsp:include page="<%=piedDePage%>"></jsp:include>