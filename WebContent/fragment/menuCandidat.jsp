<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%
Candidat candidatConnecte = (Candidat)request.getSession().getAttribute("candidatConnecte");
%>

<nav>
	<ul>
		<%if (candidatConnecte == null) 
		{
		%>
        <li><a href="<%= request.getContextPath() %>/AuthentificationCandidat">Authentification</a></li>
        <%
        } 
		else {
        %>
        <li><a href="<%= request.getContextPath() %>/AccueilCandidat">Accueil</a></li>
        <%} %>
    </ul>
</nav>