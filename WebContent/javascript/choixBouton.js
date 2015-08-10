/**
 * Attribue une valeur à un champ caché correpondant à la valeur du bouton cliqué
 */
function choixBouton(leForm,nomDuBoutonClique,message)
	{
		leForm.hiddenField.value=nomDuBoutonClique;
		if (typeof message != 'undefined')
		{alert(message);}
		leForm.submit();
	}