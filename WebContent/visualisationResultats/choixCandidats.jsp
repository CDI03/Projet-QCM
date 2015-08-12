<%@page import="fr.eni_ecole.jee.bo.Promotion"%>
<%@page import="fr.eni_ecole.jee.bo.Formation"%>
<%@page import="java.util.HashMap"%>
<%@page import="fr.eni_ecole.jee.bo.Candidat"%>
<%@page import="fr.eni_ecole.jee.bo.Inscription"%>
<%@page import="java.util.ArrayList"%>


<% 
ArrayList<Inscription> listDesInscrits = (ArrayList<Inscription>)request.getAttribute("listDesInscrits");

Candidat leCandidatChoisit = (Candidat)request.getAttribute("leCandidatChoisit");
Inscription lInscriptionSelectionne = null;
for (Inscription lInscription : listDesInscrits) {
	if (lInscription.getCandidat().getId().equals(leCandidatChoisit.getId()))
		{lInscriptionSelectionne = lInscription;}
}

ArrayList<String> listeFormationUnique = new ArrayList<String>();
ArrayList<Integer> listePromotionUnique = new ArrayList<Integer>();
%>


<article>
<h1>Test JSP choix candidats</h1>
<article>
	<form action="/Projet-QCM/VisualisationResultats" method="post" name="formChoixCandidats">
		
		<input type="text" id="codePromoSelectionnee" name="codePromoSelectionnee" value=<%=lInscriptionSelectionne.getPromotion().getCode()%>>
		<input type="text" id="titreFormationSelectionne" name="titreFormationSelectionne" value=<%=lInscriptionSelectionne.getFormation().getTitre()%>>
		<input type="text" id="numeroPromoSelectionnee" name="numeroPromoSelectionnee" value=<%=lInscriptionSelectionne.getPromotion().getNumero()%>>
		
		<input type=radio name="typeFormation" value="Candidat" id="NEW" onchange="">Candidat
		<input type=radio name="typeFormation" value="Stagiaire FC" id="FC" onchange="">Stagiaire FC
		<input type=radio name="typeFormation" value="Stagiaire EA" id="EA" onchange="">Stagiaire EA
		<input type=radio name="typeFormation" value="VAE" id="VAE" onchange="">VAE
	
		<br>Formation
		<select name="selectFormation" id="selectFormation">
		<%
			for (Inscription lInscription : listDesInscrits) 
			{
				if (!listeFormationUnique.contains(lInscription.getFormation().getId()))
				{
					listeFormationUnique.add(lInscription.getFormation().getId());
		%>
			  <option id=<%=lInscription.getFormation().getId()%> value=<%=lInscription.getFormation().getId()%>><%=lInscription.getFormation().getTitre()%></option>
		<%
				}
			} 
		%>
		</select>
		
		<br>Promotion
		<select name="selectPromotion" id="selectPromotion">
		<%
			for (Inscription lInscription : listDesInscrits) 
			{
				if (!listePromotionUnique.contains(lInscription.getPromotion().getNumero()))
				{
					listePromotionUnique.add(lInscription.getPromotion().getNumero());

		%>
			  <option id=<%=lInscription.getPromotion().getNumero()%> value=<%=lInscription.getPromotion().getNumero()%>><%=lInscription.getPromotion().getNumero()%></option>
		<%
				}
			}
		%>
		</select> 
	
		<br>
		<p id="nombreDeCandidats">
		</p>
		<select name="selectCandidat" size ="10">
		<%
			for (Inscription lInscription : listDesInscrits) 
			{
		%>
			  <option id=<%=lInscription.getCandidat().getId()%> value=<%=lInscription.getCandidat().getId()%>><%=lInscription.getCandidat().getNom() + " " + lInscription.getCandidat().getPrenom()%></option>
		<%
			}
		%>
		</select> 
		
		
		</select> 
	
	</form>

</article>