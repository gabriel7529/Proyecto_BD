<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="clases.Unidad_Medida" %>
<%@ page import="clases.Categoria" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link rel="stylesheet" href="css/estilos.css"/> 
<link 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css " rel="stylesheet" integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
	 <h2>Registrar Productos</h2>   
	 <form action="Servlet2" method="post">      
	 <label for="Code">Código del producto</label><br>
	 <input type="text" name="code" id="code" placeholder="Código"/><br><br>      
	 <label for="name">Nombre del producto</label><br>    
	 <input type="text" name="name" id="name" placeholder="Nombre"/><br><br> 
	 <label for="name">Unidad de medida del producto</label><br>    
	 <select id="coduni" name="coduni">
	 <%	
			List<Unidad_Medida> listSubject = (List<Unidad_Medida>) request.getAttribute("data");
			if(listSubject != null){
				for(Unidad_Medida item: listSubject){
	  %>
	  <option value=<%= item.getUniMedCod() %>> <%= item.getUniMedNom()%> </option>
	  <%
				}
			}
	  %>
	 </select>
	 <label for="name">Stock del producto</label><br>    
	 <input type="text" name="stock" id="stock" placeholder="Stock"/><br><br>
	 <label for="name">Precio de venta del producto</label><br>    
	 <input type="text" name="preciov" id="preciov" placeholder="Precio de Venta"/><br><br>
	 <label for="name">Precio de compra del producto</label><br>    
	 <input type="text" name="precioc" id="precioc" placeholder="Precio de Compra"/><br><br>
	 <label for="estado">Estado</label><br>     
	 <select id="estado" name="estado">
            <option value="A">Activo</option>
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
	  <option value=<%= item.getCatProCod() %>> <%= item.getNombre()%> </option>
	  <%
				}
			}
	  %>
	 </select>
	 <input type="hidden" name="type" id="type" value="register">         
     <br><br>
	 <button type="submit" class="btn btn-primary">Enviar datos</button>
</form> 
</div> 

</body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  
<script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
</html>