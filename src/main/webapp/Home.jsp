<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Babylonica&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e833509d51.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://kit.fontawesome.com/e833509d51.css" crossorigin="anonymous">
    
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>This is the default webpage</title>
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
	  </div>
	  <div>
	  	<h1>Welcome Admin,</h1>
	  	<p>This is a marketplace for buying and selling laptops of different brands.</p>
	  	<p>Hope you'll like it !!</p>
	  </div>
	  
	  <%} else {%>
	  
  
  <div class="login-form">
  <form method = "post" action = "Login">
    <h1>Login</h1>
    <div class="content">
      <div class="input-field">
        <input type="email" placeholder="Email" autocomplete="nope" name = "username" >
      </div>
      <div class="input-field">
        <input type="password" placeholder="Password" autocomplete="new-password" name = "password">
      </div>
    </div>
    <div class="action">
      <input type = "submit" value = "Sign In" class = "button"/>
    </div>
  </form>
  <img class="title-image" src="logo-white.png" alt="iphone-mockup">
</div>

<%} %>








<footer id="footer">
	<p class="copyri">© Copyright Lappy-Market-Place</p>
</footer>

</body>
</html>