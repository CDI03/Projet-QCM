<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menuEmploye.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>
 
 

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Gestion des thèmes" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>


<section id="gestionThemes">
	
		<form action="/Projet-QCM/GestionThemes" method="post" name="formGestionThemes">
		
				<input type="hidden" id="idFormationSelectionnee" name="idFormationSelectionnee" value="<%=formationSelectionnee.getId()%>">
				<input type="hidden" id="idCompetenceSelectionnee" name="idCompetenceSelectionnee" value="<%=competenceSelectionnee.getId()%>">
				<input type="hidden" id="idThemeSelectionne" name="idThemeSelectionne" value="<%=themeSelectionne.getId()%>">
				<input type="hidden" id="action" name ="action" value="">
				
				<article id="articleThemeChoix">
			
					<fieldset id="fieldsetSelectionTheme">
						<legend>Choix du Themes à gérer :</legend>
						<!-- ------------------------------------- -->
						<!--  Affichage des Formations disponibles -->
						<!-- ------------------------------------- -->
						<select id="listFormations" name="listFormations" onchange="formulaireSubmit(this.form,'selectionFormations','')">
							<% for (Formation uneFormation : listFormations) { %>
							<option value="<%=uneFormation.getId().trim()%>"><%=uneFormation.getTitre()%></option>
							<% } %>
						</select>
						<br>
				
						
						<!-- -------------------------------------- -->		
						<!--  Affichage des compétences disponibles -->
						<!-- -------------------------------------- -->	
						<select id="listCompetences" name="listCompetences" onchange="formulaireSubmit(this.form,'selectionCompetences','')">
							<% for (Competence uneCompetence : listCompetences) { %>
							<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
							<% } %>
						</select>
						<br>
						
						
						<!-- ---------------------- -->	
						<!--  Affichage des themes  -->
						<!-- ---------------------- -->	
						<select id="listThemes" name="listThemes" onchange="formulaireSubmit(this.form,'selectionThemes','')">
							<% for (Theme unTheme : listThemes) { %>
								<option  value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
							<%  } %>
						</select><button type="button" id="deleteQuestion" onclick="formulaireSubmit(this.form,'deleteTheme','<%=themeSelectionne.getId()%>')">Supprimer le theme</button>
						
					</fieldset>
					
					<fieldset id="fieldsetUpdateTheme">
						<!-- ------------------------------------ -->	
						<!--  Affichage des Update/Delete Themes  -->
						<!-- ------------------------------------ -->
							
							<legend id="legendTheme">Modification du Theme  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" id="addTheme" onclick="formulaireThemeVide(form, 'insertTheme')">Passer en mode Ajout</button></legend>	
							<input type="hidden" id="idThemeSelectionne" name="idThemeSelectionne" value="<%= themeSelectionne.getId() %>"> 
							<label>Libelle du Theme : </label><input type="text" id="libelleThemeSelectionne" name="libelleThemeSelectionne" value="<%= themeSelectionne.getLibelle() %>">
							<br>
							<select id="listCompetencesUpdate">
								<% 	for (Competence uneCompetence : listCompetences) { %>
								<option value="<%=uneCompetence.getId()%>"><%=uneCompetence.getLibelle()%></option>
								<%	} %>
							</select>
							<br> 
							<button type="button" id="Valider" onclick="formulaireSubmit(this.form,'insertUpdateTheme','')">Valider</button>
							<button type="button" id="Annuler" onclick="formulaireThemeVide(form, 'cancelTheme)">Annuler</button>
							
					</fieldset>
			</article>
			
			<div id="articleThemeTitre">
				<fieldset>
					<legend id="legendQuestion">Gestion du Theme : <input type=text id="unTitreTheme" value="" disabled></legend>
					
					<article  id="articleThemeQuestion">
						<button type="button" id="addQuestion" onclick="formulaireQuestionVide(this.form,'insertQuestion')" >Passer en mode Ajout</button><br>
						
						<!-- --------------------------------------------- -->	
						<!--  Formulaire de Insert/Update/Delete Question  -->
						<!-- --------------------------------------------- -->	
						<fieldset>
							<legend id="legendQuestion">Modification de la question</legend>
							<div id="blocImage">
								<img alt="Illustration Question" src="./style/images/firefoxlogo.png" >
							</div>
							<div id="blocEnonce">
								<input type="hidden" id="idQuestionSelectionnee" name="idQuestionSelectionnee" value="<%= questionSelectionnee.getId() %>">
								<textarea id="enonceQuestionSelectionnee" name="enonceQuestionSelectionnee"><%=questionSelectionnee.getEnonce()%></textarea>
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
					</fieldset>
				</div>
			</form>
</section>
<script type="text/javascript" src="./javascript/gestionThemes.js"></script> 

<jsp:include page="<%=piedDePage%>"></jsp:include>