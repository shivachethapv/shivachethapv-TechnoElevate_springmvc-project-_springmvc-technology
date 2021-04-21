<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg = (String) request.getAttribute("empname"); 
    String name = (String) request.getAttribute("cookie");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<h1><%=msg %></h1>
<%}%>

<%if(name!=null && !name.isEmpty()){ %>
<h1><%=name %></h1>
<%}%>

<h3><a href="./createcookie">CREATE COOKIE</a></h3>
<h3><a href="./showcookie">SHOW COOKIE</a></h3>

</body>
</html>