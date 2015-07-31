<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%! String enTete = "/fragment/enTete.jsp"; %>
<%! String menu = "/fragment/menu.jsp"; %>
<%! String piedDePage = "/fragment/piedDePage.jsp"; %>

<jsp:include page="<%=enTete%>">
	<jsp:param value="Projet QCM - Template" name="titre"/>
</jsp:include>

<jsp:include page="<%=menu%>"></jsp:include>

<Section>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ultricies non nisi eu ullamcorper. Vivamus sagittis egestas neque, a sagittis turpis gravida non. Suspendisse at ullamcorper leo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Donec sollicitudin at risus sed eleifend. Fusce placerat metus eget tincidunt lacinia.

Praesent fringilla urna ut ipsum efficitur lacinia. Proin id euismod nisi. Suspendisse potenti. Aenean pharetra est non metus viverra convallis. Aliquam blandit euismod nisl, non faucibus enim laoreet vitae. Ut eget ex id urna viverra interdum. Suspendisse potenti. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Praesent tristique sapien ac nunc tempus, eget eleifend enim luctus.

In hac habitasse platea dictumst. Sed laoreet in tellus vitae imperdiet. Curabitur fringilla ante turpis. Nullam laoreet consequat arcu. Maecenas efficitur, est id viverra elementum, lectus odio hendrerit leo, commodo semper mi dui non odio. Sed commodo arcu eu lectus facilisis varius. In et accumsan purus. Mauris pharetra arcu purus, pretium pellentesque orci vulputate at. Cras ut dictum neque, sed tempus neque.

Suspendisse placerat id tortor non interdum. Vestibulum a nibh et ex luctus condimentum. Aliquam erat volutpat. Mauris sed vestibulum mi. Vivamus eget pellentesque nisi, id vestibulum sem. Nam ut purus commodo sapien laoreet sagittis id vel lectus. Curabitur lobortis nec odio in vulputate. Phasellus lobortis sit amet felis vel maximus. Donec luctus, velit hendrerit ultricies porta, enim risus dapibus magna, at iaculis ligula arcu fringilla lorem. Fusce id risus posuere, consequat massa cursus, fermentum nisl.

Nullam ultricies tortor dignissim pellentesque placerat. Fusce ullamcorper metus id ornare tristique. Integer odio sapien, volutpat quis eros sed, condimentum auctor nisl. Morbi quis nisl et nisi pellentesque consectetur ut vel metus. Suspendisse ultrices tristique ligula efficitur cursus. Nullam vitae leo ut diam bibendum ultricies at et augue. Vestibulum ullamcorper malesuada sagittis. Quisque aliquet tempus orci vitae tempus. Sed scelerisque quam et orci scelerisque, eget condimentum felis tristique.
		</p>
</section>

<jsp:include page="<%=piedDePage%>"></jsp:include>