
<%@page import="clases.Estantes"%>
<%@page import="clases.Almacenes"%>

<%@ page import="java.util.*"%>
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
	Estantes subject = (Estantes) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet7" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Estante</h1>
				<label class="text-secondary">Número del Estante</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getEstNum() : ""%>" readonly
					onmousedown="return false;">
			</div>
			<div class="form-group">
				<label class="text-secondary" for="name">Cóigo del Almacen</label><br>
				<select id="alm" name="alm"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
					<%
					List<Almacenes> listSubject = (List<Almacenes>) request.getAttribute("data2");
					if (listSubject != null) {
						for (Almacenes item : listSubject) {
					%>
					<option value="<%=item.getAlmNum()%>"
						<%=(subject != null && subject.getAlmNum() == item.getAlmNum()) ? "selected" : ""%>>
						<%=(item.getAlmEstReg().equals("*")) ? "Eliminado" : item.getAlmDir()%>
					</option>
					<%
					}
					}
					%>
				</select><br>
			</div>
			<br>
			<div class="form-group">
				<label class="text-secondary">Capacidad</label><br> <input
					class="form-control" type="text" name="cap" id="cap"
					value="<%=(subject != null) ? subject.getEstCap() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<br> <label class="text-secondary" for="estado">Estado</label><br>
				<input class="form-control" type="text" name="estado" id="estado"
					value="<%=texto%>" readonly onmousedown="return false;" /><br>
				<br>
			</div>
			<button type="submit" class="btn-primary">Actualizar</button>
		</form>
		<div class="button-container">
			<a href="Servlet7?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>