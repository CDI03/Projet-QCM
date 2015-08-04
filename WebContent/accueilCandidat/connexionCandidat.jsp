<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Connexion Candidat" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
	<h1>Veuillez entrer votre identifiant et votre mot de passe pour vous connecter</h1>
		<article class="connexionCandidat">
			<form action="/Projet-QCM/AuthentificationCandidat" method="post" class="connectCandidat">
				<label for="idCandidat">Identifiant
				<input type="text" name="idCandidat"></label>
				<label for="mdpCandidat">Mot de Passe
				<input type="password" name="mdpCandidat"></label>
				<button type="submit" name="connectionCandidat">Se connecter</button>
			</form>
		</article>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>