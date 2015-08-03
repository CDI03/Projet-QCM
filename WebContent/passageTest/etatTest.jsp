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
	<h1>R�sum� du test</h1>
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
	<!--TODO Il va manquer les cases repr�sentant les questions qui n'ont pas encore �t� vues... � r�fl�chir pour l'affichage
		De m�me, la variable question en cours permettantde faire de la mise en forme n'est pas encore utilis�e
		faire la mise en forme CSS : coloration des bouton en fonction du class=etatQuestion
	-->
	<br>
	<button type="button" name="legendeEtatRepondue" class="repondue" >Question r�pondue</button>
	<button type="button" name="legendeEtatMarquee" class="marquee" >Question marqu�e</button>
	<button type="button" name="legendeEtatPassee" class="passee" >Question pass�e</button>
	<br>
	<button type="submit" name="finDuTest" >Terminer le test</button>
	</form>
</article>