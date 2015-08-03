<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<% 
ArrayList<Formation> listeFormation = (ArrayList<Formation>)request.getAttribute("listeFormation"); 
ArrayList<Theme> listeTheme = (ArrayList<Theme>)request.getAttribute("listeTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Gestion des thèmes" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<jsp:include page="crudTheme.jsp"></jsp:include>
	<jsp:include page="crudQuestions.jsp"></jsp:include>
	<jsp:include page="crudReponses.jsp"></jsp:include>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>