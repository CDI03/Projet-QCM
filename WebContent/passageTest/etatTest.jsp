<%@page import="fr.eni_ecole.jee.bo.ReponseDonnee"%>
<%@page import="fr.eni_ecole.jee.bo.QuestionPosee"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

ArrayList<Section> listeDesSectionsDuTest =  (ArrayList<Section>)request.getAttribute("listeDesSectionsDuTest");
Section sectionEnCours = listeDesSectionsDuTest.get(0);

Question questionEnCours = (Question)request.getAttribute("questionEnCours");

ArrayList<QuestionPosee> listeQuestionsPosees =  (ArrayList<QuestionPosee>)request.getAttribute("listeQuestionPosees");
ArrayList<ReponseDonnee> listeReponsesDonnees =  (ArrayList<ReponseDonnee>)request.getAttribute("listeReponsesDonnees");
%>
 
<article id="etatTest">
	<h1>Résumé du test</h1>
	<form action="/Projet-QCM/TODO" method="post" name="reprendreQuestion">
	<%
	String etatQuestion = "nonVue";
	for (QuestionPosee laQuestion:listeQuestionsPosees) 
		{
			if(laQuestion.isMarque())
			{etatQuestion="marquee";}
			else if (laQuestion.isRepondu())
			{etatQuestion="repondue";}
			else
			{etatQuestion="passee";}
	%>
	<button type="submit" name=<%=laQuestion.getOrdre()%> class=etatQuestion ><%=laQuestion.getOrdre()%></button>
	<%
		}
	%>
	<!--TODO Il va manquer les cases représentant les questions qui n'ont pas encore été vues... à réfléchir pour l'affichage
		De même, la variable question en cours permettantde faire de la mise en forme n'est pas encore utilisée
		faire la mise en forme CSS : coloration des bouton en fonction du class=etatQuestion
	-->
	<br>
	<button type="button" name="legendeEtatRepondue" class="repondue" >Question répondue</button>
	<button type="button" name="legendeEtatMarquee" class="marquee" >Question marquée</button>
	<button type="button" name="legendeEtatPassee" class="passee" >Question passée</button>
	<br>
	<button type="submit" name="finDuTest" >Terminer le test</button>
	</form>
</article>