
<%@page import="clases.Categoria"%>
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
 Categoria subject  = (Categoria) request.getAttribute("subject");
%>
<form action="Servlet3" method="post">
	<input type="hidden" name="type" id="type" value="edit">
	
	<input type="hidden" name="code" id="code" value="<%=(subject!=null)?subject.getCatProCod() :""%>">
	
	<div class="form-group">
		<label class="text-secondary">Nombre</label>
		<input class="form-control" type="text" name="name" id="name" value="<%=(subject!=null)? subject.getNombre():"" %>">
	</div>
	<div class="form-group">
		<label class="text-secondary">Estado</label>
		<input class="form-control" type="text" name="estado" id="estado" value="<%=(subject!=null)? subject.getEstado():"" %>">
	</div>
	
	<br>
	<div class="btn-group" role="group" aria-label="Basic Example">
	<button type="submit" class="btn btn-primary">Guardar datos</button>
	</div>
</form>
</body>
</html>