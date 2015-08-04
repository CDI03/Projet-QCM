<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Template" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
		<article>
			<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ultricies non nisi eu ullamcorper. Vivamus sagittis egestas neque, a sagittis turpis gravida non. Suspendisse at ullamcorper leo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Donec sollicitudin at risus sed eleifend. Fusce placerat metus eget tincidunt lacinia.
			</p>
		</article>
</section>
<jsp:include page="<%=piedDePage%>"></jsp:include>