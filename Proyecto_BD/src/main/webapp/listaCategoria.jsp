<%@ page import="java.util.*"%>
<%@ page import="clases.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Categorias</title>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Categorias</h3>
					<a href="http://localhost:8080/Proyecto_BD/Categoria.jsp">
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
							List<Categoria> listSubject = (List<Categoria>) request.getAttribute("data");
							if (listSubject != null) {
								for (Categoria item : listSubject) {
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getCatProCod()%></td>
								<td><%=item.getNombre()%></td>
								<td><%=item.getEstado()%></td>
								<td class="actions hidden"><a
									href="Servlet3?type=info&id=<%=item.getCatProCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet3?type=delete&id=<%=item.getCatProCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet3?type=inac&id=<%=item.getCatProCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet3?type=reac&id=<%=item.getCatProCod()%>">
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
	<a href="Servlet3?type=list">
		<button
			class="btn btn-blue">
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