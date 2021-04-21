<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String name = (String) request.getAttribute("name");

int pswd = (int) request.getAttribute("pswd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Name :
		<%=name%>

	</h1>
	<br>
	<hr>
	<h1>
		password :
		<%=pswd%>
	</h1>

</body>
</html>