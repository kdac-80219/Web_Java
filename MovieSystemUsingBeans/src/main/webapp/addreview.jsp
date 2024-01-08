<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD REVIEW</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
		
	
			
		<div height=100px width=100px class="container table table-striped table-dark">
			<form method = "post" action="newreview.jsp" >
			<center>
			Welcome , ${lb.user.firstName} ${lb.user.lastName}<hr/>
				<h2>ADD REVIEW</h2><hr/>
		
				<table >
					<tr>
						<td>Movie Id :</td>
						<td><input type="number" name="movieId" /></td>
					</tr>
					<tr>
						<td>Review :</td>
						<td><input type="text" name="review" /></td>
					</tr>
					<tr>
						<td>Rating :</td>
						<td><input type="number" name="rating" /></td>
					</tr>
					<tr>
						<td>User Id :</td>
						<td><input type="number" name="userId" /></td>
					</tr>
	
					<tr>
						<td></td>
						<td><input type="submit" value="Add Review" /></td>
					</tr>
					
				</table>
			</center>	
		
			</form>
		</div>
		
		
</body>
</html>