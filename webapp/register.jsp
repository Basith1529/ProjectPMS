<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.index.UserDAO, java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.index.UserDAO" %>
<jsp:useBean id="u" class="com.index.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
String message="";
int i=UserDAO.save(u);
try{
if(i>0)
{
	message="success";
	
}
else if(i==0){
	message="failure";
}
else{
	message="error";
}
}
catch(Exception e){
	message="error";
}
response.sendRedirect("login.jsp?message=" + message);

%>
</body>
</html>