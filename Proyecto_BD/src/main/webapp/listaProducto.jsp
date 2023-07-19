<%@ page import="java.util.*"%>
<%@ page import="clases.Productos"%>
<%@page import="clases.Categoria"%>
<%@page import="clases.Unidad_Medida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/unidadLista.css" />
<title>Lista de productos</title>

</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-6 col-sm-4'>
				<div class='col-6 col-sm-4'>
					<h3>Lista de productos</h3>
					<a href="Servlet2?type=inicio">
						<button class="btn btn-blue">Adiccionar</button>
					</a>
					<table class='table'>
						<thead>
							<tr>
								<th>Código</th>
								<th>Nombre</th>
								<th>Unidad de medida</th>
								<th>Stock</th>
								<th>Precio venta</th>
								<th>Precio compra</th>
								<th>Estado</th>
								<th>Categoria</th>
								<th class="actions hidden">Opciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Productos> listSubject = (List<Productos>) request.getAttribute("data");
							List<Categoria> listSubject2 = (List<Categoria>) request.getAttribute("data2");
							List<Unidad_Medida> listSubject3 = (List<Unidad_Medida>) request.getAttribute("data3");
							String categoria = "";
							if (listSubject != null) {
								for (Productos item : listSubject) {
									categoria = "";
									for(Unidad_Medida item2 : listSubject3) {
										if(item2.getUniMedCod() == item.getUniMedCod()) {
											if(item2.getUniMedEst().equals("*")){
												categoria =  item2.getUniMedNom() + " *";
												break;
											}
											categoria = item2.getUniMedNom();
											break;
										}
									}
							%>
							<tr onclick="selectRow(this);">
								<td><%=item.getProCod()%></td>
								<td><%=item.getProNom()%></td>
								<td><%=categoria%></td>
								<td><%=item.getProSto()%></td>
								<td><%=item.getProPreVen()%></td>
								<td><%=item.getProPreCom()%></td>
								<td><%=item.getProEstReg()%></td>
								<td><%for (Categoria item3 : listSubject2) {
										if (item3.getCatProCod() == item.getProCat()) {
											if(item3.getEstado().equals("*")){
												out.print(item3.getNombre() + "*");
												break;
											}
											out.print(item3.getNombre());
											break;
										}
									}%>
								<td class="actions hidden"><a
									href="Servlet2?type=info&id=<%=item.getProCod()%>">
										<button class="btn btn-green">Modificar</button>
								</a> <a href="Servlet2?type=delete&id=<%=item.getProCod()%>">
										<button class="btn btn-red">Eliminar</button>
								</a> <a href="Servlet2?type=inac&id=<%=item.getProCod()%>">
										<button class="btn btn-yellow">Inactivar</button>
								</a> <a href="Servlet2?type=reac&id=<%=item.getProCod()%>">
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
	<a href="Servlet2?type=list">
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