/**
 * 
 */
function selectionTheme() {
	alert("test");
	var indexSelectionne = this.selectedIndex;
	document.getElementById("libelleTheme").value==indexSelectionne;
	
}
function controleSurBouton()
{
	if(document.getElementById("saisie").value=="")
	{
		alert("Saisie obligatoire");
	}
	else
	{
		alert("saisie ok");
	}
}