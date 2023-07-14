
<%@page import="clases.Productos_Entradas_Detalle"%>
<%@page import="clases.Productos"%>
<%@page import="clases.Productos_Entradas_Cabecera"%>
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
	Productos_Entradas_Detalle subject = (Productos_Entradas_Detalle) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet10" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Entradas Producto Detalle</h1>
				<label class="text-secondary">Código</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getEntCabCod() : ""%>"
					readonly onmousedown="return false;">
			</div>


			<br> <label class="text-secondary" for="name">Nombre de
				Productos </label><br> <select id="pro" name="pro"
				<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
				<%
				List<Productos> listSubject2 = (List<Productos>) request.getAttribute("data2");
				if (listSubject2 != null) {
					for (Productos item : listSubject2) {
				%>
				<option value="<%=item.getProCod()%>"
					<%=(subject != null && subject.getProCod() == item.getProCod()) ? "selected" : ""%>>
					<%=(item.getProEstReg().equals("*")) ? "Eliminado" : item.getProNom() %>
				</option>
				<%
				}
				}
				%>
			</select><br><br>
			<label class="text-secondary" for="name">Código de la cabecera</label><br>
			<select id="cabCod" name="cabCod"
				<%=(type.equals("info") && !rsp.equals("I") && !rsp.equals("*")) ? "" : "readonly"%>>
				<%
				List<Productos_Entradas_Cabecera> listSubject = (List<Productos_Entradas_Cabecera>) request.getAttribute("data3");
				if (listSubject != null) {
					for (Productos_Entradas_Cabecera item : listSubject) {
				%>
				<option value="<%=item.getEstNum()%>"
					<%=(subject != null && subject.getEntCabCod() == item.getEntCabCod()) ? "selected" : ""%>>
					<%=(item.getEntcabestReg().equals("*")) ? "Eliminado" : item.getEntCabCod()%>
				</option>
				<%
				}
				}
				%>
			</select><br> <br>
			<div class="form-group">
				<label class="text-secondary">Cantidad</label><br> <input
					class="form-control" type="text" name="cantidad" id="cantidad"
					value="<%=(subject != null) ? subject.getProCan() : ""%>"
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
			<a href="Servlet10?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>