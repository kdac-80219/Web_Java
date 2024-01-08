<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	
	<jsp:useBean id="rb" class="com.sunbeam.beans.ReviewListBean" />
	
	
	${rb.Listreview()}
	<center>
	Welcome , ${lb.user.firstName} ${lb.user.lastName} <br/><br/>	
	
		<a href="logout.jsp">Log Out</a> |  <a href="addreview.jsp">Add Review</a><hr/>
	
	<h1>RIVIEW LIST</h1><hr/>
	<table border="1" class="table table-dark table-hover">
		<thead >
			<tr>
				<th>REVIEW ID</th>
				<th>MOVIE ID</th>
				<th>MOVIE NAME</th>
				<th>REVIEW</th>
				<th>RATING</th>
				<th>USERID</th>
				<th>MODIFICATION</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="c" items="${rb.reviewList}">
					<tr>
						<td>${c.id}</td>
						<td>${c.movieId }</td>				
					    <td>
							<c:forEach var="m" items="${rb.movieList}">
								<c:if test="${c.movieId==m.id}">
									${ m.name}
								</c:if>
							</c:forEach>	
						</td>
						<td>${c.review}</td>
						<td>${c.rating}</td>
						<td>${c.userId}</td>
						<td>${c.modified}</td>
						<td>
							<c:if test="${c.userId==lb.user.id}">
							<a href="deletereview.jsp?id=${c.id}">Delete</a>
							<a href="editreview.jsp?id=${c.id}">Edit</a>
							</c:if>
						</td>
						
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</center>
</body>
</html>