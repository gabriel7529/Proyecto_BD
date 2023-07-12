<%@ page import="java.util.*"%>
<%@ page import="clases.Proveedores"%>
<%@page import="clases.RubroProveedor"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Proveedores</title>

</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Proveedores</h3>
					<a href="Servlet8?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre</th>
								<th>Teléfono</th>
								<th>Dirección</th>
								<th>Rubro</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Proveedores> listSubject = (List<Proveedores>) request.getAttribute("data");
							List<RubroProveedor> listSubject2 = (List<RubroProveedor>) request.getAttribute("data2");
							String RubroProveedor = "";
							if (listSubject != null) {
								for (Proveedores item : listSubject) {
									RubroProveedor = "";
									for(RubroProveedor item2 : listSubject2) {
										if(item2.getRubProCod() == item.getRubPrv()) {
											if(item2.getRubEstReg().equals("*")){
												RubroProveedor = "Eliminado";
												break;
											}
											RubroProveedor = String.valueOf(item2.getRubNom());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getPrvCod()%></td>
								<td><%=item.getPrvNom() %></td>
								<td><%=item.getPrvTel() %></td>
								<td><%=item.getProDir() %></td>
								<td><%=RubroProveedor%></td>
								<td><%=item.getPrvEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet8?type=info&id=<%=item.getPrvCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet8?type=delete&id=<%=item.getPrvCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet8?type=inac&id=<%=item.getPrvCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet8?type=reac&id=<%=item.getPrvCod()%>">
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
	<a href="Servlet8?type=list">
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