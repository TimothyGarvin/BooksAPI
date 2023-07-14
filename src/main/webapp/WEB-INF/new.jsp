<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New</title>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="books" method="post" modelAttribute="book">
		<form:label path="title">Title: </form:label>
		<form:errors path="title"/>
		<div></div>
		<form:input type="text" path="title"/>
		<div></div><hr/>
		<form:label path="description">Description: </form:label>
		<form:errors path="description"/>
		<div></div>
		<div></div>
		<form:textarea path="description"></form:textarea>
		<div></div><hr/>
		<form:label path="language">Language: </form:label>
		<form:errors path="language"/>
		<div></div>
		<form:input type="text" path="language"/>
		<div></div><hr/>
		<form:label path="numberOfPages">Pages: </form:label>
		<form:errors path="numberOfPages"/>
		<div></div>
		<form:input type="number" path="numberOfPages"/>
		<div></div>
		<input type="submit" value="submit">
	</form:form>
	<hr/>
	<div></div>
		<a href="books"><button>Return Home</button></a>
</body>
</html>