
function formulaireChangeValidite(form, param) {
	if (param == 1) {
		document.getElementById("reponseCorrecteReponseSelectionnee").value = "true";
	} else {
		document.getElementById("reponseCorrecteReponseSelectionnee").value = "false";
	}
}

function formulaireReponseVide(form, action) {
	if (action == 'insertReponse') {
		form.action.value = action;
		document.getElementById("legendReponse").innerHTML="Mode ajout";
	}
	document.getElementById("libelleReponseSelectionnee").value ="";
	document.getElementById("libelleReponseSelectionnee").focus();
}

function formulaireQuestionVide(form, action) {
	if (action == 'insertQuestion') {
		form.action.value = action;
		document.getElementById("legendQuestion").innerHTML="Mode ajout";
	}
	document.getElementById("enonceQuestionSelectionnee").value ="";
	document.getElementById("enonceQuestionSelectionnee").focus();
}

function formulaireThemeVide(form, action) {
	if (action == 'insertTheme') {
		form.action.value = action;
		document.getElementById("legendTheme").innerHTML="Mode ajout";
	}
	document.getElementById("libelleThemeSelectionne").value ="";
	document.getElementById("libelleThemeSelectionne").focus();
}

function selection (form, action, liste) {
	var indexSelectionnne = liste.selectedIndex;
	var idListeSelectionnee = liste.options[indexSelectionnne].value;
	form.action.value = action;
	return idListeSelectionnee;
}

function formulaireSubmit(form, action, param) {
	
	if (action == 'choixReponse') {
		form.idReponseSelectionnee.value = param;
		form.action.value = action;
	}
	if  (action == 'choixQuestion') {
		form.idQuestionSelectionnee.value = param;
		form.action.value = action;
	}
	if (action == 'deleteReponse') {
		form.idReponseSelectionnee.value = param;
		form.action.value = action;
	}
	if (action == 'deleteQuestion') {
		form.idQuestionSelectionnee.value = param;
		form.action.value = action;
	}
	if (action == 'deleteTheme') {
		form.idThemeSelectionne.value = param;
		form.action.value = action;
	}
	if (action == 'insertUpdateReponse') {
		if (form.action.value !=  'insertReponse') {
			form.action.value = 'updateReponse';
		}
	}
	if (action == 'insertUpdateQuestion') {
		if (form.action.value !=  'insertQuestion') {
			form.action.value = 'updateQuestion';
		}
	}
	if (action == 'insertUpdateTheme') {
		if (form.action.value !=  'insertTheme') {
			form.action.value = 'updateTheme';
		}
	}
	if (action == 'selectionFormations') {
		var liste = document.getElementById("listFormations");
		var idSelectionnee = selection(form, action, liste);
		document.getElementById("idFormationSelectionnee").value = idSelectionnee;
		alert(idSelectionnee);
	}
	if (action == 'selectionCompetences') {
		var liste = document.getElementById("listCompetences");
		var idSelectionnee = selection(form, action, liste);
		document.getElementById("idCompetenceSelectionnee").value = idSelectionnee;
		alert(idSelectionnee);
	}
	if (action == 'selectionThemes') {
		var liste = document.getElementById("listThemes");
		var idSelectionnee = selection(form, action, liste);
		document.getElementById("idThemeSelectionne").value = idSelectionnee;
		alert(idSelectionnee);
	}
	
	
	//alert(form.action.value);
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
	document.getElementById("listCompetencesUpdate").selectedIndex  = indexCompetenceSelectionnee;
	
	
	var listThemes = document.getElementById("listThemes");
	var idThemeSelectionne = document.getElementById("idThemeSelectionne").value;
	var indexThemeSelectionne = indexListe(listThemes, idThemeSelectionne);
	listThemes.selectedIndex = indexThemeSelectionne;
	
	document.getElementById("unTitreTheme").value=document.getElementById("libelleThemeSelectionne").value;
	
	if (document.getElementById("reponseCorrecteReponseSelectionnee").value == 'true') {
		document.getElementById("validiteReponseSelectionnee").selectedIndex = 0;
	} else {
		document.getElementById("validiteReponseSelectionnee").selectedIndex = 1;
	}
}
window.onload = initialisation;





function selectionFormation(form, action) {
	var listeLesFormations = document.getElementById("listFormations");
	var indexSelectionne = listeLesFormations.selectedIndex;
	var idFormationSelectionnee = listeLesFormations.options[indexSelectionne].value;
	document.getElementById("idFormationSelectionnee").value=idFormationSelectionnee;
	form.action.value=action;
	form.submit();
}

function selectionTheme(form, action) {
	var listeLesThemes = document.getElementById("listThemes");
	var indexSelectionne = listeLesThemes.selectedIndex;
	var idThemeSelectionne = listeLesThemes.options[indexSelectionne].value;
	document.getElementById("idThemeSelectionne").value=idThemeSelectionne;
	form.action.value=action;
	form.submit();
}

function selectionCompetenceThemes() {
	var listeLesCompetences = document.getElementById("lesCompetences");
	var lesCompetencesPourModification = document.getElementById("lesCompetencesPourModification");
	var lesCompetencesPourAjout = document.getElementById("lesCompetencesPourAjout");
	lesCompetencesPourModification.selectedIndex = listeLesCompetences.selectedIndex;
	lesCompetencesPourAjout.selectedIndex = listeLesCompetences.selectedIndex;
	form.action.value=action;
	form.submit();
}

/*
function themesUpdateDelete(form, action) {
	form.action.value = action;
	if(document.getElementById("unIdTheme").value=="") {
		alert("Saisie du libelle obligatoire");
	} else {
		form.submit();	
	}
}

function themesInsert(form, action) {
	form.action.value = action;
	if(document.getElementById("libelleThemeAAjouter").value=="") {
		alert("Saisie du libelle obligatoire");
	} else {
		form.submit();	
	}
}	
function selectionQuestion(form,idSelectionne, action) {
	form.idQuestionSelectionne.value=idSelectionne;
	form.action.value="selectQuestion";
	form.submit();
}*/

