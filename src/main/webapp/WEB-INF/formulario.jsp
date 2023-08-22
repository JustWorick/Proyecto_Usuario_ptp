<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registro</title>
</head>
<body>
	<div class="container">
		<h1>Registra tu usuario</h1>
		<form action="/registrarme" method="POST">
			<div>
				<label>Nombre</label>
				<input type="text" name="nombre" placeholder="Escribe tu nombre" class="form-control">
			</div>
			<div>
				<label>E-mail</label>
				<input type="email" name="email" class="form-control">
			</div>
			<input type="submit" value="Enviar" class="btn btn-success">
			<p class="text-danger">${error}</p>
		</form>
	</div>
</body>
</html>