/**
 * Attribue une valeur à un champ caché correpondant à la valeur du bouton cliqué
 */
function choixBouton(leForm,nomDuBoutonClique)
	{
		document.getElementsByName('hiddenField').value=nomDuBoutonClique;
		leForm.submit();
		alert('ok');
	}