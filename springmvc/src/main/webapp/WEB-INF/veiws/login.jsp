<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Login2</legend>
		<form action="./login" method="post">
		<table>
			<tr>
				<td>Enter name</td>
				<td>:</td>
				<td><input type="text"  name="user"></td>

			</tr>
			<tr>
				<td>Enter password</td>
				<td>:</td>
				<td><input type="password"  name="pswd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>

			</tr>
		</table>
		</form>
	</fieldset>
</body>
</html>