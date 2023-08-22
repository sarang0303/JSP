<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Employee employee = (Employee) request.getAttribute("emp");
	%>
	<form action="edit" method="post">
		ID:<input type="number" name="id" value=<%=employee.getId()%> readonly="readonly"><br>
		<br> Name:<input type="text" name="name" value=<%=employee.getName()%>><br>
		<br> Phone No:<input type="tel" name="phone" value=<%=employee.getPhone()%>><br>
		<br> Address:<input type="text" name="address" value=<%=employee.getAddress()%>><br>
		<br> Email:<input type="email" name="email" value=<%=employee.getEmail()%>><br>
		<br> Password:<input type="text" name="password" value=<%=employee.getPassword()%>><br>
		<br>
		<button>Update</button>




	</form>

</body>
</html>