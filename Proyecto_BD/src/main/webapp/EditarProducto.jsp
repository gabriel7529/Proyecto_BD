<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="clases.Productos"%>
<%@page import="clases.Categoria"%>
<%@page import="clases.Unidad_Medida"%>
<%@ page import="java.util.*"%>

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
	Productos subject = (Productos) request.getAttribute("subject");
	%>
	<div class="container">
		<form action="Servlet2" method="post">
			<input type="hidden" name="type" id="type" value="edit">
			<div class="form-group">
				<h1>Editar Producto</h1>
				<label class="text-secondary">Código</label><br> <input
					class="form-control" type="text" name="code" id="code"
					value="<%=(subject != null) ? subject.getProCod() : ""%>" readonly
					onmousedown="return false;">
			</div>

			<div class="form-group">
				<label class="text-secondary">Nombre</label><br><input
					class="form-control" type="text" name="name" id="name"
					value="<%=(subject != null) ? subject.getProNom() : ""%>"
					<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%> >
			</div>
			<label class="text-secondary" for="name">Unidad de medida del
				producto</label><br> <select id="coduni" name="coduni"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
				<%
				List<Unidad_Medida> listSubject = (List<Unidad_Medida>) request.getAttribute("data3");
				if (listSubject != null) {
					for (Unidad_Medida item : listSubject) {
				%>
				<option value="<%=item.getUniMedCod()%>"
					<%=(subject != null && subject.getUniMedCod() == item.getUniMedCod()) ? "selected" : ""%>>
					<%=(item.getUniMedEst().equals("*"))? "Eliminado": item.getUniMedNom() %>
				</option>
				<%
				}
				}
				%>
			</select><br> <br> <label class="text-secondary" for="name">Stock
				del producto</label><br> <input class="form-control" type="text"
				name="stock" id="stock"
				value="<%=(subject != null) ? subject.getProSto() : ""%>"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>><br>
			<br> <label class="text-secondary" for="name">Precio de
				venta del producto</label><br> <input class="form-control" type="text"
				name="preciov" id="preciov"
				value="<%=(subject != null) ? subject.getProPreVen() : ""%>"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>><br>
			<br> <label class="text-secondary" for="name">Precio de
				compra del producto</label><br> <input class="form-control" type="text"
				name="precioc" id="precioc"
				value="<%=(subject != null) ? subject.getProPreCom() : ""%>"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>><br>
			<br> <label class="text-secondary" for="estado">Estado</label><br>
			<input class="form-control" type="text" name="estado" id="estado"
				value="<%=texto%>" readonly onmousedown="return false;" /><br>
			<br> <label class="text-secondary" for="name">Categoria
				del producto</label><br> <select id="codcat" name="codcat"
				<%=(type.equals("info") && !texto.equals("I") && !texto.equals("*")) ? "" : "readonly"%>>
				<%
				List<Categoria> listSubject2 = (List<Categoria>) request.getAttribute("data2");
				if (listSubject != null) {
					for (Categoria item : listSubject2) {
				%>
				<option value="<%=item.getCatProCod()%>"
					<%=(subject != null && subject.getProCat() == item.getCatProCod()) ? "selected" : ""%>>
					<%=item.getNombre()%>
				</option>
				<%
				}
				}
				%>
			</select>
			<button type="submit" class="btn-primary">Actualizar</button>
		</form>
		<div class="button-container">
			<a href="Servlet2?type=list">
				<button>Cancelar</button>
			</a> <a href="http://localhost:8080/Proyecto_BD/index.jsp">
				<button>Salir</button>
			</a>
		</div>
	</div>
</body>
</html>