//Fonction de récupération des valeurs. 
function splitValue(chaine) {
        var val = chaine.split('-');
        alert (val[0]);
        alert (val[1]); 
}

//Validité de la date
function dateValide() {
	var retour = false;
	var jour = document.getElementById("jourDateExamen").value;
	var mois = document.getElementById("moisDateExamen").value;
	var an = document.getElementById("anDateExamen").value;
	if ( !isNaN(jour) && !isNaN(mois) && !isNaN(an)) {
		retour = true;
	}
	return retour;
}


//Soumission du formulaire
function formulaireSubmit(form,param) {
	if (param == 'selectionTests') {
		index = document.getElementById("listTests").selectedIndex;
		valeur = document.getElementById("listTests").options[index].value;
		document.getElementById("idTestSelectionne").value = valeur;
		form.action.value = param;
		form.submit();
	} else if (param == 'inscrire') {
		var laDateEstValide = dateValide()
		var candidat = document.getElementById("idCandidatAInscrire").value
		if ((candidat != '') && laDateEstValide) {
			form.action.value = param;
			form.submit();
		} else {
			document.getElementById("erreurDesinscrire").innerHTML = "";
			if (candidat == '') {
				document.getElementById("erreurInscrire").innerHTML = "Veuillez choisir un candidat";
			} else {
				document.getElementById("erreurInscrire").innerHTML = "Veuillez saisie une date correcte (01/01/15)";
			}	
		}
	} else if (param == 'desinscrire') {
		if (document.getElementById("idCandidatInscrit").value != '') {
			form.action.value = param;
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
		var val = valeur.split('-');
		document.getElementById("idCandidatInscrit").value = val[0];
		document.getElementById("dateExamen").value = val[1];
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
