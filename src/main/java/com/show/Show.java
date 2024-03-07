package com.show;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcconnection.SQLConnection;

/**
 * Servlet implementation class Sell
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String readQuery = "Select product_name, product_desc, product_price, product_quantity from available_to_sell";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con = SQLConnection.createConnection();
		
		PreparedStatement stm = null;
		
		try {
			
			stm = con.prepareStatement(readQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		try {
			
			ResultSet rs = stm.executeQuery();	
			
			request.getSession().setAttribute("show", rs);
			RequestDispatcher rd = request.getRequestDispatcher("Show.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			
			e.printStackTrace();
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
