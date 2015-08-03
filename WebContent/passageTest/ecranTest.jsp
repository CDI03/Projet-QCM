<%@page import="fr.eni_ecole.jee.bo.Reponse"%>
<%@page import="fr.eni_ecole.jee.bo.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Section"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>

<% 
Examen lExamenEnCours = (Examen)request.getAttribute("lExamenEnCours");

ArrayList<Section> listeDesSectionsDuTest =  (ArrayList<Section>)request.getAttribute("listeDesSectionsDuTest");
Section sectionEnCours = listeDesSectionsDuTest.get(0);

ArrayList<Question> listeDesQuestionsDeLaSection = (ArrayList<Question>)request.getAttribute("listeDesQuestionsDeLaSection");
Question questionEnCours = (Question)request.getAttribute("questionEnCours");

ArrayList<Reponse> reponsesDeLaQuestion = (ArrayList<Reponse>)request.getAttribute("reponsesDeLaQuestion");

int nbrReponsesCorrectes=0;
for (Reponse laReponse : reponsesDeLaQuestion) 
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