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