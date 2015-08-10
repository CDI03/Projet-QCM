<%@page import="fr.eni_ecole.jee.bo.QuestionPosee"%>
<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>


<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

QuestionPosee questionEnCours = (QuestionPosee)request.getAttribute("questionEnCours");

ArrayList<Reponse> reponseQuestionEnCOurs = (ArrayList<Reponse>)request.getAttribute("listReponseQuestionEnCours");

int nbrReponsesCorrectes=0;
for (Reponse laReponse : reponseQuestionEnCOurs) 
	{
		if (laReponse.isEstCorrect())
		{
			nbrReponsesCorrectes += 1;
		}
	}

String typesReponses;
String typesBoutons;

if (nbrReponsesCorrectes>1)
	{typesReponses="[Plusieurs réponses possible]";
	 typesBoutons="checkbox";}
else
	{typesReponses="[Une seule bonne réponse]";
	 typesBoutons="radio";};
%>
 

<article id="articleEcranTest">
<h1>Theme : <%=questionEnCours.getQuestion().getTheme().getLibelle()%> </h1>
		<h2>Question N° <%=questionEnCours.getOrdre()%></h2>
		<p>
			<b>Enoncé : </b> <%=questionEnCours.getQuestion().getEnonce()%>
		</p>
		<!--img alt="Illustration Question" src="TODO"-->
		<br>
		<p><%=typesReponses%></p>
		<br>
		<form action="/Projet-QCM/PassageTest" method="post" name="repondreQuestion">
			<%
				int i = 0;
				String leNomReponse = "";
				for (Reponse laReponse : reponseQuestionEnCOurs) 
				{ 		
					if (typesBoutons.equals("checkbox"))
					{leNomReponse="laReponse" + i;}
					else if (typesBoutons.equals("radio"))
					{leNomReponse="laReponse";}
			%>
			<input type=<%=typesBoutons%> name=<%=leNomReponse%> value=<%=laReponse.getId()%>><%=laReponse.getLibelle()%>
			<br>
			<%
				i++;}
			%>
			<button type="button" name="valider" onclick="choixBouton(this.form,'valider');">Valider</button>
			<button type="button" name="passer" onclick="choixBouton(this.form,'passer');">Passer</button>
			<button type="button" name="marquer" onclick="choixBouton(this.form,'marquer');">Marquer la question</button>
			<input type="hidden" name="hiddenField" id="hiddenField"/>
			<input type="hidden" name="numQuestionPosee" id="numQuestionPosee" value=<%=questionEnCours.getOrdre()%>>
			<input type="hidden" name="idQuestion" id="idQuestion" value=<%=questionEnCours.getQuestion().getId()%>>
			<input type="hidden" name="lExamen" value=<%= lExamenEnCours.getId()%>>
		</form>	
</article>

