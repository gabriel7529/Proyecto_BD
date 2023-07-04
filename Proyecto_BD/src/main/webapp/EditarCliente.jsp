
<%@page import="clases.Clientes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/categoria.css" />
</head>
<body>
	<%
	Clientes subject = (Clientes) request.getAttribute("subject");
	String texto = (String) request.getAttribute("respuesta");
	String type = (String) request.getAttribute("type");
	%>
	<div class="container">
		<form action="SubjectServlet" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Unidad de Medida</h1>
				<label class="text-secondary">Código</label><br> <input
					name="code" id="code"
					value="<%=(subject != null) ? subject.getCliCod() : ""%>">
			</div>
			<div class="form-group">
				<label class="text-secondary">Nombre</label> <input
					class="form-control" type="text" name="name" id="name"
					value="<%=(subject != null) ? subject.getCliNom() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">RUC</label> <input
					class="form-control" type="text" name="ruc" id="ruc"
					value="<%=(subject != null) ? subject.getCliRuc() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Dirección</label> <input
					class="form-control" type="text" name="direc" id="direc"
					value="<%=(subject != null) ? subject.getCliDir() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Estado de Cliente</label><br> <input
					class="form-control" type="text" name="estado" id="estado"
					value="<%=texto%>" readonly onmousedown="return false;" /><br>
				<br>
			</div>
			<br>
			<div class="btn-group" role="group" aria-label="Basic Example">
				<button type="submit" class="btn btn-primary">Actualizar</button>
			</div>
		</form>
		<div class="button-container">
			<a href="Servlet4?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>