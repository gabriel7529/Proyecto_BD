
<%@page import="clases.Productos_Entradas_Cabecera"%>
<%@page import="clases.Proveedores"%>
<%@page import="clases.Estantes"%>
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
	String rsp = (String) request.getAttribute("respuesta");
	String type = (String) request.getAttribute("type");
	Productos_Entradas_Cabecera subject = (Productos_Entradas_Cabecera) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet9" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Entradas Producto Cabecera</h1>
				<label class="text-secondary">Código</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getEntCabCod() : ""%>"
					readonly onmousedown="return false;">
			</div>


			<br> <label class="text-secondary" for="name">Nombre de
				Proveedores </label><br> <select id="prov" name="prov"
				<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
				<%
				List<Proveedores> listSubject2 = (List<Proveedores>) request.getAttribute("data2");
				if (listSubject2 != null) {
					for (Proveedores item : listSubject2) {
				%>
				<option value="<%=item.getPrvCod()%>"
					<%=(subject != null && subject.getPrvCod() == item.getPrvCod()) ? "selected" : ""%>>
					<%=(item.getPrvEstReg().equals("*")) ? "Eliminado" : item.getPrvNom() %>
				</option>
				<%
				}
				}
				%>
			</select><br><br><label class="text-secondary" for="name">Capacidad Estante</label><br>
			<select id="est" name="est"
				<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
				<%
				List<Estantes> listSubject = (List<Estantes>) request.getAttribute("data3");
				if (listSubject != null) {
					for (Estantes item : listSubject) {
				%>
				<option value="<%=item.getEstNum()%>"
					<%=(subject != null && subject.getEstNum() == item.getEstNum()) ? "selected" : ""%>>
					<%=(item.getEstReg().equals("*")) ? "Eliminado" : item.getEstCap()%>
				</option>
				<%
				}
				}
				%>
			</select><br> <br>
			<div class="form-group">
				<label class="text-secondary">Año</label><br> <input
					class="form-control" type="text" name="ano" id="ano"
					value="<%=(subject != null) ? subject.getEntcabfecAno() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Mes</label><br> <input
					class="form-control" type="text" name="mes" id="mes"
					value="<%=(subject != null) ? subject.getEntcabfecMes() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Día</label><br> <input
					class="form-control" type="text" name="dia" id="dia"
					value="<%=(subject != null) ? subject.getEntcabfecDia() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary" for="estado">Estado</label><br> <input
					class="form-control" type="text" name="estado" id="estado"
					value="<%=rsp%>" readonly onmousedown="return false;" /><br>
			</div>

			<button type="submit" class="btn-primary">Actualizar</button>
		</form>
		<div class="button-container">
			<a href="Servlet9?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>