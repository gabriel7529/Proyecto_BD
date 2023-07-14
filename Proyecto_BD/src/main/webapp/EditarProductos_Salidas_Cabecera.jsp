
<%@page import="clases.Productos_Salidas_Cabecera"%>
<%@page import="clases.Clientes"%>

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
	Productos_Salidas_Cabecera subject = (Productos_Salidas_Cabecera) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet11" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Salidas Producto Cabecera</h1>
				<label class="text-secondary">Código</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getSalCod() : ""%>"
					readonly onmousedown="return false;">
			</div>
			<br> <label class="text-secondary" for="name">Nombre de
				Clientes </label><br> <select id="cli" name="cli"
				<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
				<%
				List<Clientes> listSubject2 = (List<Clientes>) request.getAttribute("data2");
				if (listSubject2 != null) {
					for (Clientes item : listSubject2) {
				%>
				<option value="<%=item.getCliCod()%>"
					<%=(subject != null && subject.getCliCod() == item.getCliCod()) ? "selected" : ""%>>
					<%=(item.getCliEst().equals("*")) ? "Eliminado" : item.getCliNom() %>
				</option>
				<%
				}
				}
				%>
			</select>
			<div class="form-group">
				<label class="text-secondary">Producto Precio Total</label><br> <input
					class="form-control" type="text" name="total" id="total"
					value="<%=(subject != null) ? subject.getProPreTot() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
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
				<label class="text-secondary">Pago</label><br> <input
					class="form-control" type="text" name="pago" id="pago"
					value="<%=(subject != null) ? subject.getSalConPag() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">IGV</label><br> <input
					class="form-control" type="text" name="igv" id="igv"
					value="<%=(subject != null) ? subject.getSalIgv() : ""%>"
					<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
			</div>
			<div class="form-group">
				<label class="text-secondary">Importe total</label><br> <input
					class="form-control" type="text" name="importe" id="importe"
					value="<%=(subject != null) ? subject.getSalImpTot() : ""%>"
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
			<a href="Servlet11?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>