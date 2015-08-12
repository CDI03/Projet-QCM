<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="fr.eni_ecole.jee.bo.Test"%>
<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="fr.eni_ecole.jee.bo.Competence"%>
<%@page import="fr.eni_ecole.jee.bo.Theme"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<% 
ArrayList<Formation> listFormations = (ArrayList<Formation>)request.getAttribute("listFormations");
ArrayList<Competence> listCompetences = (ArrayList<Competence>)request.getAttribute("listCompetences");
ArrayList<Theme> listThemes = (ArrayList<Theme>)request.getAttribute("listThemes");
ArrayList<Test> listTests = (ArrayList<Test>)request.getAttribute("listTests");
ArrayList<Section> listSections = (ArrayList<Section>)request.getAttribute("listSections");
%>

<% 
Formation formationSelectionnee = (Formation)request.getAttribute("formationSelectionnee");
Competence competenceSelectionnee = (Competence)request.getAttribute("competenceSelectionnee");
Theme themeSelectionne = (Theme)request.getAttribute("themeSelectionne");
Test testSelectionne = (Test)request.getAttribute("testSelectionne");
%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>
 
 

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Gestion des Tests" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>


<section id="gestionTest">
	
		<form action="/Projet-QCM/GestionTests" method="post" name="formGestionTests">
		
				<input type="hidden" id="idFormationSelectionnee" name="idFormationSelectionnee" value="<%=formationSelectionnee.getId()%>">
				<input type="hidden" id="idCompetenceSelectionnee" name="idCompetenceSelectionnee" value="<%=competenceSelectionnee.getId()%>">
				<input type="hidden" id="idThemeSelectionne" name="idThemeSelectionne" value="<%=themeSelectionne.getId()%>">
				<input type="hidden" id="action" name ="action" value="">
				
				<article id="articleTestChoix">
			
					<fieldset id="fieldsetSelectionTest">
						<legend>Choix du Test à gérer :</legend>
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
						<!--  Affichage des tests  -->
						<!-- ---------------------- -->	
						<select id="listTests" name="listTests" onchange="formulaireSubmit(this.form,'selectionTests','')">
							<% for (Test unTest : listTests) { %>
								<option  value="<%=unTest.getId()%>"><%=unTest.getLibelle()%></option>
							<%  } %>
						</select>
					</fieldset>
					
					<fieldset id="fieldsetUpdateTest">
						<!-- ------------------------------------ -->	
						<!--  Affichage des Update/Delete Tests  -->
						<!-- ------------------------------------ -->
							
							<legend id="legendTest">Modification du Test  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" id="addTest" onclick="formulaireTestVide(form, 'insertTest')">Passer en mode Ajout</button></legend>	
							<input type="hidden" id="idTestSelectionne" name="idTestSelectionne" value="<%= testSelectionne.getId() %>"> 
							<label>Libelle du Test : </label><input type="text" id="libelleTestSelectionne" name="libelleTestSelectionne" value="<%= testSelectionne.getLibelle() %>">
							<br>
							<label>Duree : </label><input type="text" id="dureeTestSelectionne" name="dureeTestSelectionne" value="<%= testSelectionne.getDuree() %>">
							<label>Seuil Bas : </label><input type="text" id="seuilBasTestSelectionne" name="seuilBasTestSelectionne" value="<%= testSelectionne.getSeuilBas() %>">
							<label>Seuil Haut : </label><input type="text" id="seuilHautTestSelectionne" name="seuilHautTestSelectionne" value="<%= testSelectionne.getSeuilHaut() %>">
							<br> 
							<button type="button" id="Valider" onclick="formulaireSubmit(this.form,'insertUpdateTest','')">Valider</button>
							<button type="button" id="Annuler" onclick="formulaireThemeVide(form, 'cancelTest)">Annuler</button>
							
					</fieldset>
			</article>
			
			<div id="articleTestTitre">
				<fieldset>
					<legend id="legendQuestion">Gestion du Test : <input type=text id="unTitreTest" value="<%= testSelectionne.getLibelle() %>" disabled></legend>
					<button type="button" id="deleteTest" onclick="formulaireSubmit(this.form,'deleteTest','<%=testSelectionne.getId()%>')">Supprimer le test</button>
						
					<article  id="articleTestSection">
						<!-- ------------------------------------- -->	
						<!--  Formulaire de présentation Sections  -->
						<!-- ------------------------------------- -->
						<table id="sectionTable">
							<tr>
				    			<th>Section</th>
				    			<th>Nb de questions</th>
				    			<th></th>
				  			</tr>
							<%  for (Section uneSection : listSections) { %>
							<tr>
								<td><label for="labelLibelleSection" ><%= uneSection.getTheme().getLibelle() %></label></td>
					          	<td>
					          		<select>
					          			<% for (int i = 1; i <= uneSection.getNombreQuestion(); i++) {  %>
					          				<option 
					          						<% if (i == uneSection.getNombreQuestion()) { %>
					          							selected
					          						<% } %>
					          						value="<%= i %>"  >
					          						<%= i %>
					          				</option>  
					          			<% } %>
					          		</select>
					          	</td>
								<td><button type="button" id="deleteSection" onclick="formulaireSubmit(this.form,'deleteSection','<%=uneSection.getTheme().getId()%>')">Supprimer</button></td>
							</tr>
							<% } %>
						</table>	
					</article>
					
					<article  id="articleAjoutSection">
						<fieldset>
							<legend id="legendReponse">Ajout d'une section</legend>
							<h3>Liste des Themes</h3>
							<input type="hidden" id="idThemeSelectionne" name="idThemeSelectionne" value="<%= themeSelectionne.getId() %>">
							<input type="hidden" id="nbQuestionsSection" name="nbQuestionsSection" value="<%= themeSelectionne.getNbQuestions() %>">
							<select>
								<% for (Theme unTheme : listThemes) { %>
									<option 
										<% if (unTheme.getId() == themeSelectionne.getId()) { %>
											selected
										<% } %>
									 value="<%=unTheme.getId()%>"><%=unTheme.getLibelle()%></option>
								<%  } %>
							</select>
							<select>
								<% for (int j = 1; j <= themeSelectionne.getNbQuestions(); j++) { %>
									<option 
										value ="<%= j %>">
									<%= j %></option>
								<% } %>
								
							</select>
								
							<label>questions</label>
							<br>
							<button type="button" id="addSection" onclick="formulaireSubmit(this.form,'addSection','')" >Ajouter</button>
						</fieldset>
					</article>	
			
				</fieldset>
			</div>
		</form>
</section>
<script type="text/javascript" src="./javascript/gestionTests.js"></script> 

<jsp:include page="<%=piedDePage%>"></jsp:include>