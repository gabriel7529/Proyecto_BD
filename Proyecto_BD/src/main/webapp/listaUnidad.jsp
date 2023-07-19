<%@ page import="java.util.*"%>
<%@ page import="clases.Unidad_Medida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Unidades de medida</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Unidades de medida</h3>
					<a href="http://localhost:8080/Proyecto_BD/Unidad.jsp">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Unidad_Medida> listSubject = (List<Unidad_Medida>) request.getAttribute("data");
							if (listSubject != null) {
								for (Unidad_Medida item : listSubject) {
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getUniMedCod()%></td>
								<td><%=item.getUniMedNom()%></td>
								<td><%=item.getUniMedEst()%></td>
								<td class="actions hidden"><a
									href="Servlet4?type=info&id=<%=item.getUniMedCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet4?type=delete&id=<%=item.getUniMedCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet4?type=inac&id=<%=item.getUniMedCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet4?type=reac&id=<%=item.getUniMedCod()%>">
										<button class="btn btn-purple">Reactivar</button>
								</a></td>
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="Servlet4?type=list">
		<button
			style="background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;">
			Cancelar</button>
	</a>
	<a href="http://localhost:8080/Proyecto_BD/index.jsp">
		<button class="btn btn-blue">Salir</button>
	</a>
	<script>
		function selectRow(row) {

			var table = row.parentNode.parentNode;
			var rows = table.getElementsByTagName('tr');

			for (var i = 0; i < rows.length; i++) {
				rows[i].classList.remove('selected');
				rows[i].querySelector('.actions').classList.add('hidden');
			}
			row.classList.add('selected');
			row.querySelector('.actions').classList.remove('hidden');
		}
	</script>
</html>