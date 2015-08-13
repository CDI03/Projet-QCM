<%@page import="fr.eni_ecole.jee.bo.QuestionPosee"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = ""; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<%
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");
String leTitre = "Projet QCM - Test : " + lExamenEnCours.getTest().getLibelle().toString();

QuestionPosee questionEnCours = (QuestionPosee)request.getAttribute("questionEnCours");
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="<%=leTitre%>" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<jsp:include page="./ecranTest.jsp"></jsp:include>
	<jsp:include page="./etatTest.jsp"></jsp:include>
</section>

<script type="text/javascript" src="./javascript/choixBouton.js"></script>
<script type="text/javascript" src="./javascript/choixQuestion.js"></script>

<jsp:include page="<%=piedDePage%>"></jsp:include>

