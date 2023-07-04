<%@ page import="java.util.*"%>
<%@ page import="clases.RubroProveedor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Rubros de proveedores</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Rubros de proveedores</h3>
					<a href="http://localhost:8080/Proyecto_BD/RubroProveedor.jsp">
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
							List<RubroProveedor> listSubject = (List<RubroProveedor>) request.getAttribute("data");
							if (listSubject != null) {
								for (RubroProveedor item : listSubject) {
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getRubProCod()%></td>
								<td><%=item.getRubNom()%></td>
								<td><%=item.getRubEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet5?type=info&id=<%=item.getRubProCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet5?type=delete&id=<%=item.getRubProCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet5?type=inac&id=<%=item.getRubProCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet5?type=reac&id=<%=item.getRubProCod()%>">
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
	<a href="Servlet5?type=list">
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