
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
		<div class=" jumbotron" > <%--//need to create table for better ui...--%> 
		<form method="post" action="registration.jsp" >
		First Name: <input type="text" name="firstName"/><br/><br/>
		Last Name : <input type="text" name="lastName"/><br/><br/>
		Email:<input type="text" name="email" /><br/><br/>
		Password:<input type="password" name="password"/><br/><br/>
		Mobile:<input type="text" name="mobile"/><br/><br/>
		Birth Date: <input type="date" name="bDate" /><br/><br/>
		
		<input type="submit" value="Register"/>
		</form>
		</div>
</body>
</html>