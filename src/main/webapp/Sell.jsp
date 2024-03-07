<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Sell</title>
</head>
<body>
<h5 style="text-align: center;" class="topp">FREE SHIPPING ALL OVER INDIA | EARN LOYALTY POINTS WITH EVERY ORDER</h5>

<div class="topnav">
	  <a href="Home.jsp">Home</a>
	<% if (request.getSession().getAttribute("user") != null) {%>
	  <a href="Show">Show</a>
	  <a href="Sell" class = "active">Sell</a>
	  <a href="Purchase">Purchase</a>
	  <a href = "Logout">Logout</a>
	  
	  <%} %>
</div>

<%if (request.getSession().getAttribute("sell") != null && request.getSession().getAttribute("user") != null){
	
		ResultSet res = (ResultSet)request.getSession().getAttribute("sell");%>
		
  		<%while (res.next()) { %>
			<div class="columns">
	  			<ul class="price">
		  			<li class="header">Brand : <%=res.getString(2) %></li>
				    <li class="grey"><%=res.getString(3) %></li>
				    <li>Price : <%=res.getDouble(4) %></li>
				    <li>Available quantity : <%=res.getInt(5) %></li>
			    <li class="grey">
				    	<form method = "post" action = "Sell">
				    		<label class = "quan">Quantity : </label>
				    		<input class = "quan" name = "quantity" type = "number" placeholder = "Enter quantity for sale" min = "1" max = "<%=res.getInt(5)%>"/>
				    		<input name = "product_id" type = "hidden" value = <%= res.getInt(1)%> />
				    		<input name = "sell" type = "submit" class="button" value = "Sell"/>
				    	</form>
			    	</li>
			    </ul>
	  		</div>
  		<%}%>
	
	<% } %>
     
    
<footer id="footer">
   <p class="copyri">© Copyright Lappy-Market-Place</p>
</footer>

</body>
</html>