<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Review</title>

</head>
<body>
			
			<jsp:useBean id="fr" class="com.sunbeam.beans.FindReviewBean" scope="request"></jsp:useBean>
			<jsp:setProperty property="reviewId" name="fr" param="id"/>
			${fr.findReview()}
			<center>
			
			Hello,${lb.user.firstName} ${lb.user.lastName}<hr/>
			<H2>UPDATE REVIEW</H2><hr/>
			
			<form method="post" action="updatereview.jsp" >
				<input type="hidden" name="id" value="${fr.review.id}">
				<input type="hidden" name="movieId" value="${fr.review.movieId}"><br/><br/>
				UserId:<input type="number" name="userId" value="${fr.review.userId}"readonly><br/><br/>
				Rating:<input type="number" name="rating" value="${fr.review.rating}" ><br/><br/>
				Review:<textarea rows="3" cols="20" name="review"  >
							${fr.review.review}
						</textarea>
						<br/><br/> 
				
				<input type="submit" value="Update Review">
			</form>
			</center>
</body>
</html>