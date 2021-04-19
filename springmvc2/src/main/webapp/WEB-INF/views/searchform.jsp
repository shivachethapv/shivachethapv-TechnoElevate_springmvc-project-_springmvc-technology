<%@page import="com.te.springmvc2.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg =(String) request.getAttribute("msg");
    EmployeeBean bean =(EmployeeBean) request.getAttribute("data");
    %>
   <%@ include file="header.jsp" %>
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
<legend>Search form</legend>
<form action="./search" method="get">
<label for="id"> ID </label>
<input type="number" id="id" name="id" required="required"><br><br>
<input type="submit">
</form>
<%
if(bean!=null){
	%>
	<h4>Name: <%=bean.getName() %></h4>
	<h4>ID: <%=bean.getId() %></h4>
	<h4>DOB: <%=bean.getBirtDate() %></h4>
	<%
}
	%>

</fieldset>
</body>
</html>