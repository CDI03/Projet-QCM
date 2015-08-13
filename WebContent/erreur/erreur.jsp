
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menuCandidat.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<%
String leTitre = "Projet QCM - ERREUR";
String lErreur = (String)request.getAttribute("erreur");
%>

<jsp:include page="<%=enTete%>">
	<jsp:param value="<%=leTitre%>" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<h1><%=lErreur%></h1>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>

