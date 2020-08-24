function getItems(){
	
	setInterval(function(){
	    $.ajax({
	        url: 'http://localhost:8080/JPAProfundizacion/services/item/list',
	        type: 'GET',
	        dataType: 'json',
	        contentType: 'application/json',
	        success: function (data) {
	        	$('#datos').empty();            
	        	console.log(data);
	        	var total=0;
	        	for(var row=0; row<data.length; row=row+1){
	        		$('#valortotal').empty();
	        		var name = data[row].nombre;
	        		var pricing = data[row].precio;
	        		var id = data[row].id;
	        		var cantidad = data[row].cantidad;
	        		var valor = data[row].valor;
	        		total=total + valor; 
	        		console.log(name);
	        		console.log(pricing);
	        		var dp = '<tr>';
	        		dp += '<th scope="col">'+id+'</th>';
	        		dp += '<td>'+name+'</td>';
	        		dp += '<td>'+pricing+'</td>';
	        		dp += '<td>'+cantidad+'</td>';
	        		dp += '<td>'+valor+'</td></tr>'
	        		
	        		$("#datos").append(dp);
	        		var vt= '<label >'+total+'</label> ';
	        		$("#valortotal").append(vt);
	        	}
	        },
	        failure: function(errMsg) {
	            alert(errMsg);
	        }
	    });
	}, 3000);
}