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
 * Servlet implementation class UserDetails
 */
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        HttpSession session1 = request.getSession(false); // Get existing session
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // Ensure response is JSON

        if (session1 != null) {
            String username = (String) session1.getAttribute("username");
            String email = (String) session1.getAttribute("email");
           

            // Prevent null values in JSON response
            username = (username != null) ? username : "";
            email = (email != null) ? email : "";
          

            out.print("{");
            out.print("\"username\": \"" + username + "\",");
            out.print("\"email\": \"" + email + "\",");
           
            out.print("}");
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
