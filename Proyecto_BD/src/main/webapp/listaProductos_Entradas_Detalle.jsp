<%@ page import="java.util.*"%>
<%@ page import="clases.Productos_Entradas_Detalle"%>
<%@page import="clases.Productos"%>
<%@page import="clases.Productos_Entradas_Cabecera"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de Productos_Entradas_Detalle</title>
</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de Productos_Entradas_Detalle</h3>
					<a href="Servlet10?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre del producto</th>
								<th>Código de la cabecera</th>
								<th>Cantidad</th>
								<th>Estado</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Productos_Entradas_Detalle> listSubject = (List<Productos_Entradas_Detalle>) request.getAttribute("data");
							List<Productos> listSubject2 = (List<Productos>) request.getAttribute("data2");
							List<Productos_Entradas_Cabecera> listSubject3 = (List<Productos_Entradas_Cabecera>) request.getAttribute("data3");
							String Productos = "";
							if (listSubject != null) {
								for (Productos_Entradas_Detalle item : listSubject) {
									Productos = "";
									for(Productos_Entradas_Cabecera item2 : listSubject3) {
										if(item2.getEntCabCod() == item.getEntCabCod()) {
											if(item2.getEntcabestReg().equals("*")){
												Productos =  String.valueOf(item2.getEntCabCod()) + " *";
												break;
											}
											Productos = String.valueOf(item2.getEntCabCod());
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getEntDetCod()%></td>
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
								<td><%=Productos%></td>
								<td><%=item.getProCan()%></td>
								<td><%=item.getEntDetEstReg()%></td>
								<td class="actions hidden"><a
									href="Servlet10?type=info&id=<%=item.getEntDetCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet10?type=delete&id=<%=item.getEntDetCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet10?type=inac&id=<%=item.getEntDetCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet10?type=reac&id=<%=item.getEntDetCod()%>">
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
	<a href="Servlet10?type=list">
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