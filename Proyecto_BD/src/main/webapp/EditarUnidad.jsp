
<%@page import="clases.Unidad_Medida"%>
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
 Unidad_Medida subject  = (Unidad_Medida) request.getAttribute("subject");
%>
<form action="Servlet4" method="post">
	<input type="hidden" name="type" id="type" value="edit">
	
	<input type="hidden" name="code" id="code" value="<%=(subject!=null)?subject.getUniMedCod() :""%>">
	
	<div class="form-group">
		<label class="text-secondary">Nombre</label>
		<input class="form-control" type="text" name="name" id="name" value="<%=(subject!=null)? subject.getUniMedNom():"" %>">
	</div>
	<br>
	<div class="btn-group" role="group" aria-label="Basic Example">
	<button type="submit" class="btn btn-primary">Guardar datos</button>
	</div>
</form>
</body>
</html>