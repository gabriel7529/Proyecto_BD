<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="clases.Almacenes"%>
<%@page import="java.lang.String"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadEditar.css" />
</head>
<body>
	<%
	String texto = (String) request.getAttribute("respuesta");
	String type = (String) request.getAttribute("type");
	Almacenes subject = (Almacenes) request.getAttribute("subject");
	%>
	
	<div class="container">
	<form action="Servlet6" method="post">
		<input type="hidden" name="type" id="type" value="edit">
		<div class="form-group">
		<h1>Editar Almacen</h1>
			<label class="text-secondary">Número</label><br><input name="code"
				id="code" value="<%=(subject != null) ? subject.getAlmNum() : ""%>"
				readonly onmousedown="return false;">
		</div>
		<div class="form-group">
			<label class="text-secondary">Dirección</label><br><input
				class="form-control" type="text" name="dir" id="dir"
				value="<%=(subject != null) ? subject.getAlmDir() : ""%>"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*") ) ? "" : "readonly"%>>
		</div>
		<div class="form-group">
			<label class="text-secondary">Estado de Almacen</label><br>
			<input class="form-control" type="text" name="estado" id="estado"
				value="<%=texto%>" readonly onmousedown="return false;" /><br>
			<br>
		</div>
		
			<button type="submit" class="btn-primary">Actualizar</button>	
	</form>
	<div class="button-container">
	<a href="Servlet6?type=list">
				<button>Cancelar</button>
			</a>
			<a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
	</div>
	</div>
</body>
</html>