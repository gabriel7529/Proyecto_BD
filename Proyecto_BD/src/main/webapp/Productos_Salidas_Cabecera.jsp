<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="clases.Clientes"%>

<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos_Salidas_Cabecera</title>
<link rel="stylesheet" href="css/estilos.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css "
	rel="stylesheet"
	integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Registrar Productos_Salidas_Cabecera</h2>
		<form action="Servlet11" method="post">
			<label for="Code">Código de la salida</label><br> <input
				type="text" name="code" id="code" placeholder="Código" /><br>
			<br> <label for="name">Nombre del Cliente</label><br> <select
				id="cli" name="cli">
				<%
				List<Clientes> listSubject = (List<Clientes>) request.getAttribute("data");
				if (listSubject != null) {
					for (Clientes item : listSubject) {
				%>
				<option value=<%=item.getCliCod()%>>
					<%=item.getCliNom()%>
				</option>
				<%
				}
				}
				%>
			</select> <br> <label for="name">Precio Total</label><br> <input
				type="text" name="total" id="total" placeholder="Precio Total" /><br>

			<label for="name">Año</label><br> <input type="text" name="ano"
				id="ano" placeholder="Año" /><br> <br> <label for="name">Mes</label><br>
			<input type="text" name="mes" id="mes" placeholder="Mes" /><br>
			<br> <label for="name">Día</label><br> <input type="text"
				name="dia" id="dia" placeholder="Día" /><br> <br>
			<label for="name">Pago</label><br> <input type="text"
				name="pago" id="pago" placeholder="Pago" /><br> <br> <label
				for="name">IGV</label><br> <input type="text" name="igv"
				id="igv" placeholder="IGV" />
				<br>
			<label for="name">Importe Total</label><br> <input type="text"
				name="importe" id="importe" placeholder="Importe" />
				<br> 
				<label for="estado">Estado</label><br>
			<input type="text" name="estado" id="estado" value="A" readonly
				onmousedown="return false;" /><br> <input type="hidden"
				name="type" id="type" value="register"> <br> <br>
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