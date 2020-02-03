<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body>
	<h2>I'm Home Page JSP</h2>
	<p>Display all student</p>
	<table>
	<tr>
		<th>Student Id</th>
		<th>Student Name</th>
		<th>Student Age</th>
	</tr>
	<c:forEach items="${allStudents}" var="student">
    <tr>
        <td>${student.getId()}</td>
    	<td>${student.getName()}</td>
        <td>${student.getAge()}</td>
    </tr>
	</c:forEach>
	</table>
	<h3>${allStudents}</h3>
</body>
</html>