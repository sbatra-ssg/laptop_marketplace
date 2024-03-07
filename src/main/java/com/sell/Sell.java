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
public class Sell extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Connection con = SQLConnection.createConnection();
	
	static PreparedStatement stm = null;
	
	public static final String readQuery = "Select product_id, product_name, product_desc, product_price, product_quantity, total_sold from available_to_sell";
	
	public static final String updateQuery = "Update available_to_sell set product_quantity = product_quantity - ?, total_sold = total_sold + ? where product_id = ?";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sell() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			stm = con.prepareStatement(readQuery);
			
		} catch (SQLException e) {
			
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
		
		Integer product_id = Integer.parseInt(request.getParameter("product_id"));
		
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		try {
			
			stm = con.prepareStatement(updateQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		try {
			
			stm.setInt(1, quantity);
			
			stm.setInt(2, quantity);
			
			stm.setInt(3, product_id);
			
			stm.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
		
		
	}

}
