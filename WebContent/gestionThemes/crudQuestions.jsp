<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>

<%-- 
Theme leTheme = (Theme)request.getAttribute("leTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 
Question laQuestionSelectionne = listeQuestion.get(0);
--%>

<article  id="articleCrudQuestions">
	<h1>Gestion du Theme : <%--leTheme.getLibelle().toString()--%></h1>
	<h2>Ajout / Modification / Suppression de Questions</h2>
	
	<form action="/Projet-QCM/TODO" method="post" name="crudQuestion">
		<img alt="Illustration Question" src=<%--laQuestionSelectionne.getIllustration()--%> >
		<br>
		<label for="enonce" >Enoncé
			<input type="text" id="enonce" name="enonce" value=<%--laQuestionSelectionne.getEnonce()--%> ></label>
		<br>
		<select id="leNbBonnesRéponses" name="leNbBonnesRéponses">
			<option value="1">une seule bonne réponse</option>
			<option value="2">plusieurs bonnes réponses</option>
		</select>
		<br>
		<button type="button" id="validation">Valider</button>
		<button type="button" id="annulation">Annuler</button>
		<br>
		<button type="button" id="ajout" >Ajouter</button>
		<button type="button" id="modification">Modifier</button>
		<button type="button" id="suppression">Supprimer</button>
		<table>
			<tr>
    			<th></th>
    			<th>Enoncé</th>
  			</tr>
			<%-- 
				int i = 0;		
				for (Question laQuestion : listeQuestion) 
				{
			 --%>
			<tr>
			<td><input type = "radio"  name = "laQuestionSelectionne"/></td>
          	<td><label for = "laQuestionSelectionne">Question <%--i--%> : <%-- laQuestion.getEnonce().toString() --%></label></td>
			</tr>
			<%--
				i++;}
			--%>
		</table>
	</form>		
</article>