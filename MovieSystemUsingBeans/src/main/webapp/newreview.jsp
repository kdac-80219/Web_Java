<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Review</title>
</head>
<body>	
		<jsp:useBean id="ar" class="com.sunbeam.beans.AddReview"></jsp:useBean>
		<jsp:setProperty property="movieId" name="ar"/>
		<jsp:setProperty property="review" name="ar"/>
		<jsp:setProperty property="rating" name="ar"/>
		<jsp:setProperty property="userId" name="ar"/>
		${ar.addReview()}>
		
		
		<c:redirect url="review.jsp" />
		
		
		
		
</body>
</html>