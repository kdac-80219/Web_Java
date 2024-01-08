<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Review</title>
</head>
<body>
	<jsp:useBean id="dr" class="com.sunbeam.beans.ReviewDelete"  scope="session"/>
	<jsp:setProperty name="dr" property="id" param="id" />
	
	${dr.DeleteReview()}
	<jsp:forward page="review.jsp" />
	
</body>
</html>