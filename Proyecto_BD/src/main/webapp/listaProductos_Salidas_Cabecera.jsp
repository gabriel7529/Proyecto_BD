<%@ page import="java.util.*"%>
<%@ page import="clases.Productos_Salidas_Cabecera"%>

<%@page import="clases.Clientes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Productos_Salidas_Cabecera</title>
</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Productos_Salidas_Cabecera</h3>
					<a href="Servlet11?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre del Cliente</th>
								<th>Precio Total</th>
								<th>Año</th>
								<th>Mes</th>
								<th>Día</th>
								<th>Pago</th>
								<th>IGV</th>
								<th>Importe Total</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Productos_Salidas_Cabecera> listSubject = (List<Productos_Salidas_Cabecera>) request.getAttribute("data");
							List<Clientes> listSubject3 = (List<Clientes>) request.getAttribute("data2");
							String Proveedores = "";
							if (listSubject != null) {
								for (Productos_Salidas_Cabecera item : listSubject) {
									Proveedores = "";
									for(Clientes item2 : listSubject3) {
										if(item2.getCliCod() == item.getCliCod()) {
											if(item2.getCliEst().equals("*")){
												Proveedores = String.valueOf(item2.getCliNom()) + " *";
												break;
											}
											Proveedores = String.valueOf(item2.getCliNom());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getSalCod()%></td>
								<td><%=Proveedores%></td>
								<td><%=item.getProPreTot()%></td>
								<td><%=item.getEntcabfecAno()%></td>
								<td><%=item.getEntcabfecMes()%></td>
								<td><%=item.getEntcabfecDia()%></td>
								<td><%=item.getSalConPag()%></td>
								<td><%=item.getSalIgv()%></td>
								<td><%=item.getSalImpTot()%></td>
								<td><%=item.getEntcabestReg()%></td>
								<td class="actions hidden"><a
									href="Servlet11?type=info&id=<%=item.getSalCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet11?type=delete&id=<%=item.getSalCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet11?type=inac&id=<%=item.getSalCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet11?type=reac&id=<%=item.getSalCod()%>">
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
	<a href="Servlet11?type=list">
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