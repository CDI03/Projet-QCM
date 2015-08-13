<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menuEmploye.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Site Employe" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
		<article>
			<h1>Bienvenue</h1>
		</article>
</section>
<jsp:include page="<%=piedDePage%>"></jsp:include>