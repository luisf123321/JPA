
<%
	String category_id = request.getParameter("id");
	if (category_id == null){
		category_id = "1";	
	}	
%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>tienda</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">

</head>

<body>

  <jsp:include page="nav.jsp"></jsp:include>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">CATEGORIAS</h1>
        <div class="list-group" id="div_categories">
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

       

        <div class="row" id="div_products">

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="js/index.js"></script>
  <script src="js/index2.js"></script>
  <script>
	  	$(document).ready(function(){
	  		var category_id = <%= category_id %>;
			getCategories(category_id);
			getProductos(category_id);
		});
  </script>

</body>

</html>
