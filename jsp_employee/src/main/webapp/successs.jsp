<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String name=(String)request.getAttribute("cookie"); 
     if(name!=null){
    %>
    <h2> changed by<%=name %></h2>
    <%} %>

	<%
	List<Employee> employees = (List) request.getAttribute("list");
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th>ADDRESS</th>
			<th>PASSWORD</th>
		</tr>
		<%
		for (Employee employee : employees) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getEmail()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPassword()%></td>
			<td><a href="delete?id=<%=employee.getId()%>"><button>Delete</button></a>
			<td><a href="update?id=<%=employee.getId()%>"><button>Update</button></a>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>