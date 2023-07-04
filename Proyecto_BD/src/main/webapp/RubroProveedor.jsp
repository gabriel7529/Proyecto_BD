<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubro Proveedor</title>
<link rel="stylesheet" href="css/estilos.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css "
	rel="stylesheet"
	integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h2>Adiccionar Rubro Proveedor</h2>
		<form action="Servlet5" method="post">
			<label for="Code">Código del Rubro Proveedor</label><br> <input
				type="text" name="code" id="code" placeholder="Código" /><br>
			<br> <label for="name">Nombre del Rubro Proveedor</label><br>
			<input type="text" name="name" id="name" placeholder="Nombre" /><br>
			<br> <label for="estado">Estado del Rubro Proveedor</label><br>
			<input type="text" name="estado" id="estado" value="A" readonly
				onmousedown="return false;" /><br> <br> <input
				type="hidden" name="type" id="type" value="register"> <br>
			<br>
			<button type="submit" class="btn btn-primary">Actualizar</button>
		</form>
	</div>
	<a href="Servlet5?type=list">
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