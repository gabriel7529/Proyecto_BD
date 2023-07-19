<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="clases.RubroProveedor"%>

<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="css/estilos.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css "
	rel="stylesheet"
	integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Registrar Proveedores</h2>
		<form action="Servlet8" method="post">
			<label for="Code">Código del Proveedor</label><br> <input
				type="text" name="code" id="code" placeholder="Código" /><br>
			<br> <label for="Code">Nombre del Proveedor</label><br> <input
				type="text" name="name" id="name" placeholder="Nombre" /><br>
			<br> <label for="Code">Teléfono del Proveedor</label><br> <input
				type="text" name="phone" id="phone" placeholder="Teléfono" /><br>
			<br> <label for="Code">Dirección del Proveedor</label><br>
			<input type="text" name="dir" id="dir" placeholder="Dirección" /><br>
			<br> <label for="Code">Rubro del proveedor</label><br> <select
				id="rub" name="rub">
				<%
				List<RubroProveedor> listSubject = (List<RubroProveedor>) request.getAttribute("data");
				if (listSubject != null) {
					for (RubroProveedor item : listSubject) {
						if(!item.getRubEstReg().equals("*")){
				%>
				<option value=<%=item.getRubProCod()%>>
					<%=item.getRubNom()%>
				</option>
				<%
						}
				}
				}
				%>
			</select> <br> <label for="estado">Estado</label><br> <input
				type="text" name="estado" id="estado" value="A" readonly
				onmousedown="return false;" /><br> <input type="hidden"
				name="type" id="type" value="register"> <br> <br>
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>
	</div>
	<a href="Servlet8?type=list">
		<button
			style="background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;">
			Cancelar</button>
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