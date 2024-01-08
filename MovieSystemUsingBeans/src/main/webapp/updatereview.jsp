<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating....</title>
</head>
<body>
		<jsp:useBean id="ur" class="com.sunbeam.beans.UpdateReviewBean" />
		 <jsp:setProperty property="id" name="ur"/> 
		  <jsp:setProperty property="movieId" name="ur"/> 
		   <jsp:setProperty property="userId" name="ur"/> 
		    <jsp:setProperty property="rating" name="ur"/> 
		     <jsp:setProperty property="review" name="ur"/> 
			${ur.UpdateReview()}
		
		<jsp:forward page="review.jsp" />
</body>
</html>