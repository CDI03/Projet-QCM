<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<% 
Theme leTheme = (Theme)request.getAttribute("leTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 

Question laQuestionSelectionne = listeQuestion.get(0);
%>

<article  id="articleCrudQuestions">
	<h1>Gestion du Theme <%=leTheme.getLibelle().toString()%></h1>
	<h2>Ajout / Modification / Suppression de Questions</h2>
	
	<form action="/Projet-QCM/TODO" method="post" name="crudQuestion">
		<img alt="Illustration Question" src=<%=laQuestionSelectionne.getIllustration()%>>
		<label for="enonce" >Enoncé</label>
		<input type="text" name="enonce" value=<%=laQuestionSelectionne.getEnonce()%>>
		<button type="button" name="ajout" >Ajouter</button>
		<button type="button" name="modification">Modifier</button>
		<button type="submit" name="suppression">Supprimer</button>
		<button type="submit" name="validation">Valider</button>
		<button type="submit" name="annulation">Annuler</button>
		<table>
			<tr>
    			<th></th>
    			<th>Enoncé</th>
  			</tr>
			<% 
				int i = 0;		
				for (Question laQuestion : listeQuestion) 
				{
			 %>
			<tr>
			<td><input type = "radio"  name = "laQuestionSelectionne"/></td>
          	<td><label for = "laQuestionSelectionne">Question <%=i%> : <%= laQuestion.getEnonce().toString() %></label></td>
			</tr>
			<%
				i++;}
			%>
		</table>
	</form>		
</article>