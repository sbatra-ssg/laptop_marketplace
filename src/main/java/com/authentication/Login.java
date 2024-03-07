package com.authentication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		if (userName.equals("admin@admin.com") && password.equals("admin")) {
			
			if (request.getSession().getAttribute("user") == null) {
			
				request.getSession().setAttribute("user", userName);
			
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			
				rd.forward(request, response);
			}
			
		}
		else {
			
			PrintWriter p = response.getWriter();
			
			p.print("<h1 style = 'color : red; text-align: center; margin-top : 250px'>Username and password doesn't match !!!</h1>");
		}
		
		// TODO Auto-generated method stub
	}

}
