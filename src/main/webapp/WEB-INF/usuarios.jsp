<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>${titulo}</h1>
	<ul>
		<c:forEach items="${listaUsuarios}" var="Usuario">
			<li>${Usuario}</li>
		</c:forEach>
		<br>
		<c:forEach items="${paises}" var="pais">
			<li>
				${pais.key} - ${pais.value}
				<c:if test="${pais.key == 'Chile'}">
					<b>Es el mejor pais de Chile</b>
				</c:if>
			</li>
		</c:forEach>
	</ul>
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>