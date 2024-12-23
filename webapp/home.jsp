<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Basu Pet Store!</h1>
<a href="logout.jsp">Logout</a>

<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>

</body>
</html>