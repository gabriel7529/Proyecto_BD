<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validación</title>
<link rel="stylesheet" href="css/estilos.css"/> 
<link 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css " rel="stylesheet" integrity="sha3841BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
	 <h2>Registrar Cursos</h2>   
	 <form action="SubjectServlet" method="post">      
	 <label for="Code">Código del clientes</label><br>
	 <input type="text" name="code" id="code" placeholder="Código"/><br><br>      
	 <label for="name">Nombre del cliente</label><br>    
	 <input type="text" name="name" id="name" placeholder="Nombre"/><br><br>      
	 <label for="RUC">RUC del Cliente</label><br>     
	 <input type="text" name="RUC" id="RUC" placeholder="RUC"/><br><br>      
	 <label for="text">Dirección Cliente</label><br>     
	 <input type="text" name="direc" id="direc" placeholder="Dirección"/><br><br>     
	
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