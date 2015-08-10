<%@page import="fr.eni_ecole.jee.bo.ReponseDonnee"%>
<%@page import="fr.eni_ecole.jee.bo.QuestionPosee"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

QuestionPosee questionEnCours = (QuestionPosee)request.getAttribute("questionEnCours");

ArrayList<QuestionPosee> listeQuestionExamen = (ArrayList<QuestionPosee>)request.getAttribute("listeQuestionExamen");

String etatQuestion;
%>
 
<article id="articleEtatTest">
	<h1>Résumé du test</h1>
	<form action="/Projet-QCM/PassageTest" method="post" name="reprendreQuestion">
	
	<%
	for (QuestionPosee laQuestion:listeQuestionExamen) 
		{
			etatQuestion = "etatQuestion";
			if (laQuestion.isRepondu())
			{
				etatQuestion+="Repondue";
				}
			else if(laQuestion.isMarque() && !laQuestion.isRepondu())
			{
				etatQuestion+="Marquee";
			}
			else if (!laQuestion.isMarque() && !laQuestion.isRepondu() && laQuestion.getOrdre()<questionEnCours.getOrdre())
			{
				etatQuestion+="Passee";
			}
			else
			{
				etatQuestion+="NonVue";
			}
	%>
	<button type="button" name=<%=laQuestion.getOrdre()%> class=<%=etatQuestion%> value=<%=laQuestion.getOrdre()%> onClick="choixQuestion(this.form, this.name)"><%=laQuestion.getOrdre()%></button>
	<%
		}
	%>
	
	
	<br>
	<input type="hidden" name="hiddenField" id="hiddenField"/>
	<input type="hidden" name="choixNumQuestion" id="choixNumQuestion"/>
	<input type="hidden" name="lExamen" value=<%= lExamenEnCours.getId()%>>
	<button type="button" name="legendeEtatRepondue" class="etatQuestionRepondue" disabled="disabled">Question répondue</button>
	<button type="button" name="legendeEtatMarquee" class="etatQuestionMarquee" disabled="disabled">Question marquée</button>
	<button type="button" name="legendeEtatPassee" class="etatQuestionPassee" disabled="disabled">Question passée</button>
	<br>
	<button type="button" name="finDuTest" onclick="choixBouton(this.form,this.name,'FIN DU TEST')" >Terminer le test</button>
	</form>
</article>