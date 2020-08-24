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

</head>
<body>

<jsp:include page="../nav.jsp"></jsp:include>
<div class="container">
	
	<br>
	<br>
	<h1>Factura</h1>
	<br>
	<div  id="dacfactura">
	
	
	</div>
	<br>
	<div id="detalle">
	
	</div>
</div>
<div class="row">
	<a href="index.jsp" class="btn btn-primary btn-lg active" onclick="Regresar()" role="button" aria-pressed="true">Fin</a>
</div>
<script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../js/item.js"></script>
<script src="../js/detalle.js"></script>

<script>
$(document).ready(function(){
	getFactura();
	getDetalle();
});
</script>

</body>
</html>