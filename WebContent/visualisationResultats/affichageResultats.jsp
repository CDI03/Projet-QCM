<%@page import="fr.eni_ecole.jee.bo.ResultatExamen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@page import="fr.eni_ecole.jee.bo.Candidat"%>

<%
Candidat leCandidatChoisit = (Candidat)request.getAttribute("leCandidatChoisit");

Examen examenChoisit = (Examen)request.getAttribute("examenChoisit");

ArrayList<ResultatExamen> resultatsDuCandidat = (ArrayList<ResultatExamen>)request.getAttribute("resultatsDuCandidat");

int nbQuestionsDuTest=0;
int nbQUestionReussiesDuTest=0;
for (ResultatExamen leResultat : resultatsDuCandidat)  
{
	nbQuestionsDuTest += leResultat.getNbrQuestionsTotales();
	nbQUestionReussiesDuTest += leResultat.getNbrQuestionsReussies();
}
int poucentageTest = nbQUestionReussiesDuTest/nbQuestionsDuTest*100;
%>

<article id="affichageResultats">
<h1>Résultats de <%=leCandidatChoisit.getPrenom() +" " + leCandidatChoisit.getNom()%></h1>
<h2><%=examenChoisit.getTest().getLibelle()%></h2>
<br>
<br>
	<p>
	Seuil atteint : <%=poucentageTest %>%<br>
	Nombres de Réponses Correctes : <%=nbQUestionReussiesDuTest%>/<%=nbQuestionsDuTest%><br>
	Temps passé : min<br>
	Nombre d'incident : <br>
	</p>
	<TABLE id="tableResultatCandidat"> 
	  <TR> 
		 <TH> Section </TH> 
		 <TH> Pourcentage </TH> 
		 <TH> NB de bonnes réponses </TH> 
	  </TR> 
	  <% 
	  int pourcentage;
	  for (ResultatExamen leResultat : resultatsDuCandidat)  {
			 pourcentage = leResultat.getNbrQuestionsReussies()/leResultat.getNbrQuestionsTotales()*100;
		  %>
	  <TR> 
		 <TD><%=leResultat.getTheme().getLibelle()%></TD> 
		 <TD><%=pourcentage%>%</TD> 
		 <TD><%=leResultat.getNbrQuestionsReussies()%>/<%=leResultat.getNbrQuestionsTotales()%></TD> 
	  </TR> 
	  <%} %>
	</TABLE> 
	<p>
	NIVEAU ATTEINT : TODO
	</p>
</article>