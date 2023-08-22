-<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>
	<form action="login" method="post">
		<h1>Email :</h1>
		<input type="text" name="email"><br> <br>
		<h1>Password :</h1>
		<input type="text" name="password"><br> <br> <input
			type="submit" name="submit">
	</form>

</body>
</html>