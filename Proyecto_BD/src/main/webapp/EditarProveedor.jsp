
<%@page import="clases.Proveedores"%>
<%@page import="clases.RubroProveedor"%>

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
	Proveedores subject = (Proveedores) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet8" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Proveedor</h1>
				<label class="text-secondary">Código Proveedor</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getPrvCod() : ""%>" readonly
					onmousedown="return false;">
			</div>
			<div class="form-group">
				<label class="text-secondary">Nombre Proveedor</label><br> <input
					class="form-control" type="text" name="name" id="name"
					value="<%=(subject != null) ? subject.getPrvNom() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Teléfono Proveedor</label><br> <input
					class="form-control" type="text" name="phone" id="phone"
					value="<%=(subject != null) ? subject.getPrvTel() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Dirección Proveedor</label><br> <input
					class="form-control" type="text" name="dir" id="dir"
					value="<%=(subject != null) ? subject.getProDir() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary" for="name">Rubro Proveedor</label><br>
				<select id="rub" name="rub"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
					<%
					List<RubroProveedor> listSubject = (List<RubroProveedor>) request.getAttribute("data2");
					if (listSubject != null) {
						for (RubroProveedor item : listSubject) {
					%>
					<option value="<%=item.getRubProCod()%>"
						<%=(subject != null && subject.getRubPrv() == item.getRubProCod()) ? "selected" : ""%>>
						<%=(item.getRubEstReg().equals("*")) ? "Eliminado" : item.getRubNom()%>
					</option>
					<%
					}
					}
					%>
				</select><br>
			</div>
			<br>
			<div class="form-group">
				<br> <label class="text-secondary" for="estado">Estado</label><br>
				<input class="form-control" type="text" name="estado" id="estado"
					value="<%=texto%>" readonly onmousedown="return false;" /><br>
				<br>
			</div>
			<button type="submit" class="btn-primary">Actualizar</button>
		</form>
		<div class="button-container">
			<a href="Servlet8?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>