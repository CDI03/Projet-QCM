

function selectionTheme(form, action) {
	var listeLesThemes = document.getElementById("lesThemes");
	var indexSelectionne = listeLesThemes.selectedIndex;
	var idThemeSelectionne = listeLesThemes.options[indexSelectionne].value;
	var libelleThemeSelectionne = listeLesThemes.options[indexSelectionne].text;
	document.getElementById("unIdTheme").value=idThemeSelectionne;
	document.getElementById("unLibelleTheme").value=libelleThemeSelectionne;
	document.getElementById("indexThemeSelectionne").value = indexSelectionne;
	document.getElementById("unTitreTheme").value=libelleThemeSelectionne;
	form.action.value=action;
	form.submit();
}

function selectionCompetenceThemes() {
	var listeLesCompetences = document.getElementById("lesCompetences");
	var lesCompetencesPourModification = document.getElementById("lesCompetencesPourModification");
	var lesCompetencesPourAjout = document.getElementById("lesCompetencesPourAjout");
	lesCompetencesPourModification.selectedIndex = listeLesCompetences.selectedIndex;
	lesCompetencesPourAjout.selectedIndex = listeLesCompetences.selectedIndex;
}

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

