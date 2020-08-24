<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="well well-sm">
			<br>
			<br>
				<form >
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="validationCustom01">Nombre</label>
							<input type="text"  class="form-control is-invalid" id="nombre" name="nombre" placeholder="Nombre"  required>
						</div>
						<div class="col-md-6 mb-3">
      						<label for="validationCustom02">Apellido</label>
      						<input type="text" class="form-control is-invalid" id="apellido" name="apellido" placeholder="Apellido"  required>
    					</div>
  					</div>
  					
					<div class="form-group">
    					<label for="validationCustom01">Celular</label>
						<input type="tel"  class="form-control is-invalid"  id="celular" name="celular" placeholder="celular"  required>
    				</div>

 					<div class="row">
    					<div class="col-md-6 mb-3">
      						<label for="validationCustom01">tipo de identificion</label>
      						<select class="form-control" id="tipoDocumento">
							      <option>1</option>
							      <option>2</option>
							      <option>3</option>
							      <option>4</option>
							      <option>5</option>
							</select>
    					</div>
    					<div class="col-md-6 mb-3">
      						<label for="validationCustom02">numero de documento</label>
      						<input type="number" name='numeroDocumento' id="numeroDocumento" class="form-control is-invalid" id="T" placeholder="numero" value="" required>
    					</div>
  					</div>
  					<div class ="row">
  						<div class="col-md-6 mb-3">
							<label for="validationCustom01">direccion</label>
							<input type="text"  class="form-control is-invalid" id="dirrecion" name="dirrecion" placeholder="Direcion" value="" required>
						</div>
  					</div>
  					 
  					</br>
         			<center><input type="submit" onClick='send()'; /></center>
          		</form>
          		<div class="row" id="div_review_response">
          		</div>

			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script><!-- Bootstrap core JavaScript -->
<script src="vendor/popper/popper.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="js/Registro.js"></script>


</body>
</html>