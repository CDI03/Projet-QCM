<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<% 
Question laQuestionSelectionne = (Question)request.getAttribute("laQuestionSelectionne"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 

Reponse laReponseSelectionne = listeReponse.get(0);
%>

<article  id="articleCrudReponses">
	<h2>Ajout / Modification / Suppression de Réponses</h2>
	<form action="/Projet-QCM/TODO" method="post" name="crudReponse">
		<label for="libelle" >Libellé de la réponse : </label>
		<input type="text" name="libelle" value=<%=laReponseSelectionne.getLibelle().toString()%>>
		<label for="reponseCorrecte" >Réponse correcte ?</label>
		<select name="reponseCorrecte">
			<option>true</option>
			<option>false</option>
		</select> 
		<button type="button" name="ajout" >Ajouter</button>
		<button type="button" name="modification">Modifier</button>
		<button type="submit" name="suppression">Supprimer</button>
		<button type="submit" name="validation">Valider</button>
		<button type="submit" name="annulation">Annuler</button>
		<table>
			<tr>
    			<th></th>
    			<th>Réponse</th>
    			<th>Valide</th>
  			</tr>
			<% 
				int i = 0;		
				for (Reponse laReponse : listeReponse) 
				{
			%>
			<tr>
			<td><input type = "radio"  name = "laReponseSelectionne"/></td>
          	<td><label for = "laReponseSelectionne">Reponse <%=i%> : <%= laReponse.getLibelle().toString() %></label></td>
			<td><%=laReponse.isEstCorrect()%> TODO</td>
			</tr>
			<%
				i++;}
			%>
		</table>
	</form>		
</article>	