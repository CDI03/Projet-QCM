<!-- ------------------------ -->	
<!--  Chargement des imports  -->
<!-- ------------------------ -->	
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
		<input type="text" id="idTestSelectionne" name="idTestSelectionne" value="<%= testSelectionne.getId() %>"> 
		<input type="text" id="idCandidatAInscrire" name="idCandidatAInscrire" value="">
		<input type="text" id="idCandidatInscrit" name="idCandidatInscrit" value="">
		
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
		
		<div id="Selection des candidats">
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
					<button type="button" id="inscrire" onclick="formulaireSubmit(this.form,'inscrire')">Inscrire</button>
					</div>
					<label id="erreurInscrire" style="color:red;"></label>
				</fieldset>
			</div>
			<div id="divSelectionCandidatsInscrits">					
				<fieldset id="fieldsetSelectionCandidatsInscrits">
					<legend>Liste des Candidats Inscripts :</legend>
								
					<!-- ---------------------- -->	
					<!--  Affichage des tests  -->
					<!-- ---------------------- -->	
					<div style="display:inline-block; vertical-align: top;">
					<select id="listCandidatsInscrits" onchange="selection('selectionCandidatsInscrits')" size="10">
						<% if (!listCandidatsInscrits.isEmpty()) {
								for (Candidat unCandidat : listCandidatsInscrits) { %>
							<option  value="<%=unCandidat.getId()%>"><%=unCandidat.getNom()%> <%=unCandidat.getPrenom()%></option>
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
		
		
		
		
		
		