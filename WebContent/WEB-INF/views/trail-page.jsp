<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parknyc.entities.Trail, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.parknyc.entities.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Trails | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/trail-page.css">
		<script
	  src="https://code.jquery.com/jquery-3.5.1.min.js"
	  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	  crossorigin="anonymous">
		</script>
</head>

<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<%-- <%= request.getAttribute("trail")%> <br> --%>
	<!-- <div class="container"> -->
	<form id="search" action="${pageContext.request.contextPath}/results" method="get" >
	   	<input type="text" placeholder="Pelham Bay Park, Kazimiroff Trail ..." name="search-input">
	    <input type="submit" name="search" value="Search"> <br>
	</form>
	<div class="trail-container">
		<c:forEach items="${trail}" var="trail" >
 			<div class="trail-image" style="background-image: url(${pageContext.request.contextPath}/${trail.getImage()})">
				<h1> ${trail.getTrailName()} </h1>
				<h3> ${trail.getParkName()} </h3>
				<%-- <div> ${trail.getDifficulty()} </div> --%>
			</div>
			
			<div class = "trail-text">
				<p id="trail-description"> ${trail.getDetails()} </p> <hr>
				<table>
					<tr>
						<th>Length</th>
						<th>Difficulty</th>
						<th>Accessibility</th>
					</tr>
					<tr>
						<td> ${trail.getLength()} </td>
						<td> ${trail.getDifficulty()} </td>
						<td> ${trail.getAccessibility()} </td>
					</tr>
				</table>
				<hr>
				<p> Location: ${trail.getLocation()} </p>
				<div id="trail-reviews">
					<h3>Reviews</h3>
 					<% User sessionUser = (User) session.getAttribute("userLogin");
						if (sessionUser.getFirstName() != null) {
							out.print("<form class='review-form' method='post'>" +
										"<script>" +
											"$(document).ready(function(){ " +
											    // check radio-box
											    "$(''.rating input:radio').attr('checked', false);" +
						
											    "$('.rating input').click(function () {" +
											        "$(''.rating span').removeClass('checked');" +
											        "$(this).parent().addClass('checked');" +
											    "});" +
											"});" +
										"</script>" +
										"<div class='rating'><p>Rating:</p>" +
										    "<span><input type='radio' name='rating' id='str5' value='5'><label for='str5'></label></span>" +
										    "<span><input type='radio' name='rating' id='str4' value='4'><label for='str4'></label></span>" +
										    "<span><input type='radio' name='rating' id='str3' value='3'><label for='str3'></label></span>" +
										    "<span><input type='radio' name='rating' id='str2' value='2'><label for='str2'></label></span>" +
										   	"<span><input type='radio' name='rating' id='str1' value='1'><label for='str1'></label></span>" +
										"</div>" +
										 //name should be same as variable in entity
										"<textarea name='review'></textarea> <br>" +
										"<input type='submit' name='review' value='Submit'>" +
									  "</form>"); 
									   			
						} 
					%>
					<c:forEach items="${reviews}" var="review" >
						<hr>
						<p> User: ${review.getUser()} </p>
						<p> Rating: ${review.getRating()}/5</p>
						<p> Review: ${review.getReview()} </p>
						<hr>
					</c:forEach>
				</div>
			</div>
		</c:forEach>

		
	</div>
<!-- 	</div> -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>