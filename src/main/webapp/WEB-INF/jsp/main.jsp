<%@ page language="java" contentType="text/html; charset=windows-1256"
		 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>

<body background="">
<div id="header">
	<h1 align="center">Kickstarter</h1>
</div>

<div id="response">
	<p id="quoteText" align="center"></p>
</div>

<div id="categoryDiv">
	<table id="categoriesList" align="center"></table>
</div>

<script>
		$.getJSON('v1/category', function(data){
			categoriesHandler(data);
		});

	function categoriesHandler (categories) {
		var categoriesRow = [];
		categoriesRow.push("<tr>");
		$.each(categories, function(i, category) {
			categoriesRow.push("<td>" + category.name + "</td>");
		});
		categoriesRow.push("</tr>");
		$('#categoriesList').html(categoriesRow.join(""));
	}
</script>

<script>
	getRanomQuote();
	var textField;

		function getRanomQuote() {

			textField =document.getElementById("quoteText");
		 $.getJSON('v1/quote/random', function(data){
				textField.innerHTML = data.quote;
			});
		}
</script>

</body>
</html>