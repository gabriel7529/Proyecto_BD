<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="clases.Proveedores"%>
<%@ page import="clases.Estantes"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos_Entradas_Cabecera</title>
<link rel="stylesheet" href="css/estilos.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css "
	rel="stylesheet"
	integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Registrar Productos_Entradas_Cabecera</h2>
		<form action="Servlet9" method="post">
			<label for="Code">Código del producto</label><br> <input
				type="text" name="code" id="code" placeholder="Código" /><br>
			<br> <label for="name">Nombre del proveedor</label><br> <select
				id="prov" name="prov">
				<%
				List<Proveedores> listSubject = (List<Proveedores>) request.getAttribute("data");
				if (listSubject != null) {
					for (Proveedores item : listSubject) {
				%>
				<option value=<%=item.getPrvCod()%>>
					<%=item.getPrvNom()%>
				</option>
				<%
				}
				}
				%>
			</select> <label for="name">Estante del producto</label><br> <select
				id="est" name="est">
				<%
				List<Estantes> listSubject2 = (List<Estantes>) request.getAttribute("data2");
				if (listSubject != null) {
					for (Estantes item : listSubject2) {
				%>
				<option value=<%=item.getEstNum()%>>
					<%=item.getEstCap()%>
				</option>
				<%
				}
				}
				%>
			</select> <label for="name">Año</label><br> <input type="text" name="ano"
				id="ano" placeholder="Año" /><br>
			<br> <label for="name">Mes</label><br> <input type="text"
				name="mes" id="mes" placeholder="Mes" /><br>
			<br> <label for="name">Día</label><br> <input type="text"
				name="dia" id="dia" placeholder="Día" /><br>
			<br> <label for="estado">Estado</label><br> <input
				type="text" name="estado" id="estado" value="A" readonly
				onmousedown="return false;" /><br> <input type="hidden"
				name="type" id="type" value="register"> <br>
			<br>
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>
	</div>
	<a href="Servlet9?type=list">
		<button class="btn btn-blue">Cancelar</button>
	</a>
	<a href="http://localhost:8080/Proyecto_BD/index.jsp">
		<button class="btn btn-blue">Salir</button>
	</a>

</body>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
</html>