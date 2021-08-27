<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.parknyc.entities.Review, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>My Profile | ParkNYC</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/profile.css">
</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<h4>Hi, ${userLogin.getFirstName()}</h4>
	<div class="review">
	<h4>My Reviews</h4>
		<c:forEach items="${reviews}" var="review" >
			${review.getRating()}
		</c:forEach>
	</div>
	

	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>