
<%@page import="clases.Productos"%>
<%@page import="clases.Categoria"%>
<%@page import="clases.Unidad_Medida"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/categoria.css"/> 
</head>
<body>
<%
 Productos subject  = (Productos) request.getAttribute("subject");
%>
<form action="Servlet2" method="post">
	<input type="hidden" name="type" id="type" value="edit">
	
	<input type="hidden" name="code" id="code" value="<%=(subject!=null)?subject.getProCod() :""%>">
	
	<div class="form-group">
		<label class="text-secondary">Nombre</label>
		<input class="form-control" type="text" name="name" id="name" value="<%=(subject!=null)? subject.getProNom():"" %>">
	</div>
	 <label for="name">Unidad de medida del producto</label><br>    
	 <select id="coduni" name="coduni">
	 <%	
			List<Unidad_Medida> listSubject = (List<Unidad_Medida>) request.getAttribute("data3");
			if(listSubject != null){
				for(Unidad_Medida item: listSubject){
	  %>
	  <option value="<%= item.getUniMedCod() %>"<%=(subject != null && subject.getUniMedCod() == item.getUniMedCod()) ? "selected" : "" %>> <%= item.getUniMedNom()%> </option>
	  <%
				}
			}
	  %>
	 </select><br><br>
	 <label for="name">Stock del producto</label><br>    
	 <input type="text" name="stock" id="stock" value="<%=(subject!=null)? subject.getProSto():"" %>"/><br><br>
	 <label for="name">Precio de venta del producto</label><br>    
	 <input type="text" name="preciov" id="preciov" value="<%=(subject!=null)? subject.getProPreVen():"" %>"/><br><br>
	 <label for="name">Precio de compra del producto</label><br>    
	 <input type="text" name="precioc" id="precioc" value="<%=(subject!=null)? subject.getProPreCom():"" %>"/><br><br>
	 <label for="estado">Estado</label><br>     
	 <select id="estado" name="estado">
         <option value="A" >Activo</option>
         <option value="I">Inactivo</option>
         <option value="N">Desconocido</option>
     </select><br><br>
     <label for="name">Categoria del producto</label><br>    
	 <select id="codcat" name="codcat">
	 <%	
			List<Categoria> listSubject2 = (List<Categoria>) request.getAttribute("data2");
			if(listSubject != null){
				for(Categoria item: listSubject2){
	  %>
	  <option value="<%= item.getCatProCod() %>"<%=(subject != null && subject.getProCat() == item.getCatProCod()) ? "selected" : "" %>> <%= item.getNombre()%> </option>
	  <%
				}
			}
	  %>
	  </select>
	<div class="btn-group" role="group" aria-label="Basic Example">
	<button type="submit" class="btn btn-primary">Guardar datos</button>
	</div>
</form>
</body>
</html>