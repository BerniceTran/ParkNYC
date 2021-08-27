<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/login.css">
</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<div id="container">
		<div id="login-container">
			<h1>Sign in to ParkNYC</h1>
			<form action="profile" method="post">
				<input type="text" placeholder="Email" name="email"> <br>
				<input type="password" placeholder="Password" name="password"> <br>
				<input type="submit" name="login" value="Log In">
			</form>
			
			<!-- <h2><span>THIS IS A TEST</span></h2> -->
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>