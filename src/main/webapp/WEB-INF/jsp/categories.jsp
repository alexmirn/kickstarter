<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kickstarter</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
<h1><c:out value="${quote}" /></h1>
<h1>Please choose category:</h1>
	<c:forEach var="category" items="${categories}">
		<h2>
			<%--<a href="/kickstarter/projects?category=${category.id}">--%>
			<a href="/kickstarter/projects/${category.id}">
				<c:out value="${category}" />
			</a>
		</h2>
	</c:forEach>

	<div class="row">
		<div class="col-xs-3">
		</div>
		<div class="col-xs-3">
			<div class="text-right">
				<form method="POST" action="/kickstarter/categories">
					<div class="form-group">
						<label for="userLogin">Login</label>
						<input type="text" class="control-label" id="userLogin" placeholder="login">
					</div>
					<div class="form-group">
						<label for="userPassword">Password</label>
						<input type="password" class="control-label" id="userPassword" placeholder="password">
					</div>
					<div class="form-group">
						<label for="userEmail">Email</label>
						<input type="email" class="control-label" id="userEmail" placeholder="email">
					</div>
					<div class="form-group">
						<label for="userName">Name</label>
						<input type="text" class="control-label" id="userName" placeholder="user">
						<br>
						<button type="submit" class="btn btn-default">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>