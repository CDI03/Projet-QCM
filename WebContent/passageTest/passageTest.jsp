<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");
String leTitre = "Projet QCM - Test : " + lExamenEnCours.getTest().getLibelle();
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value=<%=leTitre%> name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<jsp:include page="ecranTest.jsp"></jsp:include>
	<jsp:include page="minuterie.jsp"></jsp:include>
	<jsp:include page="passageTest.jsp"></jsp:include>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>