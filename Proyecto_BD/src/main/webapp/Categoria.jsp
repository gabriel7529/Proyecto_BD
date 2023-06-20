<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
<link rel="stylesheet" href="css/estilos.css"/> 
<link 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css " rel="stylesheet" integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
	 <h2>Registrar Categorias</h2>   
	 <form action="Servlet3" method="post">      
	 <label for="Code">Código de la categoria</label><br>
	 <input type="text" name="code" id="code" placeholder="Código"/><br><br>      
	 <label for="name">Nombre de la categoria</label><br>    
	 <input type="text" name="name" id="name" placeholder="Nombre"/><br><br>      
	 <label for="RUC">Estado</label><br>     
	 <select id="estado" name="estado">
            <option value="A">Activo</option>
            <option value="I">Inactivo</option>
            <option value="N">Desconocido</option>
            
     </select><br><br>    
        <select id="type" name="type">
            <option value="register">Registrar</option>
            <option value="info">informacion</option>
            <option value="delete">Eliminar</option>
            <option value="edit">Editar</option>
        </select><br><br>
	 <button type="submit" class="btn btn-primary">Enviar datos</button>
	 </form> 
</div> 

</body>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>  

<script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>

</html>