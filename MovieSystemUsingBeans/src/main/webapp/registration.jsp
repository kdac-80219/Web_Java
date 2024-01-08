<%@ page import="com.sunbeam.beans.RegisterBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:useBean id="rd" class="com.sunbeam.beans.RegisterBean" />
		<jsp:setProperty name="rd" property="*" />
		<% rd.addUser(); %>
	<%
		if(rd.getCnt()>0)
			out.println("User Added Successfully!!!!");
		else
			out.println("Failed!!! User not added!!!..");
	%> 
	
</body>
</html>