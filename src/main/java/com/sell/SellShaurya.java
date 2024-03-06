package com.sell;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
@WebServlet("/Sell")
public class SellShaurya extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String readQuery = "Select product_name, product_desc, product_price from available_to_sell";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellShaurya() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Connection con = SQLConnection.createConnection();
		
		PreparedStatement stm = null;
		try {
			
			stm = con.prepareStatement(readQuery);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ResultSet rs = stm.executeQuery();
			
			request.getSession().setAttribute("sell", rs);
			
			RequestDispatcher rd = request.getRequestDispatcher("Sell.jsp");
			rd.forward(request, response);
			
//			ArrayList lst = new ArrayList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
