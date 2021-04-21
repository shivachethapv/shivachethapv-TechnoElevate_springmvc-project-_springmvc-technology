<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="header.jsp" %>
<!DOCTYPE html>
<% String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()){ %>
<h2><%=msg %></h2>
<%} %>

<%if(errmsg!=null && !errmsg.isEmpty()){ %>
<h2><%=errmsg %></h2>
<%} %>

<fieldset style="text-align: center; margin-left: 300px;margin-right: 300px;">
<legend>Add Employee Form</legend>
<form action="./add" method="post">
<label for="id"> ID </label>
<input type="number" id="id" name="id" required="required"><br><br>
<label for="name"> NAME </label>
<input type="text" id="name" name="name" required="required"><br><br>
<label for="birthDate"> DATE OF BIRTH </label>
<input type="date" id="birthDate" name="birtDate" required="required"><br><br>
<label for="password"> PASSWORD </label>
<input type="password" id="password" name="password" required="required"><br><br>
<input type="submit"><br><br>
</form>

</fieldset>
</body>
</html>