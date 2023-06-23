<%@ page import="java.util.*" %>
<%@ page import="clases.Categoria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de categorias</title>
<style>
.container {
  margin-top: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

table th, table td {
  padding: 10px;
  text-align: left;
}

table th {
  background-color: #f2f2f2;
}

table td.actions {
  width: 100px;
}

.actions img {
  margin-right: 10px;
}

.actions img:hover {
  cursor: pointer;
}
</style>
</head>
<body>

<div class='container'>
	<div class = 'row'>
		<div class='col-6 col-sm-4'>
		<div class ='col-6 col-sm-4'>
		<h3>Lista de categorias</h3>
		<a href="http://localhost:8080/Proyecto_BD/Categoria.jsp"> 
    <button style="background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;">
        Agregar
    </button>
    </a>
		<table class='table'>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Estado</th>
					
				</tr>
			</thead>
			<tbody>
			<%
			
			List<Categoria> listSubject = (List<Categoria>) request.getAttribute("data");
			if(listSubject != null){
				for(Categoria item: listSubject){
		    %>
		    <tr>
		    	<td><%= item.getCatProCod() %></td>
		    	<td><%= item.getNombre() %></td>
		    	<td><%= item.getEstado() %></td>
		    	
		    	<td>
		    	<a href="Servlet3?type=info&id=<%=item.getCatProCod()%>">
    <button style="background-color: #4CAF50; color: white; padding: 5px 10px; border: none; cursor: pointer;">
        Editar
    </button>
</a>
<a href="Servlet3?type=delete&id=<%=item.getCatProCod()%>">
    <button style="background-color: #f44336; color: white; padding: 5px 10px; border: none; cursor: pointer;">
        Eliminar
    </button>
</a>
		    	</td>
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
<a href="http://localhost:8080/Proyecto_BD/index.jsp">
    <button style="background-color: blue; color: white; padding: 5px 10px; border: none; cursor: pointer;">
        Menú Principal
    </button>
</a>

</body>
</html>