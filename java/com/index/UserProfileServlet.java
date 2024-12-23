package com.index;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false); // Retrieve existing session
        PrintWriter out = response.getWriter();

        if (session != null) {
            String username = (String) session.getAttribute("username");
            String email = (String) session.getAttribute("email");
            long age=(long) session.getAttribute("age");
            long phoneno=(long) session.getAttribute("phoneno");
            String gender=(String) session.getAttribute("gender");
            
            if (username != null && email != null ) {
                out.print(String.format(
                    "{\"username\": \"%s\", \"email\": \"%s\", \"age\": \"%d\",\"phoneno\": \"%d\",\"gender\": \"%s\"}",
                    username, email,age,phoneno,gender));
            } else {
                out.print("{\"error\": \"Session data missing\"}");
            }
        } else {
            out.print("{\"error\": \"No session found\"}");
        }    
        
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
