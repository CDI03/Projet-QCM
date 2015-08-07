/**
 * Attribue une valeur à un champ caché correpondant à la valeur du bouton cliqué
 */
function choixBouton(leForm,nomDuBoutonClique)
	{
		document.getElementById('hiddenField').value=nomDuBoutonClique;
		leForm.submit();
	}