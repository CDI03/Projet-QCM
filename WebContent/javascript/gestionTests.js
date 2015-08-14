
function selection (liste) {
	var indexSelectionnne = liste.selectedIndex;
	var idListeSelectionnee = liste.options[indexSelectionnne].value;
	return idListeSelectionnee;
}

function changeNbQuestionsSection() {
	var indexSelectionne = document.getElementById("selectionNombreQuestion").selectedIndex;
	document.getElementById("nbQuestionsSection").value = indexSelectionne + 1;
}

function formulaireTestVide(form, action) {
	form.action.value = 'insertTest';
	document.getElementById("libelleTestSelectionne").value="";
	document.getElementById("dureeTestSelectionne").value="";
	document.getElementById("seuilBasTestSelectionne").value="";
	document.getElementById("seuilHautTestSelectionne").value="";
	document.getElementById("seuilHautTestSelectionne").value="";
	document.getElementById("libelleTestSelectionne").focus();
}

function formulaireSubmit(form, action, param) {
	
	if (action == 'selectionFormations') {
		var liste = document.getElementById("listFormations");
		var idSelectionnee = selection(liste);
		document.getElementById("idFormationSelectionnee").value = idSelectionnee;
	}
	if (action == 'selectionCompetences') {
		var liste = document.getElementById("listCompetences");
		var idSelectionnee = selection(liste);
		document.getElementById("idCompetenceSelectionnee").value = idSelectionnee;
	}
	if (action == 'selectionTests') {
		var liste = document.getElementById("listTests");
		var idSelectionnee = selection(liste);
		document.getElementById("idTestSelectionne").value = idSelectionnee;
	}
	if (action == 'insertSection') {
		
	}
	if (action == 'deleteSection') {
		document.getElementById("idThemeSelectionne").value = param;
	}
	if (action == 'selectionTheme') {
		var liste = document.getElementById("listThemes");
		var idSelectionnee = selection(liste);
		document.getElementById("idThemeSelectionne").value = idSelectionnee;
		alert (idSelectionne);
	}
	if (action = 'insertSection') {
		
	}
		
	form.action.value = action;
	//parametres transmis à la servlet
	/*alert("Formation : " + document.getElementById("idFormationSelectionnee").value);
	alert("Competence : " + document.getElementById("idCompetenceSelectionnee").value);
	alert("Test : "  + document.getElementById("idTestSelectionne").value);
	alert("Theme : " + document.getElementById("idThemeSelectionne").value);
	
	alert("Action : " + form.action.value);*/
	form.submit();
}

function indexListe(liste, idValue) {
	var index = 0;
	for (var i = 0; i < liste.length; i++) {
		if (liste.options[i].value.trim() == idValue.trim()) {
			index = i;
		}
	}
	return index;
}

function initialisation() {
	var listFormations = document.getElementById("listFormations");
	var idFormationSelectionnee = document.getElementById("idFormationSelectionnee").value;
	var indexFormationSelectionnee = indexListe(listFormations, idFormationSelectionnee);
	listFormations.selectedIndex = indexFormationSelectionnee;
	
	var listCompetences = document.getElementById("listCompetences");
	var idCompetenceSelectionnee = document.getElementById("idCompetenceSelectionnee").value;
	var indexCompetenceSelectionnee = indexListe(listCompetences, idCompetenceSelectionnee);
	listCompetences.selectedIndex = indexCompetenceSelectionnee;
	
	var listTests = document.getElementById("listTests");
	var idTestSelectionne = document.getElementById("idTestSelectionne").value;
	var indexTestSelectionne = indexListe(listTests, idTestSelectionne);
	listTests.selectedIndex = indexTestSelectionne;
}
window.onload = initialisation;