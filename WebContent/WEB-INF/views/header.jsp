<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parknyc.entities.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Header</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/header.css">
</head>
<body> --%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/header.css">
	<header>
	
  		<% 
 		/* 	out.print(session.getAttribute("userLogin")); */
			User sessionUser = (User) session.getAttribute("userLogin");
			if (sessionUser.getFirstName() != null) {
				String name = sessionUser.getFirstName();
				out.print("<p id='name'>Hi, " + name + "</p>");
			}
		
		%>
		
<%-- 		<c:set var="name" value="${userLogin.getUsername()}" />
		<c:if test="${name != null}">
			<c:out value="name"/>
		</c:if> --%>
		
 		<a id="brand" href="${pageContext.request.contextPath}/index">ParkNYC</a>
		<a id="login" href="${pageContext.request.contextPath}/login">Log In</a>
		<a id="register" href="register">Sign Up</a>
		
		<!-- <button id="login" type="button">Log In</button>
		<button id="register" type="button">Sign Up</button> -->
		
	</header>
<!-- </body>
</html> -->