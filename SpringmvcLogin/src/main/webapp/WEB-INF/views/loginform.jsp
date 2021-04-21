<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
String msg = (String) request.getAttribute("errmsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1><%=msg%></h1>
	<%
	}
	%>
<fieldset>
<legend>Login form</legend>
<form action="./emplogin" method="post">
<label for="id"> ID </label>
<input type="number" id="id" name="id" required="required"><br><br>
<label for="password"> PASSWORD </label>
<input type="password" id="password" name="password" required="required"><br><br>
<input type="submit">
</form>

</fieldset>


</body>
</html>