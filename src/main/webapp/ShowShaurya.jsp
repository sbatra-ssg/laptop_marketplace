<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Shaurya</h1>
	
	<% 
		if (request.getSession().getAttribute("result") != null){
			
			ResultSet res = (ResultSet)request.getSession().getAttribute("result");%>
			<table border = "3">
			<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			</thead>
			<tbody>
			
			<% while(res.next()){ %>
			
				<tr>
				<td><%= res.getString(1)%></td>
				<td><%= res.getString(2)%></td>
				<td><%= res.getDouble(3)%></td>
				<td><%= res.getInt(4) %></td>
				</tr>
				
			
			<% }  
			}
		%>
			</tbody>
			</table>

</body>
</html>