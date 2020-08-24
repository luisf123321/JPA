function getProductos(category_id){
	
	$('.list-group-item').removeClass('active').addClass('');
	$("#category_" + category_id).addClass('active');
		
    $.getJSON("services/Productos/lista/" + category_id, function(result){
    	console.log(result);
    	$('#div_products').empty();
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].id;
    		var name = result[row].nombre;
    		var pricing = result[row].precio;
    		var short_description = result[row].descripcion;
    		
    		var dp = '';
    		dp += '<div class="col-lg-4 col-md-6 mb-4">';
    		dp += '<div class="card h-100">';
    		dp += '<a href="#"><img class="card-img-top" src="images/product01.jpg" alt=""></a>';
    		dp += '<div class="card-body">';
    		dp += '<h4 class="card-title">';
    		dp += '<a href="item.jsp?id=' + id + '">' + name + '</a>';
    		dp += '</h4>';
    		dp += '<h5>$' + pricing.toFixed(2) + '</h5>';
    		dp += '<p class="card-text">' + short_description + '</p>';
    		//dp += '<button type="button" class="btn btn-primary btn-sm">Buy</button>';
    		dp += '<a href="javascript:addToCart(' + id + ');" class="btn btn-info" role="button">Buy</a>';
    		dp += '</div>';
    		dp += '<div class="card-footer">';
    		dp += '<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>';
    		dp += '</div>';
    		dp += '</div>';
    		dp += '</div>';
    		
    		$("#div_products").append(dp);       	
    	}
    });  
}