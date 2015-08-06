/**
 * 
 */
var listeLesThemes = document.getElementById("lesThemes");

function selectionTheme() {
	var libelleThemeSelectionne = listeLesThemes.options[listeLesThemes.selectedIndex].text;
	document.getElementById("unLibelleTheme").value=libelleThemeSelectionne;
}

function selectionCompetenceThemes() {
	alert("test");
	listeLesThemes.options[0].text = "testtest";
}

function affichageListe(test) {
	var test2 = "${listThemes}";
	document.write("<option>"+test2[0]+"</option>");
	document.write("<option>"+test+"</option>");
	document.write("<option>test21</option>");
}