<%@ page import="java.util.*"%>
<%@ page import="clases.Productos_Salidas_Detalle"%>
<%@page import="clases.Productos"%>
<%@page import="clases.Productos_Salidas_Cabecera"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Productos Salidas Detalle</title>
</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Productos Salidas Detalle</h3>
					<a href="Servlet12?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre del producto</th>
								<th>Cantidad</th>
								<th>Precio Total</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Productos_Salidas_Detalle> listSubject = (List<Productos_Salidas_Detalle>) request.getAttribute("data");
							List<Productos> listSubject2 = (List<Productos>) request.getAttribute("data2");
							List<Productos_Salidas_Cabecera> listSubject3 = (List<Productos_Salidas_Cabecera>) request.getAttribute("data3");
							String Productos = "";
							if (listSubject != null) {
								for (Productos_Salidas_Detalle item : listSubject) {
									Productos = "";
									for(Productos_Salidas_Cabecera item2 : listSubject3) {
										if(item2.getSalCod() == item.getSalCod()) {
											if(item2.getEntcabestReg().equals("*")){
												Productos = String.valueOf(item2.getSalCod()) + " *";
												break;
											}
											Productos = String.valueOf(item2.getSalCod());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=Productos%></td>
								<td><%for (Productos item3 : listSubject2) {
										if (item3.getProCod() == item.getProCod()) {
											if(item3.getProEstReg().equals("*")){
												out.print(item3.getProNom() + " *");
												break;
											}
											out.print(item3.getProNom());
											break;
										}
									}%></td>
								<td><%=item.getProCan()%></td>
								<td><%=item.getSalDetPreTot()%></td>
								<td><%=item.getEntDetEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet12?type=info&id=<%=item.getSalCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet12?type=delete&id=<%=item.getSalCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet12?type=inac&id=<%=item.getSalCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet12?type=reac&id=<%=item.getSalCod()%>">
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
	<a href="Servlet12?type=list">
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