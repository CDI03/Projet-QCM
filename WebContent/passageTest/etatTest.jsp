<%@page import="fr.eni_ecole.jee.bo.ReponseDonnee"%>
<%@page import="fr.eni_ecole.jee.bo.QuestionPosee"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

QuestionPosee derniereQuestionMarqueeouValidee = (QuestionPosee)request.getAttribute("derniereQuestionMarqueeouValidee");
QuestionPosee questionEnCours = (QuestionPosee)request.getAttribute("questionEnCours");

ArrayList<QuestionPosee> listeQuestionExamen = (ArrayList<QuestionPosee>)request.getAttribute("listeQuestionExamen");

String etatQuestion;
String etatBouton;
%>
 
<article id="articleEtatTest">
	<h1>Résumé du test</h1>
	<form action="/Projet-QCM/PassageTest" method="post" name="reprendreQuestion">
	
	<%
	for (QuestionPosee laQuestion:listeQuestionExamen) 
		{
			etatQuestion = "etatQuestion";
			etatBouton = "";
			if (laQuestion.isRepondu())
			{
				etatQuestion+="Repondue";
				}
			else if(laQuestion.isMarque())
			{
				etatQuestion+="Marquee";
			}
			else if (laQuestion.getOrdre()<questionEnCours.getOrdre() || laQuestion.getOrdre()<derniereQuestionMarqueeouValidee.getOrdre())
			{
				etatQuestion+="Passee";
			}
			else
			{
				etatQuestion+="NonVue";
				etatBouton = "disabled";
			}
	%>
	<button type="button" name=<%=laQuestion.getOrdre()%> class=<%=etatQuestion%> value=<%=laQuestion.getOrdre()%> onClick="choixQuestion(this.form, this.name)" <%=etatBouton%>><%=laQuestion.getOrdre()%> </button>
	<%
		}
	%>
	
	
	<br>
	<input type="hidden" name="hiddenField" id="hiddenField"/>
	<input type="hidden" name="choixNumQuestion" id="choixNumQuestion"/>
	<input type="hidden" name="lExamen" value=<%= lExamenEnCours.getId()%>>
	<br><br>Légende :<br>
	<button type="button" name="legendeEtatRepondue" class="etatQuestionRepondue" disabled>Répondue</button>
	<button type="button" name="legendeEtatMarquee" class="etatQuestionMarquee" disabled>Marquée</button>
	<button type="button" name="legendeEtatPassee" class="etatQuestionPassee" disabled>Passée</button>
	<br><br>
	<button type="button" name="finDuTest" onclick="choixBouton(this.form,this.name,'FIN DU TEST')" >Terminer le test</button>
	</form>
</article>