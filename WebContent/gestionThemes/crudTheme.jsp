<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>


<% ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
ArrayList<Competence> listAllCompetences = (ArrayList<Competence>)request.getAttribute("listAllCompetences");
int idCompetenceSelectionnee; %>

<%-- 
Theme leTheme = (Theme)request.getAttribute("leTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 
Question laQuestionSelectionne = listeQuestion.get(0);
--%>


<script type="text/javascript" src="./javascript/gestionThemes.js"></script> 
<article id="articleCrudTheme">
	
	<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
		<!--  Affichage des compétences disponibles -->
		<select id="lesCompetences" name="lesCompetences" onchange="selectionCompetenceThemes()">
			<% for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } 
			idCompetenceSelectionnee = 1;%>
		</select>
		<br><br><br>
		
		<!--  Affichage des themes  -->
		<select size="10" id="lesThemes" name="lesThemes" onchange="selectionTheme(this.form,'load')">
			<!--  <script type="text/javascript">affichageListe('test');</script> -->
			<% for (Theme unTheme : listThemes) { 
				 if (unTheme.getCompetence().getId() == idCompetenceSelectionnee) { %>
			<option  value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
			<% 	} } %>
		</select>
		<br>
		<input type="hidden" id="unIdTheme" name="unIdTheme" value="">
		<input type="text" id="unLibelleTheme" name="unLibelleTheme" value="">
		<br>
		<select id="lesCompetencesPourModification" name="lesCompetencesPourModification" onchange="submit">
			<% 	for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<%	} %>
		</select>
		<br> 
		<button type="button" id="update" onclick="themesUpdateDelete(this.form,'update')">Modifier</button>
		<button type="button" id="delete" onclick="themesUpdateDelete(this.form,'delete')">Supprimer</button>
		<input type="hidden" id="action" name ="action" value="">
	</form>

	<br><br><br>
	
	<form action="/Projet-QCM/GestionThemes" method="post" name="formInsertThemes">
		<input type="text" id="libelleThemeAAjouter" name="libelleThemeAAjouter" value="">
		<select id="lesCompetencesPourAjout" name="uneCompetenceAssocie" onchange="submit">
			<% for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } %>
		</select> 
		<button type="button" id="insert" name="insert" onclick="themesInsert(this.form,'insert')">Ajouter</button>
		<input type="hidden" id="action" name ="action" value="">
	</form>
	
</article>

<article  id="articleCrudQuestions">
	<h1>Gestion du Theme : <input type=text id="unTitreTheme" value="" disabled><%--leTheme.getLibelle().toString()--%></h1>
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