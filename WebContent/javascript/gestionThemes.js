/**
 * 
 */
function selectionTheme(form, action) {
	var listeLesThemes = document.getElementById("lesThemes");
	var indexSelectionne = listeLesThemes.selectedIndex;
	var idThemeSelectionne = listeLesThemes.options[indexSelectionne].value;
	var libelleThemeSelectionne = listeLesThemes.options[indexSelectionne].text;
	document.getElementById("unIdTheme").value=idThemeSelectionne;
	document.getElementById("unLibelleTheme").value=libelleThemeSelectionne;
	
	//gestion du themes
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

function affichageListe(test) {
	var test2 = "${listThemes}";
	document.write("<option>"+test2[0]+"</option>");
	document.write("<option>"+test+"</option>");
	document.write("<option>test21</option>");
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
