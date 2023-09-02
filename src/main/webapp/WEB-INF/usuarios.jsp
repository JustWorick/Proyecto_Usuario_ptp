<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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