<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parknyc.entities.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/header2.css">

<header>
	<nav class="navbar navbar-expand-md">
		<div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
<%-- 			<% 
				/* 	out.print(session.getAttribute("userLogin")); */
				User sessionUser = (User) session.getAttribute("userLogin");
				if (sessionUser.getFirstName() != null) {
					String name = sessionUser.getFirstName();
					out.print("<p id='name'>Hi, " + name + "</p>");
				}
		
			%> --%>
		</div>
        <div class="mx-auto order-0">
            <a class="navbar-brand mx-auto" href="/ParkNYC/index">ParkNYC</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
            <ul class="navbar-nav ml-auto">
 	            <%  
 	            	User sessionUser = (User) session.getAttribute("userLogin");

		 			if (sessionUser.getFirstName() != null) {
		 				String name = sessionUser.getFirstName();
						out.print("<p id='name'>Hi, " + name + "</p>" +
								  "<li class='nav-item'>" + 
                    				"<a class='nav-link' id='profile' href='profile'>My Profile</a>" +
	               				  "</li>"+
		               			  "<li class='nav-item'>" + 
	                				"<a class='nav-link' id='logout' href='logout'>Log Out</a>" +
	               				  "</li>");
					} else {
						out.print("<li class='nav-item'>" + 
	                    			"<a class='nav-link' id='login' href='login'>Log In</a>" +
		               			  "</li>" +
								  "<li class='nav-item'>" + 
                    				"<a class='nav-link' id='register' href='register'>Sign Up</a>" +
	               			 	  "</li>");
					} 
				
				%>
	            
               <!--  <li class="nav-item">
                    <a class="nav-link" id="login" href="/ParkNYC/login">Log In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="register" href="register">Sign Up</a> -->

         
                
                
            </ul>
       	</div>
   </nav>
</header>