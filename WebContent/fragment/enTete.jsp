<% String css = request.getContextPath() + "/theme/basique/style.css"; %>

<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= css %>">
<title><%= request.getParameter("titre") %></title>
</head>
<body>
	<header>
		<h1><%= request.getParameter("titre") %></h1>
	</header>