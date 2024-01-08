<%@ page import="com.sunbeam.beans.LoginBean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUTHENTICATION</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"  scope="session"/>
	<jsp:setProperty name="lb" property="email" param="email" />
	<jsp:setProperty name="lb" property="password" param="password" />
	<jsp:setProperty name="lb" property="status" value="false" />
	<% lb.authenticate(); %>
	
	Login Status : <jsp:getProperty name="lb" property="status" /><br></br>
		<c:choose>
				<c:when test="${ empty lb.user}">
						Invalid Username or Password!!!Please try again....<br/><br/>
						<a href="index.jsp">Login Again</a>
				</c:when>
				<c:when test="${not empty lb.user }">
						<c:redirect url="review.jsp" /> 
				</c:when>
				<c:otherwise>
						<c:redirect url="review.jsp" />
				</c:otherwise>
		</c:choose>
	<c:redirect url="review.jsp" >Show Review</c:redirect>
	
	
</body>
</html>