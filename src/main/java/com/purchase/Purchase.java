package com.purchase;

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
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Connection con = SQLConnection.createConnection();
	
	static PreparedStatement stm = null;
	
	public static final String readQuery = "Select product_id, product_name, product_desc, product_price, product_quantity, total_purchased from available_to_purchase";

	public static final String updateQuery = "Update available_to_purchase set product_quantity = product_quantity - ? , total_purchased =  total_purchased + ? where product_id = ?";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			
			stm = con.prepareStatement(readQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		try {
			
			ResultSet rs = stm.executeQuery();
			
			request.getSession().setAttribute("purchase", rs);
			
			RequestDispatcher rd = request.getRequestDispatcher("Purchase.jsp");
			
			rd.forward(request, response);
			
		} catch (SQLException e) {
						
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
				
		try {
			
			stm = con.prepareStatement(updateQuery);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		try {
			
			stm.setInt(1, quantity);
			
			stm.setInt(2, quantity);
			
			stm.setInt(3, productId);
			
			stm.execute();
			
//			request.getSession().setAttribute("purchase", rs);
			
//			RequestDispatcher rd = request.getRequestDispatcher("Purchase.jsp");
//			
//			rd.forward(request, response);
			
		} catch (SQLException e) {
						
			e.printStackTrace();
		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("Purchase.jsp");
//		
//		rd.forward(request, response);
		
		doGet(request, response);
		
		// TODO Auto-generated method stub
	}

}
