<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

ArrayList<Question> listQuestionExamen = (ArrayList<Question>)request.getAttribute("listQuestionExamen");
int numQuestionEnCours = (int)request.getAttribute("numQuestionEnCours");
Question questionEnCours = listQuestionExamen.get(numQuestionEnCours);

ArrayList<Reponse> listReponseExamen = (ArrayList<Reponse>)request.getAttribute("listReponseExamen");
ArrayList<Reponse> reponseQuestionEnCOurs = new ArrayList<Reponse>();
for (Reponse reponse : listReponseExamen) 
{
	if (reponse.getQuestion().getId() == questionEnCours.getId())
	{	
		reponseQuestionEnCOurs.add(reponse);
	}
}

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

if (nbrReponsesCorrectes>0)
	{typesReponses="[Plusieurs réponses possible]";
	 typesBoutons="checkbox";}
else
	{typesReponses="[Une seule bonne réponse]";
	 typesBoutons="radio";};
%>
 

<article id="ecranTest">
	<h1>Theme : <%=sectionEnCours.getTheme().getLibelle()%> </h1>
		<h2>Question N° <%="TODO"%></h2>
		<p>
			Enoncé : <%=questionEnCours.getEnonce() %>
		</p>
		<img alt="Illustration Question" src=<%=questionEnCours .getIllustration()%>>
		<br>
		<p><%=typesReponses%></p>
		<form action="/Projet-QCM/TODO" method="post" name="repondreQuestion">
			<%
				for (Reponse laReponse : reponsesDeLaQuestion) 
				{ 		
			%>
			<input type=<%=typesBoutons%> name=<%=laReponse.getIdentifiant()%> value=<%=laReponse.isEstCorrect()%>><%=laReponse.getLibelle()%>
			<%
				}
			%>
			<button type="submit" name="valider">Valider</button>
			<button type="submit" name="passer">Passer</button>
			<button type="button" name="marquer" >Marquer la question</button>
		</form>	
</article>