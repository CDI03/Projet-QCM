<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<%
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");
int tempsRestant = lExamenEnCours.getTempsRestant();


int seconds = (int) (tempsRestant / 1000) % 60 ;
int minutes = (int) ((tempsRestant / (60*1000)) % 60);
int hours   = (int) ((tempsRestant / (1000*60*60)) % 24);
%>

<article id="articleMinuterie">
	<fieldset>
	<legend>Temps Restant</legend>
	<p><%=minutes + "min " + seconds + "s"%></p>
	</fieldset>
</article>