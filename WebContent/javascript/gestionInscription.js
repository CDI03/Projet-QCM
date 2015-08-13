//Soumission du formulaire
function formulaireSubmit(form,param) {
	if (param == 'selectionTests') {
		index = document.getElementById("listTests").selectedIndex;
		valeur = document.getElementById("listTests").options[index].value;
		document.getElementById("idTestSelectionne").value = valeur;
		form.submit();
	} else if (param == 'inscrire') {
		if (document.getElementById("idCandidatAInscrire").value != '') {
			form.submit();
		} else {
			document.getElementById("erreurDesinscrire").innerHTML = "";
			document.getElementById("erreurInscrire").innerHTML = "Veuillez choisir un candidat";
		}
	} else if (param == 'desinscrire') {
		if (document.getElementById("idCandidatInscrit").value != '') {
			form.submit();
		} else {
			document.getElementById("erreurInscrire").innerHTML = "";
			document.getElementById("erreurDesinscrire").innerHTML = "Veuillez choisir un candidat";
		}
	}
}




//Gestion du candidat selectionné
function selection(param) {
	var index;
	var valeur;
	document.getElementById("erreurInscrire").innerHTML = "";
	document.getElementById("erreurDesinscrire").innerHTML = "";
	if (param == 'selectionCandidats') {
		index = document.getElementById("listCandidats").selectedIndex;
		valeur = document.getElementById("listCandidats").options[index].value;
		document.getElementById("idCandidatAInscrire").value = valeur;
	} else if (param == 'selectionCandidatsInscrits') {
		index = document.getElementById("listCandidatsInscrits").selectedIndex;
		valeur = document.getElementById("listCandidatsInscrits").options[index].value;
		document.getElementById("idCandidatInscrit").value = valeur;
	}
}

//Récupération de l'index sélectionné dans une liste en fonction de sa valeur
function indexListe(liste, idValue) {
	var index = 0;
	for (var i = 0; i < liste.length; i++) {
		if (liste.options[i].value.trim() == idValue.trim()) {
			index = i;
		}
	}
	return index;
}

//fonction chargée après le chargement de la page
function initialisation() {
	var listTest = document.getElementById("listTest");
	var idTestSelectionne = document.getElementById("listTest").value;
	var indexTestSelectionne = indexListe(listTest, idTestSelectionne);
	listTest.selectedIndex = indexTestSelectionne;
	
}
window.onload = initialisation;
