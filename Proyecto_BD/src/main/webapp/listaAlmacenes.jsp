<%@ page import="java.util.*"%>
<%@ page import="clases.Almacenes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Almacenes</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Almacenes</h3>
					<a href="http://localhost:8080/Proyecto_BD/Almacenes.jsp">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Número</th>
								<th>Dirección</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Almacenes> listSubject = (List<Almacenes>) request.getAttribute("data");
							if (listSubject != null) {
								for (Almacenes item : listSubject) {
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getAlmNum()%></td>
								<td><%=item.getAlmDir()%></td>
								<td><%=item.getAlmEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet6?type=info&id=<%=item.getAlmNum()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet6?type=delete&id=<%=item.getAlmNum()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet6?type=inac&id=<%=item.getAlmNum()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet6?type=reac&id=<%=item.getAlmNum()%>">
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
	<a href="Servlet6?type=list">
		<button class="btn btn-blue">Cancelar</button>
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