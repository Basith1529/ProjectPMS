<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.index.CustomerDAO" %>
<jsp:useBean id="c" class="com.index.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>
<%
String message="";
int i=CustomerDAO.save(c);
try{
if(i>0)
{
	//message="success";
	response.sendRedirect("payment.html");
}
else
{
	response.sendRedirect("Cart.html");
}
}
catch(Exception e){
	out.println(e);
}
%>
</body>
</html>