<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Account Registration Success | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/create-account-success.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="message">
			<h4>Account successfully created!</h4>
			<a href="login">Log in</a> <br>
			<a href="index">Go back to homepage</a>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>