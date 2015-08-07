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
<script type="text/javascript" src="./javascript/gestionThemes.js"></script> 

<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
	<input type="hidden" id="action" name ="action" value="">`
	<article id="articleThemeChoix">

		<fieldset id="fieldsetSelectionTheme">
			<h2>Theme : s�lection</h2>
			<!-- ------------------------------------- -->
			<!--  Affichage des Formations disponibles -->
			<!-- ------------------------------------- -->
			<select id="lesFormations" name="lesFormations" onchange="formulaireSubmit(this.form,'ChoixFormation','')">
				<% for (Formation uneFormation : listFormations) { %>
				<option value="<%=uneFormation.getId()%>"><%=uneFormation.getTitre()%></option>
				<% } %>
			</select>
			<br>
	
			
			<!-- -------------------------------------- -->		
			<!--  Affichage des comp�tences disponibles -->
			<!-- -------------------------------------- -->	
			<select id="lesCompetences" name="lesCompetences" onchange="formulaireSubmit(this.form,'ChoixComp�tence','')">
				<% for (Competence uneCompetence : listCompetences) { %>
				<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
				<% } %>
			</select>
			<br>
			
			
			<!-- ---------------------- -->	
			<!--  Affichage des themes  -->
			<!-- ---------------------- -->	
			<select id="lesThemes" name="lesThemes" onchange="formulaireSubmit(this.form,'ChoixTheme','')">
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
				<label>Libelle du Theme : </label><input type="text" id="unLibelleTheme" name="unLibelleTheme" value="<%= themeSelectionne.getLibelle() %>">
				<br>
				<select id="lesCompetencesPourModification" name="lesCompetencesPourModification">
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
	<h2>Questions : Ajout / Modification / Suppression</h2>
		
		<!-- --------------------------------------------- -->	
		<!--  Formulaire de Insert/Update/Delete Question  -->
		<!-- --------------------------------------------- -->	
		<div id="blocImage">
		<img alt="Illustration Question" src="./style/images/firefoxlogo.png" >
		</div>
		<div id="blocEnonce">
			<input type="hidden" id="unIdQuestion" name="unIdQuestion" value="<%= questionSelectionnee.getId() %>"> 
			<label for="enonce" >Enonc�</label>
				<textarea id="enonce" name="enonce"><%=questionSelectionnee.getEnonce()%></textarea>
			<select id="leNbBonnesR�ponses" name="leNbBonnesR�ponses">
				<option value="1">une seule bonne r�ponse</option>
				<option value="2">plusieurs bonnes r�ponses</option>
			</select>
		</div>
		<div>
		<button type="button" id="insertUpdateQuestion" onclick="formulaireSubmit(this.form,'insertUpdateQuestion','')" >Valider</button>
		<button type="button" id="cancelQestion" onclick="formulaireSubmit(this.form,'cancelQestion','')" >Annuler</button>
		<button type="button" id="addQestion" onclick="formulaireSubmit(this.form,'addQestion','')">Ajouter</button>
		<button type="button" id="deleteQuestion" onclick="formulaireSubmit(this.form,'deleteQuestion','')">Supprimer</button>
		</div>
		<!-- ------------------------------------- -->	
		<!--  Formulaire de pr�sentation Question  -->
		<!-- ------------------------------------- -->
		<table id="questionTable">
			<tr>
    			<th></th>
    			<th class="enonce">Enonc� question</th>
  			</tr>
			<%  int i = 1;		
				for (Question uneQuestion : listQuestions) { %>
			<tr>
			<td><input type = "radio" id="ChoixQuestion" name = "ChoixQuestion" value="<%=uneQuestion.getId()%>" onchange="formulaireSubmit(this.form,'ChoixQuestion', this.value)"/></td>
          	<td class="enonce"><label class="labelEnonceQuestion" for="<%=uneQuestion.getId()%>">n�<%= i %> : <%=uneQuestion.getEnonce()%></label></td>
			</tr>
			<% i++; } %>
		</table>	
</article>

<article  id="articleThemeReponse">
	<h2>R�ponses : Ajout / Modification / Suppression</h2>
		<input type="hidden" id="unIdReponse" name="unIdReponse" value="<%= reponseSelectionnee.getId() %>"> 
		<label for="labelLibelleReponse" >Libell� de la r�ponse : </label>
		<input type="text" id="unIdReponse" name="unLibelleReponse" value="<%=reponseSelectionnee.getLibelle()%>">
		<br>
		<label for="lebelReponseCorrecte" >R�ponse correcte ?</label>
		<select id="reponseCorrecte" name="reponseCorrecte">
			<option>true</option>
			<option>false</option>
		</select> 
		<br>
		<button type="button" id="insertUpdateReponse" onclick="formulaireSubmit(this.form,'insertUpdateReponse','')" >Valider</button>
		<button type="button" id="cancelReponse" onclick="formulaireSubmit(this.form,'cancelReponse','')" >Annuler</button>
		<button type="button" id="addReponse" onclick="formulaireSubmit(this.form,'addReponse','')" >Ajouter</button>
		<button type="button" id="deleteReponse" onclick="formulaireSubmit(this.form,'deleteReponse','')" >Supprimer</button>
		<table>
			<tr>
    			<th></th>
    			<th>R�ponse</th>
    			<th>Valide</th>
  			</tr>
			<% 
				int j = 0;		
				for (Reponse uneReponse : listReponses) 
				{
			%>
			<tr>
			<td><input type = "radio"  id="laReponseSelectionne" name = "laReponseSelectionne" value="<%=uneReponse.getId()%>"/></td>
          	<td><label for = "laReponseSelectionne">Reponse <%=j%> : <%= uneReponse.getLibelle() %></label></td>
			<td>la r�ponse est <%=uneReponse.isEstCorrect()%></td>
			</tr>
			<%
				i++;}
			%>
		</table>
	
</article>	
	</form>	

