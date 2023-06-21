
<%@page import="clases.Clientes"%>
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
 Clientes subject  = (Clientes) request.getAttribute("subject");
%>
<form action="SubjectServlet" method="post">
	<input type="hidden" name="type" id="type" value="edit">
	
	<input type="hidden" name="code" id="code" value="<%=(subject!=null)?subject.getCliCod():""%>">
	
	<div class="form-group">
		<label class="text-secondary">Nombre</label>
		<input class="form-control" type="text" name="name" id="name" value="<%=(subject!=null)? subject.getCliNom():"" %>">
	</div>
	<div class="form-group">
		<label class="text-secondary">RUC</label>
		<input class="form-control" type="text" name="ruc" id="ruc" value="<%=(subject!=null)? subject.getCliRuc():"" %>">
	</div>
	<div class="form-group">
		<label class="text-secondary">Dirección</label>
		<input class="form-control" type="text" name="direc" id="direc" value="<%=(subject!=null)? subject.getCliDir():"" %>">
	</div>
	<br>
	<div class="btn-group" role="group" aria-label="Basic Example">
	<button type="submit" class="btn btn-primary">Guardar datos</button>
	</div>
</form>
</body>
</html>