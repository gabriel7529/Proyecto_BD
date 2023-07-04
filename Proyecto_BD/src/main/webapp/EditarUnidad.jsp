<%@page import="clases.Unidad_Medida"%>
<%@page import="java.lang.String"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	Unidad_Medida subject = (Unidad_Medida) request.getAttribute("subject");
	%>
	
	<div class="container">
	<form action="Servlet4" method="post">
		<input type="hidden" name="type" id="type" value="edit">
		<div class="form-group">
		<h1>Editar Unidad de Medida</h1>
			<label class="text-secondary">Código</label><br><input name="code"
				id="code" value="<%=(subject != null) ? subject.getUniMedCod() : ""%>"
				readonly onmousedown="return false;">
		</div>
		<div class="form-group">
			<label class="text-secondary">Nombre</label><br><input
				class="form-control" type="text" name="name" id="name"
				value="<%=(subject != null) ? subject.getUniMedNom() : ""%>"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*") ) ? "" : "readonly"%>>
		</div>
		<div class="form-group">
			<label class="text-secondary">Estado de Unidad de Medida</label><br>
			<input class="form-control" type="text" name="estado" id="estado"
				value="<%=texto%>" readonly onmousedown="return false;" /><br>
			<br>
		</div>
		
			<button type="submit" class="btn-primary">Actualizar</button>	
	</form>
	<div class="button-container">
	<a href="Servlet4?type=list">
				<button>Cancelar</button>
			</a>
			<a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
	</div>
	</div>
</body>
</html>