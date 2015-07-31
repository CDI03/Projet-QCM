<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

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