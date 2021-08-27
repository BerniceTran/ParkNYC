<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parknyc.entities.Trail, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Trails | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/results.css">
</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<form id="search" action="results" method="get" >
	   	<input type="text" placeholder="Pelham Bay Park, Kazimiroff Trail ..." name="search-input">
	    <input type="submit" name="search" value="Search"> <br>
	</form>
	<h5 id="search-text">Search results for: <%= request.getParameter("search-input")%></h5>
	<div class = "trails-container">
		<c:forEach items="${trails}" var="trail">
 			<a class="trail-container" href="trail-page/${trail.getTrailName()}">
				<div class="trail-image">
	 				<img src="${pageContext.request.contextPath}/${trail.getImage()}" alt="${trail.getTrailName()}">
				</div>
				<div class="trail-text">
					<h4> ${trail.getTrailName()} </h4>
					<p> ${trail.getParkName()} </p>
					<div> ${trail.getDifficulty()} </div>
					<p> Length: ${trail.getLength()} </p>
<%-- 					<p> ${trail.getDetails()} </p> --%>
				</div>
			</a>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>