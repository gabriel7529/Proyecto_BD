<%@ page import="java.util.*"%>
<%@ page import="clases.Estantes"%>
<%@page import="clases.Almacenes"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de estantes</title>

</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de estantes</h3>
					<a href="Servlet7?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Número</th>
								<th>Código Almacen</th>
								<th>Capacidad</th>
								<th>Estado</th>
								
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Estantes> listSubject = (List<Estantes>) request.getAttribute("data");
							List<Almacenes> listSubject2 = (List<Almacenes>) request.getAttribute("data2");
							String Almacenes = "";
							if (listSubject != null) {
								for (Estantes item : listSubject) {
									Almacenes = "";
									for(Almacenes item2 : listSubject2) {
										if(item2.getAlmNum() == item.getAlmNum()) {
											if(item2.getAlmEstReg().equals("*")){
												Almacenes = String.valueOf(item2.getAlmNum()) + " *";
												break;
											}
											Almacenes = String.valueOf(item2.getAlmNum());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getEstNum()%></td>
								<td><%=Almacenes%></td>
								<td><%=item.getEstCap()%></td>
								<td><%=item.getEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet7?type=info&id=<%=item.getEstNum()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet7?type=delete&id=<%=item.getEstNum()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet7?type=inac&id=<%=item.getEstNum()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet7?type=reac&id=<%=item.getEstNum()%>">
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
	<a href="Servlet7?type=list">
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