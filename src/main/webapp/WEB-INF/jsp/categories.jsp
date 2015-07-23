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
	<a href="/kickstarter/user">Registration</a>
</body>
</html>