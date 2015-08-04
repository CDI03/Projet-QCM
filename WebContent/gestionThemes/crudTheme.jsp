<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>

<%ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");%>
<%-- 
ArrayList<Formation> listeFormation = (ArrayList<Formation>)request.getAttribute("listFormations"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listQuestions"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listReponses"); 
listeFormation = null;
listeTheme = null;
--%>
 
<article id="articleCrudTheme">

	<form action="/Projet-QCM/TODO" method="post" name="selectFormation">
		<select name="lesFormations" onchange="submit">
			<%-- 
				int i = 0;		
				for (Formation laFormation : listeFormation) 
				{
			 --%>
			<option><%-- laFormation.getTitre().toString() --%></option>
			<%--
				i++;}
			--%>
		</select> 
	</form>
	<form action="/Projet-QCM/TODO" method="post" name="crudTheme">
		<select size="10" name="lesThemes" onchange="submit">
			<% 
				if (listThemes.isEmpty()) {
					%><p>vide</p><%
				} else {
					%><p>plein</p><%
				};
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