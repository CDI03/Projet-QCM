<%@page import="fr.eni_ecole.jee.bo.Candidat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<%
String leTitre = "Projet QCM - Résultats";
Candidat leCandidatChoisit = (Candidat)request.getAttribute("leCandidatChoisit");
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="<%=leTitre%>" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<jsp:include page="./affichageResultats.jsp"></jsp:include>
</section>


<jsp:include page="<%=piedDePage%>"></jsp:include>