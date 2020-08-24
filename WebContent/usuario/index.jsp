<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>tienda</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/shop-homepage.css" rel="stylesheet">
<title>Insert title here</title>
</head>


<body>

<jsp:include page="../nav.jsp"></jsp:include>
<div>

</div>

<br>
<br>
<div class="container">
		<div class="row justify-content-md-center">
			<div class="col">
				<label >cedula</label>
			</div>
			<div class="col">
				<input type="number" class="form-control" id="cedula">
    
			</div>
			<div class="col">
				<button type="button" class="btn btn-primary" onclick="buscarDocumento()">BUSCAR</button>    
			</div>
			<div class="col">
				<label >nombre</label>   
			</div>
			<div class="col">
				<input type="text" class="form-control" disabled="disabled" id="nombre">
    
			</div>
			<div class="col">
				<label >apellido</label>   
			</div>
			<div class="col-">
				<input type="text" class="form-control" disabled="disabled" id="apellido">    
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col">
				<label >Producto</label>   
			</div>
			<div class="col">
				<input type="number" class="form-control"  id="producto">    
			</div>
			
			<div class="col">
				<label >cantidad</label>   
			</div>
			<div class="col">
				<input type="number" class="form-control"  id="cantidad">    
			</div>
			
			<div class="col">
				<a href="javascript:getItem();" id="btn" class="btn btn-primary" role="button">AÑADIR PRODUCTO </a>   

			</div>
		</div>
		<br>
		<div class="row">
		
		<table class="table table-striped table-hover table-bordered table-sm bg-white">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Prducto</th>
		      <th scope="col">Precio</th>
		      <th scope="col">Cantidad</th>
		      <th scope="col">valor</th>
		      
		    </tr>
		  </thead>
		  <tbody id="datos">
		  
		    
		  </tbody>
		</table>
		
		</div>
		<div class="row">
			<div class="col">
				<label >IVA</label>				    
			</div>
			<div class="col">
				<label >19 %</label>    
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label >total</label>				    
			</div>
			<div class="col" id= "valortotal">
				<label >0.0</label>    
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="index.jsp" class="btn btn-primary btn-lg active" onclick="getCancelarPro()" role="button" aria-pressed="true">CANCELAR COMPRA</a>    
			</div>
			<div class="col">
				<a href="factura.jsp" class="btn btn-primary btn-lg active" onclick="getAceptar()" role="button" aria-pressed="true">ACEPTAR</a> 
			</div>
		</div>
	</div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/buscarDocumento.js"></script>
<script src="../js/item.js"></script>
<script src="../js/item2.js"></script>
 <script>
	  	$(document).ready(function(){
			getItems();
		});
  </script>
</body>
</html>