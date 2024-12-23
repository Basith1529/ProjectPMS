<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="com.index.UserDAO" %>
<%@ page import="java.util.Map" %>

<%

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String message = "";

    if (UserDAO.validateUser(email, password)) {
        Map<String,Object> userDetails = UserDAO.getUserDetails(email);
        
        HttpSession session1 = request.getSession();
        session1.setAttribute("username", userDetails.get("username"));
        session1.setAttribute("email", email);
        session1.setAttribute("dob", userDetails.get("dob"));
        session1.setAttribute("age", userDetails.get("age"));
        session1.setAttribute("phoneno", userDetails.get("phoneno"));
        session1.setAttribute("gender", userDetails.get("gender"));
        
        message = "successful";
    }
     else {
        message = "Invalid";
    }
    response.sendRedirect("dash.jsp?message=" + message); 
    
%>

</body>
</html>