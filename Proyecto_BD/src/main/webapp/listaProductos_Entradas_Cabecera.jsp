<%@ page import="java.util.*"%>
<%@ page import="clases.Productos_Entradas_Cabecera"%>
<%@page import="clases.Proveedores"%>
<%@page import="clases.Estantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Productos_Entradas_Cabecera</title>
</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Productos_Entradas_Cabecera</h3>
					<a href="Servlet9?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre de Proveedor</th>
								<th>Capacidad del estante</th>
								<th>Año</th>
								<th>Mes</th>
								<th>Día</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Productos_Entradas_Cabecera> listSubject = (List<Productos_Entradas_Cabecera>) request.getAttribute("data");
							List<Proveedores> listSubject2 = (List<Proveedores>) request.getAttribute("data2");
							List<Estantes> listSubject3 = (List<Estantes>) request.getAttribute("data3");
							String Proveedores = "";
							if (listSubject != null) {
								for (Productos_Entradas_Cabecera item : listSubject) {
									Proveedores = "";
									for(Estantes item2 : listSubject3) {
										if(item2.getEstNum() == item.getEstNum()) {
											if(item2.getEstReg().equals("*")){
												Proveedores = String.valueOf(item2.getEstCap() + " *");
												break;
											}
											Proveedores = String.valueOf(item2.getEstCap());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getEntCabCod()%></td>
								<td><%for (Proveedores item3 : listSubject2) {
										if (item3.getPrvCod() == item.getPrvCod()) {
											if(item3.getPrvEstReg().equals("*")){
												out.print(item3.getPrvNom() + " *");
												break;
											}
											out.print(item3.getPrvNom());
											break;
										}
									}%></td>
								<td><%=Proveedores%></td>
								<td><%=item.getEntcabfecAno()%></td>
								<td><%=item.getEntcabfecMes()%></td>
								<td><%=item.getEntcabfecDia()%></td>
								<td><%=item.getEntcabestReg()%></td>
								<td class="actions hidden"><a
									href="Servlet9?type=info&id=<%=item.getEntCabCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet9?type=delete&id=<%=item.getEntCabCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet9?type=inac&id=<%=item.getEntCabCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet9?type=reac&id=<%=item.getEntCabCod()%>">
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
	<a href="Servlet9?type=list">
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