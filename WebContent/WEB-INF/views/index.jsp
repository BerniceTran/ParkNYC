<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ParkNYC: NYC Park Trail Guides</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/styles/index.css">
</head>
<body>
	<jsp:include page="header2.jsp"></jsp:include>
	<div id="marketing-features">
		<section class="visual">
			<div id="search-container">
				<div id="search-container-items">
					<h1>Find your next favorite city trail</h1>
					<form action="results" method="get" >
					   	<input type="text" placeholder="Pelham Bay Park, Kazimiroff Trail ..." name="search-input">
					    <input type="submit" name="search" value="Search"> <br>
					    <!-- Park <input type="radio" name="option" value="1">
					    Trail <input type="radio" name="option" value="2"> -->
					</form>
				</div>
			</div>
		</section>
		<section class="textband">
			<div id="textband-text">
				<h1>1,000+ trails. Endless possibilities.</h1>
				<p>
					The beauty of nature doesn’t need to be hard to find, especially in NYC. Here, you will find trail guides, so you can explore the outdoors with confidence, just steps away from your door.
				</p>
			</div>
		</section>
		<section class="visual2">
			
		</section>
		<section class="textband">
			<div id="textband-text">
				<h1>Know what to expect with content from outdoor enthusiasts like you.</h2>
				<p>
					Look at reviews to plan your next hiking trip and write reviews to give advice to New Yorkers and visitors.
				</p>
			</div>
		</section>
	</div> 
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
