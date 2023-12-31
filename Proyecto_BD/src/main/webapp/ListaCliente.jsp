<%@ page import="java.util.*"%>
<%@ page import="clases.Clientes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de los clientes</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de los clientes</h3>
					<a href="http://localhost:8080/Proyecto_BD/Cliente.jsp">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>C�digo</th>
								<th>Nombre</th>
								<th>RUC</th>
								<th>Direcci�n</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Clientes> listSubject = (List<Clientes>) request.getAttribute("data");
							if (listSubject != null) {
								for (Clientes item : listSubject) {
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getCliCod()%></td>
								<td><%=item.getCliNom()%></td>
								<td><%=item.getCliRuc()%></td>
								<td><%=item.getCliDir()%></td>
								<td><%=item.getCliEst()%></td>
								<td class="actions hidden"><a
									href="SubjectServlet?type=info&id=<%=item.getCliCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="SubjectServlet?type=delete&id=<%=item.getCliCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="SubjectServlet?type=inac&id=<%=item.getCliCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="SubjectServlet?type=reac&id=<%=item.getCliCod()%>">
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
	<a href="SubjectServlet?type=list">
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