<!-- ------------------------ -->	
<!--  Chargement des imports  -->
<!-- ------------------------ -->	
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%@page import="fr.eni_ecole.jee.bo.Test"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- ------------------------ -->	
<!--  variables des includes  -->
<!-- ------------------------ -->	
<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menuEmploye.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<!-- --------------------------------- -->	
<!--  variables de la servlet transmis -->
<!-- --------------------------------- -->	
<% 
ArrayList<Test> listTests = (ArrayList<Test>)request.getAttribute("listTests");
ArrayList<Candidat> listCandidats = (ArrayList<Candidat>)request.getAttribute("listCandidats");
ArrayList<Candidat> listCandidatsInscrits = (ArrayList<Candidat>)request.getAttribute("listCandidatsInscrits");
%>
<% 
Test testSelectionne = (Test)request.getAttribute("testSelectionne");
%>
<%SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");%>

<!-- -------------------------- -->	
<!--  Chargement Entete et Menu -->
<!-- -------------------------- -->	
<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Gestion des Tests" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>


<!-- ---------------------------------------------- -->	
<!--  Affichage de la section Inscription Candidats -->
<!-- ---------------------------------------------- -->	

<section id="inscriptionCandidat">
	<form action="/Projet-QCM/InscriptionCandidats" method="post" name="formInscriptionCandidats">
		<input type="hidden" id="idTestSelectionne" name="idTestSelectionne" value="<%= testSelectionne.getId() %>"> 
		<input type="hidden" id="idCandidatAInscrire" name="idCandidatAInscrire" value="">
		<input type="hidden" id="idCandidatInscrit" name="idCandidatInscrit" value="">
		<input type="hidden" id="dateExamen" name="dateExamen" value="">
		<input type="hidden" id="action" name="action" value="">
		
		<fieldset id="fieldsetSelectionTest">
			<legend>Choix du Test :</legend>
						
			<!-- ---------------------- -->	
			<!--  Affichage des tests  -->
			<!-- ---------------------- -->	
			<select id="listTests" onchange="formulaireSubmit(this.form,'selectionTests')" size="10">
				<% if (!listTests.isEmpty()) {
						for (Test unTest : listTests) { %>
					<option  value="<%=unTest.getId()%>"><%=unTest.getLibelle()%></option>
				<%  } } else { %>
				<option>Aucun test disponible</option>									
				<%	} %>
			</select>
		</fieldset>
		
		<br>
		
		<div id="Selection des candidats">
			<fieldset>
				<legend>Gestion du test : <%= testSelectionne.getLibelle() %></legend>
				<div id="divSelectionCandidats">
					<fieldset id="fieldsetSelectionCandidats">
						<legend>Liste des Candidats :</legend>
									
						<!-- ---------------------- -->	
						<!--  Affichage de la liste des candidats  -->
						<!-- ---------------------- -->	
						<div style="display:inline-block">
						<select id="listCandidats" onchange="selection('selectionCandidats')" size="10">
							<% if (!listCandidats.isEmpty()) {
									for (Candidat unCandidat : listCandidats) { %>
								<option  value="<%=unCandidat.getId()%>"><%=unCandidat.getNom()%> <%=unCandidat.getPrenom()%></option>
							<%  } } else { %>
							<option>Aucun candidat disponible</option>									
							<%	} %>
						</select>
						</div>
						<div style="display:inline-block; vertical-align: top;">
						Date :
						<input type="text" id="jourDateExamen" name="jourDateExamen" size="1" maxlength="2">
						 / <input type="text" id="moisDateExamen" name="moisDateExamen" size="1" maxlength="2">
						 / <input type="text" id="anDateExamen" name="anDateExamen" size="1" maxlength="2">
						<button type="button" id="inscrire" onclick="formulaireSubmit(this.form,'inscrire')">Inscrire</button>
						</div>
						<label id="erreurInscrire" style="color:red;"></label>
					</fieldset>
				</div>
				<div id="divSelectionCandidatsInscrits">					
					<fieldset id="fieldsetSelectionCandidatsInscrits">
						<legend>Liste des Candidats Inscrits :</legend>
									
						<!-- ---------------------- -->	
						<!--  Affichage des tests  -->
						<!-- ---------------------- -->	
						<div style="display:inline-block; vertical-align: top;">
						<select id="listCandidatsInscrits" onchange="selection('selectionCandidatsInscrits')" size="10">
							<% if (!listCandidatsInscrits.isEmpty()) {
									for (Candidat unCandidat : listCandidatsInscrits) { %>
									
								<option  value="<%=unCandidat.getId()%>-<%=simpleDateFormat.format(unCandidat.getDatePassage())%>">
									<%=unCandidat.getNom()%> <%=unCandidat.getPrenom()%> -- <%=simpleDateFormat.format(unCandidat.getDatePassage())%></option>
							<%  } } else { %>
							<option>Aucun candidat inscript à l'examen</option>									
							<%	} %>
						</select>
						</div>
						<div style="display:inline-block; vertical-align: top;">
						<button type="button" id="desincrire" onclick="formulaireSubmit(this.form,'desinscrire')">Annuler l'inscription</button>
						</div>
						<label id="erreurDesinscrire" style="color:red;"></label>
					</fieldset>
				</div>
			</fieldset>
		</div>
	</form>
</section>

<!-- --------------------------- -->	
<!--  Chargement du pied de page -->
<!-- --------------------------- -->	
<jsp:include page="<%=piedDePage%>"></jsp:include>

<!-- ---------------------- -->	
<!--  Chargement javascript -->
<!-- ---------------------- -->	
<script type="text/javascript" src="./javascript/gestionInscription.js"></script> 
		
		
		
		
		
		