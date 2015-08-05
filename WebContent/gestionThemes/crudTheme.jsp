<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
ArrayList<Competence> listAllCompetences = (ArrayList<Competence>)request.getAttribute("listAllCompetences");
int idCompetenceSelectionnee;
%>
<%-- 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listQuestions"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listReponses"); 
listeFormation = null;
listeTheme = null;
--%>
 
<article id="articleCrudTheme">
	
	<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
		<!--  Affichage des compétences disponibles -->
		<select id="lesCompetences" name="lesCompetences" onchange="selectionCompetenceThemes()">
			<% for (Competence uneCompetence : listCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } 
			idCompetenceSelectionnee = 1;%>
		</select>
		<br><br><br>
		<!--  Affichage des themes  -->
		<select size="10" id="lesThemes" name="lesThemes" onchange="selectionTheme()">
			<% for (Theme unTheme : listThemes) { 
				 if (unTheme.getCompetence().getId() == idCompetenceSelectionnee) { %>
			<option  value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
			<% 	} } %>
		</select>
		<br>
		<input type="text" id="unLibelleTheme" name="unLibelleTheme" value="">
		<br>
		<select id="lesCompetences" name="lesCompetences" onchange="submit">
			<% 	for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<%	} %>
		</select>
		<br> 
		<button type="submit" name="modification" value="modification">Modifier</button>
		<button type="button" name="suppression" value="suppression">Supprimer</button>
	</form>
	
	<br><br><br>
	
	<form action="/Projet-QCM/GestionThemes" method="post" name="formInsertThemes">
		<input type="text" name="libelleThemeAAjouter" value="">
		<select name="uneCompetenceAssocie" onchange="submit">
			<% for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } %>
		</select> 
		<button type="submit" name="ajout" value="ajouterTheme">Ajouter</button>
	</form>
	
	<script type="text/javascript" src="./javascript/gestionThemes.js"></script>
</article>