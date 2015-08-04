<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
%>
<%-- 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listQuestions"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listReponses"); 
listeFormation = null;
listeTheme = null;
--%>
 
<article id="articleCrudTheme">

	<form action="/Projet-QCM/TODO" method="post" name="selectCompetence">
		<select name="lesFormations" onchange="submit">
			<% 
				int i = 0;		
				for (Competence uneCompetence : listCompetences) 
				{
			 %>
			<option><%=uneCompetence.getLibelle()%></option>
			<%	i++;
				}
			%>
		</select> 
	</form>
	<form action="/Projet-QCM/TODO" method="post" name="crudTheme">
		<select size="10" name="lesThemes" onchange="submit">
			<% 
				int j = 0;		
				for (Theme unTheme : listThemes) 
				{
			 %>
			<option><%=unTheme.getLibelle()%></option>
			<%
				j++;}
			%>
		</select><br>
		<input type="text" name="libelleTheme" value="TODO"><br>
		<button type="button" name="modification" value="modification">Modifier</button>
		<button type="button" name="suppression" value="suppression">Supprimer</button>
	</form>
	<form action="/Projet-QCM/GestionThemes" method="post" name="crudTheme">
		<input type="text" name="libelleThemeAAjouter" value="TODO">
		<button type="submit" name="ajout">Ajouter</button>
	</form>
	
	
</article>