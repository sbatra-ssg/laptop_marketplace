<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
<h5 style="text-align: center;" class="topp">FREE SHIPPING ALL OVER INDIA | EARN LOYALTY POINTS WITH EVERY ORDER</h5>
                
<div class="topnav">
	  <a class="active" href="Home.jsp">Home</a>
	<% if (request.getSession().getAttribute("user") != null) {%>
	  <a href="Show">Show</a>
	  <a href="Sell">Sell</a>
	  <a href="Purchase">Purchase</a>
	  <a href="PL.jsp">Profit/Loss</a>
	  <a href = "Logout">Logout</a>
	  
	  <%} %>
</div>

<%if (request.getSession().getAttribute("result") != null){
	
		ResultSet res = (ResultSet)request.getSession().getAttribute("result");%>
		
  		<%while (res.next()) { %>
			<div class="columns">
  			<ul class="price">
  			<li class="header">Brand : <%=res.getString(1) %></li>
		    <li class="grey"><%=res.getString(2) %></li>
		    <li>Price : <%=res.getDouble(3) %></li>
		    <li>Available quantity : <%=res.getInt(4) %></li>
		    <li class="grey"><a href="#" class="button">Explore</a></li>
		    </ul>
	  		</div>
  		<%}%>
	
	<% } %>

<footer id="footer">
	<p class="copyri">© Copyright Lappy-Market-Place</p>
</footer>

</body>
</html>