<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kickstarter/projects</title>
</head>
<body>

<h1>Select project:</h1>
<c:forEach var="project" items="${projects}">
		<h2>
			<%--<a href="/kickstarter/oneProject?project=${project.projectId}">--%>
			<a href="/kickstarter/oneProject/${project.projectId}">
				<c:out value="${project.name}" />
			</a>
				<p>	Description: <c:out value="${project.shortDescription}" /> </p>
				<p>	Nedded Money: <c:out value="${project.totalSum}" /> </p>
				<p>	Already get money: <c:out value="${project.pledged}" /> </p>
		</h2>
	</c:forEach>
	<div class="row">
		<div class="col-xs-3">
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
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<p>This is admin message</p>
	</security:authorize>
</body>
</html>