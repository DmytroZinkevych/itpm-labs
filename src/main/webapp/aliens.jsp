<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Programmers</title>
</head>
<body>
	<h2>Programmers</h2>
	<table>
		<tr><th>ID</th><th>Name</th><th>Skill</th></tr>
		<c:forEach items="${aliens}" var="alien" >
			<tr><td>${alien.aid}</td><td>${alien.aname}</td><td>${alien.tech}</td></tr>
		</c:forEach>
	</table>
</body>
</html>