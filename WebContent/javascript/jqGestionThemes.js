/**
 * GESTION CRUD THEME
 */
function modifierTheme()
	{
		if(document.getElementById("saisie").value=="")
		{
			alert("Saisie obligatoire");
		}
		else
		{
			document.forms[0].submit();
		}
	}