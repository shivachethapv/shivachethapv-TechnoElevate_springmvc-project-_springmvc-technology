<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%String msg = (String) request.getAttribute("msg");
    String errmsg = (String) request.getAttribute("errmsg");
    int id = (int) request.getAttribute("id");
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
<%} %>

<%if(errmsg!=null && !errmsg.isEmpty()){ %>
<h1><%=errmsg %></h1>
<%} %>

<fieldset>
<legend>Update Form</legend>
<form action="./update" method="post">
<label for="id"> ID : <%=id %> </label>
<input type="number" id="id" name="id" value="<%=id %>" hidden="true" required="required"><br><br>
<label for="name"> NAME </label>
<input type="text" id="name" name="name"><br><br>
<label for="dob"> DATE OF BIRTH </label>
<input type="date" id="dob" name="dob"><br><br>
<label for="password"> PASSWORD </label>
<input type="password" id="password" name="password"><br><br>
<input type="submit"><br><br>
</form>
</fieldset>
</body>
</html>