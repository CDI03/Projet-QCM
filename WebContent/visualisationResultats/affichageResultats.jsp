<%@page import="java.text.DecimalFormat"%>
<%@page import="fr.eni_ecole.jee.bo.ResultatExamen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.eni_ecole.jee.bo.Examen"%>
<%@page import="fr.eni_ecole.jee.bo.Candidat"%>

<%
Candidat leCandidatChoisit = (Candidat)request.getAttribute("leCandidatChoisit");

ArrayList<ResultatExamen> resultatsDuCandidat = (ArrayList<ResultatExamen>)request.getAttribute("resultatsDuCandidat");

int nbQuestionsDuTest=0;
int nbQUestionReussiesDuTest=0;
for (ResultatExamen leResultat : resultatsDuCandidat)  
{
	nbQuestionsDuTest += leResultat.getNbrQuestionsTotales();
	nbQUestionReussiesDuTest += leResultat.getNbrQuestionsReussies();
}
float poucentageTest = (float)nbQUestionReussiesDuTest/(float)nbQuestionsDuTest*100;

Examen examenChoisit = (Examen)request.getAttribute("examenChoisit");
String niveau;
if (poucentageTest>=examenChoisit.getTest().getSeuilHaut())
	{niveau = "ACQUIS";}
else if  (poucentageTest<examenChoisit.getTest().getSeuilBas())
	{niveau = "NON ACQUIS";}
else
	{niveau = "EN COURS D'ACQUISITION";}
DecimalFormat df = new DecimalFormat("######00.00"); 
%>

<article id="affichageResultats">
<h1>Résultats de <%=leCandidatChoisit.getPrenom() + " " + leCandidatChoisit.getNom()%></h1>
<h2 id="affichageResultatTitre"><%=examenChoisit.getTest().getLibelle()%></h2>
	<p>
	Seuil atteint : <%=df.format(poucentageTest)%>%<br>
	Nombres de Réponses Correctes : <%=nbQUestionReussiesDuTest%>/<%=nbQuestionsDuTest%><br>
	</p>
	<TABLE id="tableResultatCandidat"> 
	  <TR> 
		 <TH> Section </TH> 
		 <TH> Pourcentage </TH> 
		 <TH> NB de bonnes réponses </TH> 
	  </TR> 
	  <% 
	  float pourcentage;
	  for (ResultatExamen leResultat : resultatsDuCandidat)  {
			 pourcentage = (float)leResultat.getNbrQuestionsReussies()/(float)leResultat.getNbrQuestionsTotales()*100;
		  %>
	  <TR> 
		 <TD><%=leResultat.getTheme().getLibelle()%></TD> 
		 <TD><%=df.format(pourcentage)%>%</TD> 
		 <TD><%=leResultat.getNbrQuestionsReussies()%>/<%=leResultat.getNbrQuestionsTotales()%></TD> 
	  </TR> 
	  <%} %>
	</TABLE> 
	<p id="niveauAcquis">
	NIVEAU ATTEINT : <%=niveau%>
	</p>
</article>