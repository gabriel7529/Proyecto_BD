<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="clases.Productos"%>
<%@ page import="clases.Productos_Entradas_Cabecera"%>
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
		<h2>Registrar Productos_Entradas_Detalle</h2>
		<form action="Servlet10" method="post">
			<label for="Code">Código de la entrada Detalle</label><br> <input
				type="text" name="code" id="code" placeholder="Código" /><br>
			<br> <label for="name">Nombre del producto</label><br> <select
				id="pro" name="pro">
				<%
				List<Productos> listSubject = (List<Productos>) request.getAttribute("data");
				if (listSubject != null) {
					for (Productos item : listSubject) {
				%>
				<option value=<%=item.getProCod()%>>
					<%=item.getProNom()%>
				</option>
				<%
				}
				}
				%>
			</select> <label for="name">Código de la cabecera</label><br> <select
				id="cabCod" name="cabCod">
				<%
				List<Productos_Entradas_Cabecera> listSubject2 = (List<Productos_Entradas_Cabecera>) request.getAttribute("data2");
				if (listSubject != null) {
					for (Productos_Entradas_Cabecera item : listSubject2) {
				%>
				<option value=<%=item.getEntCabCod()%>>
					<%=item.getEntCabCod()%> | <%=item.getEntcabfecAno() %>
				</option>
				<%
				}
				}
				%>
			</select> <label for="name">Cantidad del Producto</label><br> <input type="text" name="cantidad"
				id="cantidad" placeholder="Cantidad" /><br>
			<br> <label for="estado">Estado</label><br> <input
				type="text" name="estado" id="estado" value="A" readonly
				onmousedown="return false;" /><br> <input type="hidden"
				name="type" id="type" value="register"> <br>
			<br>
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>
	</div>
	<a href="Servlet10?type=list">
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