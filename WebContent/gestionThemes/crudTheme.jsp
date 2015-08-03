<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>

<% 
ArrayList<Formation> listeFormation = (ArrayList<Formation>)request.getAttribute("listeFormation"); 
ArrayList<Theme> listeTheme = (ArrayList<Theme>)request.getAttribute("listeTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 

listeFormation = null;
listeTheme = null;
%>

<article id="articleCrudTheme">

	<form action="/Projet-QCM/TODO" method="post" name="selectFormation">
		<select name="lesFormations" onchange="submit">
			<% 
				int i = 0;		
				for (Formation laFormation : listeFormation) 
				{
			 %>
			<option><%= laFormation.getTitre().toString() %></option>
			<%
				i++;}
			%>
		</select> 
	</form>
	<form action="/Projet-QCM/TODO" method="post" name="crudTheme">
		<select size="10" name="lesThemes" onchange="submit">
			<% 
				int j = 0;		
				for (Theme leTheme : listeTheme) 
				{
			 %>
			<option><%= leTheme.getLibelle().toString() %></option>
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