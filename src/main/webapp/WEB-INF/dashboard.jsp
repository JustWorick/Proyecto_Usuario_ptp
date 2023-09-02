<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>Bienvenido a Dashboard</h1>
			<a href="/nuevo" class="btn btn-success">Nuevo Usuario</a>
			<a href="/nuevaDireccion" class="btn btn-success">Nueva Direccion</a>
		</header>
		<table class="table table-hover">
		<!--  -->
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Pais</th>
					<th>Hoobies</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.nombre} ${usuario.apellido}</td>
						<td>${usuario.direccion.pais}</td>
						<td></td>
						<td>
							<form action="/delete/${usuario.id}/${usuario.direccion.id}" method="post" style="margin-top:5px;">
							    <input type="submit" value="Delete" class="btn btn-danger">
								<input type="hidden" name="_method" value="delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>