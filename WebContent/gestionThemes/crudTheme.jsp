<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>


<% 
ArrayList<Formation> listFormations = (ArrayList<Formation>)request.getAttribute("listFormations");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Question> listQuestions = (ArrayList<Question>)request.getAttribute("listQuestions");
ArrayList<Reponse> listReponses = (ArrayList<Reponse>)request.getAttribute("listReponses");
%>

<% 
Formation formationSelectionnee = (Formation)request.getAttribute("formationSelectionnee");
Competence competenceSelectionnee = (Competence)request.getAttribute("competenceSelectionnee");
Theme themeSelectionne = (Theme)request.getAttribute("themeSelectionne");
Question questionSelectionnee = (Question)request.getAttribute("questionSelectionnee");
Reponse reponseSelectionnee = (Reponse)request.getAttribute("reponseSelectionnee");
%>


<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
	
	<input type="hidden" id="idFormationSelectionnee" name="idFormationSelectionnee" value="<%=formationSelectionnee.getId()%>">
	<input type="hidden" id="idCompetenceSelectionnee" name="idCompetenceSelectionnee" value="<%=competenceSelectionnee.getId()%>">
	<input type="hidden" id="idThemeSelectionne" name="idThemeSelectionne" value="<%=themeSelectionne.getId()%>">
	
	<input type="hidden" id="action" name ="action" value="">
	<article id="articleThemeChoix">

		<fieldset id="fieldsetSelectionTheme">
			<h2>Theme : sélection</h2>
			<!-- ------------------------------------- -->
			<!--  Affichage des Formations disponibles -->
			<!-- ------------------------------------- -->
			<select id="listFormations" name="listFormations" onchange="formulaireSubmit(this.form,'ChoixFormation','')">
				<% for (Formation uneFormation : listFormations) { %>
				<option value="<%=uneFormation.getId().trim()%>"><%=uneFormation.getTitre()%></option>
				<% } %>
			</select>
			<br>
	
			
			<!-- -------------------------------------- -->		
			<!--  Affichage des compétences disponibles -->
			<!-- -------------------------------------- -->	
			<select id="listCompetences" name="listCompetences" onchange="formulaireSubmit(this.form,'ChoixCompétence','')">
				<% for (Competence uneCompetence : listCompetences) { %>
				<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
				<% } %>
			</select>
			<br>
			
			
			<!-- ---------------------- -->	
			<!--  Affichage des themes  -->
			<!-- ---------------------- -->	
			<select id="listThemes" name="listThemes" onchange="formulaireSubmit(this.form,'ChoixTheme','')">
				<% for (Theme unTheme : listThemes) { %>
					<option  value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
				<%  } %>
			</select>
			
		</fieldset>
		
		<fieldset id="fieldsetUpdateTheme">
			<!-- ------------------------------------ -->	
			<!--  Affichage des Update/Delete Themes  -->
			<!-- ------------------------------------ -->	
				<h2> Theme : Ajout / Modification</h2>
				<input type="hidden" id="unIdTheme" name="unIdTheme" value="<%= themeSelectionne.getId() %>"> 
				<label>Libelle du Theme : </label><input type="text" id="unLibelleTheme" value="<%= themeSelectionne.getLibelle() %>">
				<br>
				<select id="listCompetencesUpdate">
					<% 	for (Competence uneCompetence : listCompetences) { %>
					<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
					<%	} %>
				</select>
				<br> 
				<button type="button" id="updateTheme" onclick="formulaireSubmit(this.form,'updateTheme','')">Modifier</button>
				<button type="button" id="deleteTheme" onclick="formulaireSubmit(this.form,'deleteTheme','')">Supprimer</button>
				<button type="button" id="InsertTheme" onclick="formulaireSubmit(this.form,'InsertTheme','')">Ajouter</button>
		</fieldset>
</article>

<article id="articleThemeTitre">
	<h1>Gestion du Theme : <input type=text id="unTitreTheme" value="" disabled></h1>
</article>


<article  id="articleThemeQuestion">
	<h2>Gestion des Questions</h2><button type="button" id="addQuestion" onclick="formulaireQuestionVide(this.form,'insertQuestion')" >Passer en mode Ajout</button><br>
		
		<!-- --------------------------------------------- -->	
		<!--  Formulaire de Insert/Update/Delete Question  -->
		<!-- --------------------------------------------- -->	
		<fieldset>
		<legend id="legendQuestion">Modification de la question</legend>
		<div id="blocImage">
		<img alt="Illustration Question" src="./style/images/firefoxlogo.png" >
		</div>
		<div id="blocEnonce">
			<input type="hidden" id="idQuestionSelectionnee" name="idQuestionSelectionnee" value="<%= questionSelectionnee.getId() %>"> -->
			<label for="enonce" >Enoncé</label>
				<textarea id="enonceQuestionSelectionnee" cols="40" rows="3"><%=questionSelectionnee.getEnonce()%></textarea>

			<button type="button" id="insertUpdateQuestion" onclick="formulaireSubmit(this.form,'insertUpdateQuestion','')" >Valider</button>
			<button type="button" id="cancelQestion" onclick="formulaireQuestionVide(this.form,'cancelQestion')" >Annuler</button>
		</div>
		</fieldset>
		<!-- ------------------------------------- -->	
		<!--  Formulaire de présentation Question  -->
		<!-- ------------------------------------- -->
		<table id="questionTable">
			<tr>
    			<th></th>
    			<th class="enonce">Enoncé question</th>
    			<th></th>
  			</tr>
			<%  int i = 1;		
				for (Question uneQuestion : listQuestions) { %>
			<tr>
			<td><input type = "radio" id="questionSelectionnee" name = "questionSelectionnee" onchange="formulaireSubmit(this.form,'choixQuestion', this.value)"
							<% if (uneQuestion.getId() == questionSelectionnee.getId()) {%>
									checked
							<%}%>
							value="<%=uneQuestion.getId()%>"/>
			</td>
          	<td class="enonce"><label class="labelEnonceQuestion" for="<%=uneQuestion.getId()%>">n°<%= i %> : <%=uneQuestion.getEnonce()%></label></td>
			<td><button type="button" id="deleteQuestion" onclick="formulaireSubmit(this.form,'deleteQuestion','<%=uneQuestion.getId()%>')">Supprimer</button></td>
			</tr>
			<% i++; } %>
		</table>	
</article>

<article  id="articleThemeReponse">
	<h2>Gestion des Réponses </h2><button type="button" id="addReponse" onclick="formulaireReponseVide(this.form,'insertReponse')" >Passer en mode Ajout</button><br>
		<fieldset>
			<legend id="legendReponse">Modification de la reponse</legend>
			<input type="hidden" id="idReponseSelectionnee" name="idReponseSelectionnee" value="<%= reponseSelectionnee.getId() %>">
			<label for="labelLibelleReponse" >Libellé de la réponse : </label>
			<input type="text" id="libelleReponseSelectionnee" name="libelleReponseSelectionnee" value="<%=reponseSelectionnee.getLibelle()%>">
			<br>
			<label for="labelReponseCorrecte" >La réponse est</label>
			<input type="hidden" id="reponseCorrecteReponseSelectionnee" name="reponseCorrecteReponseSelectionnee"
				value="<%=reponseSelectionnee.isEstCorrect()%>">
			<select id="validiteReponseSelectionnee" onchange="formulaireChangeValidite(this.form,this.value)">
				<option value="1">valide</option>
				<option value="0">invalide</option>
			</select> 
			<br>
			<button type="button" id="insertUpdateReponse" onclick="formulaireSubmit(this.form,'insertUpdateReponse','')" >Valider</button>
			<button type="button" id="cancelReponse" onclick="formulaireReponseVide(this.form,'cancelReponse')" >Annuler</button>
		</fieldset>
		<table>
			<tr>
    			<th></th>
    			<th>Réponse</th>
    			<th>Validité</th>
    			<th></th>
  			</tr>
			<% 
				int j = 1;		
				for (Reponse uneReponse : listReponses) 
				{
			%>
			<tr>
				<td><input type = "radio"  id="listeReponseSelectionnee" name="listeReponseSelectionnee" onclick="formulaireSubmit(this.form,'choixReponse', this.value)" 
							<% if (uneReponse.getId() == reponseSelectionnee.getId()) {%>
									checked							
							<% }%> 
							value="<%=uneReponse.getId()%>"/>
				</td>
	          	<td><label for = "laReponseSelectionne">Reponse <%=j%> : <%= uneReponse.getLibelle() %></label></td>
				<td>la réponse est 
				<% if (uneReponse.isEstCorrect() == true) {%>
					valide
				<%} else {%>
					invalide
				<%}%>
				</td>
				<td><button type="button" id="deleteReponse" onclick="formulaireSubmit(this.form,'deleteReponse','<%=uneReponse.getId()%>')" >Supprimer</button></td>
			</tr>
			<%
				j++;}
			%>
		</table>
	
</article>	
	</form>	

<script type="text/javascript" src="./javascript/gestionThemes.js"></script> 