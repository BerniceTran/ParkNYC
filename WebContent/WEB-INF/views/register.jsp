<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Register | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/register.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="container">
		<div id="login-container">
			<h1>Create your account</h1>
			<form action="success" method="post">
				<input type="text" placeholder="First name" name="firstName"> <br> <!-- name has to be same as in entity -->
				<input type="text" placeholder="Email" name="email"> <br>
				<input type="text" placeholder="Password" name="password"> <br>
				<input type="submit" name="register" value="Register">
			</form>
			
<!-- 			<h2><span>THIS IS A TEST</span></h2> -->
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>