/**
 * Attribue une valeur à un champ caché correpondant à la valeur du bouton cliqué
 */

function ValiderDisabled()
	{
		document.getElementById("valider").disabled = true;
	}

function ReponsesCoche()
{
	document.getElementById("valider").disabled = false;
}

window.onload(ValiderDisabled());

function choixBouton(leForm,nomDuBoutonClique,message)
	{
		leForm.action.value=nomDuBoutonClique;
		if (typeof message != 'undefined')
			{
				if(confirm(message))
				{
					leForm.submit();
				}
			}
		else
			{leForm.submit();}
	}
