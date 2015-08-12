/**
 * 
 */
function initialisation() {
	
	var typesFormation = document.getElementsByName("typeFormation");
	var codePromoSelectionnee = document.getElementById("codePromoSelectionnee").value;
	for (i=0; i<typesFormation.length; i++)
    {
		if (typesFormation[i].value == codePromoSelectionnee) 
		{ typesFormation[i].checked = true; 
		break;}
    }
	
	var selectFormation = document.getElementById("selectFormation");
	var titreFormationSelectionne = document.getElementById("titreFormationSelectionne").value;
	var indexTitreFormationSelectionne = indexListe(selectFormation, titreFormationSelectionne);
	selectFormation.selectedIndex = indexTitreFormationSelectionne;
	
	var selectPromotion = document.getElementById("selectPromotion");
	var numeroPromoSelectionnee = document.getElementById("numeroPromoSelectionnee").value;
	var indexNumeroPromoSelectionnee = indexListe(selectPromotion, numeroPromoSelectionnee);
	selectPromotion.selectedIndex = indexNumeroPromoSelectionnee;
}
window.onload = initialisation;