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

	<form action="/Projet-QCM/TODO" method="post" name="selectFormation">
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
		</select> 
		<label for="libelleTheme" >Libelle</label>
		<input type="text" name="libelleTheme" value="TODO">
		<button type="submit" name="ajout">Ajouter</button>
		<button type="submit" name="modification">Modifier</button>
		<button type="submit" name="suppression">Supprimer</button>
	</form>		
	
	
</article>