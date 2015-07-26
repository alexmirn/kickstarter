<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter/oneProject</title>
</head>
<body>

<h1>Project full description:</h1>

		<p> Project name: <c:out value="${oneProject.name}" /> </p>
		<p>	Description: <c:out value="${oneProject.shortDescription}" /> </p>
		<p>	Nedded Money: <c:out value="${oneProject.totalSum}" /> </p>
		<p>	Already get money: <c:out value="${oneProject.pledged}" /> </p>
		<p>	Project history: <c:out value="${oneProject.history}" /> </p>
		<p>	Videolink: <c:out value="${oneProject.videoLink}" /> </p>
		<p>Questions:
		<c:forEach var="question" items="${questions}">
			<p>Question: <c:out value="${question.name}" /></p>
			<p>User: <c:out value="${question.user.name}" /></p>

			<c:forEach var="answer" items="${question.answers}">
				<p>Answer: <c:out value="${answer.name}" /></p>
				<p>User: <c:out value="${answer.user.name}" /></p>
			</c:forEach>

		</c:forEach>
		</p>
		<div class="row">
			<div class="col-xs-9">
			</div>
			<div class="col-xs-3">
				<div class="text-right">
					<form method="POST" action="/kickstarter/logout">
						<div class="form-group">
							<button type="submit" class="btn btn-default">Logout</button>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>