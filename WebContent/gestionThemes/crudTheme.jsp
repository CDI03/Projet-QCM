<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>


<% ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
ArrayList<Competence> listAllCompetences = (ArrayList<Competence>)request.getAttribute("listAllCompetences");
int idCompetenceSelectionnee; 
ArrayList<Question> listQuestions = (ArrayList<Question>)request.getAttribute("listQuestions");
%>

<%-- 
Theme leTheme = (Theme)request.getAttribute("leTheme"); 
ArrayList<Question> listeQuestion = (ArrayList<Question>)request.getAttribute("listeQuestion"); 
ArrayList<Reponse> listeReponse = (ArrayList<Reponse>)request.getAttribute("listeReponse"); 
Question laQuestionSelectionne = listeQuestion.get(0);
--%>


<script type="text/javascript" src="./javascript/gestionThemes.js"></script> 
<article id="articleCrudTheme">
	
		<fieldset>
		<!--  Affichage des compétences disponibles -->
		<select id="lesCompetences" name="lesCompetences" onchange="selectionCompetenceThemes()">
			<% for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } 
			idCompetenceSelectionnee = 1;%>
		</select>
		<br>
		<!--  Affichage des themes  -->
		<select size="10" id="lesThemes" name="lesThemes" onchange="selectionTheme(this.form,'load')">
			<!--  <script type="text/javascript">affichageListe('test');</script> -->
			<% for (Theme unTheme : listThemes) { 
				 if (unTheme.getCompetence().getId() == idCompetenceSelectionnee) { %>
			<option  value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
			<% 	} } %>
		</select>
		</fieldset>
		<br><br>
		<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
		<fieldset>
		<input type="hidden" id="indexThemeSelectionne" name="indexThemeSelectionne" value="<%=request.getAttribute("indexThemeSelectionne")%>">
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
		<input type="hidden" id="action" name ="action" value="">`
		</fieldset>
	</form>

	<br><br>
	
	<form action="/Projet-QCM/GestionThemes" method="post" name="formInsertThemes">
		<fieldset>
		<input type="text" id="libelleThemeAAjouter" name="libelleThemeAAjouter" value="">
		<select id="lesCompetencesPourAjout" name="uneCompetenceAssocie" onchange="submit">
			<% for (Competence uneCompetence : listAllCompetences) { %>
			<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
			<% } %>
		</select>
		<br>
		<button type="button" id="insert" name="insert" onclick="themesInsert(this.form,'insert')">Ajouter</button>
		<input type="hidden" id="action" name ="action" value="">
		</fieldset>
	</form>
	
</article>

<article  id="articleCrudQuestions">
	<h1>Gestion du Theme : <input type=text id="unTitreTheme" value="" disabled><%--leTheme.getLibelle().toString()--%></h1>
	<h2>Ajout / Modification / Suppression de Questions</h2>
	
	<form action="/Projet-QCM/TODO" method="post" name="crudQuestion">
		<img alt="Illustration Question" src=<%--laQuestionSelectionne.getIllustration()--%> >
		<br>
		<label for="enonce" >Enoncé
			<input style="width: 500px" type="text" id="enonce" name="enonce" value="<%=listQuestions.get( Integer.parseInt((String)request.getAttribute("indexQuestionSelectionne")) ).getEnonce()%>"></label>
		<br><br>
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
		<table id="question">
			<tr>
    			<th></th>
    			<th width="300">Enoncé </th>
  			</tr>
			<%  int i = 1;		
				for (Question uneQuestion : listQuestions) { %>
			<tr>
			<td><input type = "radio"  name = "laQuestionSelectionne"/></td>
          	<td class="2emecolonne"><label for = "laQuestionSelectionne">Question <%= i %> : <%=uneQuestion.getEnonce()%></label></td>
			</tr>
			<% i++; } %>
		</table>
	</form>		
</article>