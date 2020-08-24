function getProductos(){
	
	var idpro = document.getElementById("producto").value;
	var cantidad = document.getElementById("cantidad").value;
	
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Productos/lista/id/" + idpro, function(result){
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].id;
    		var name = result[row].nombre;
    		var pricing = result[row].precio;
    		var valor = pricing*cantidad;
    		
    		var dp = '<tr>';
    		dp += '<th scope="col">'+id+'</th>';
    		dp += '<td>'+name+'</td>';
    		dp += '<td>'+pricing+'</td>';
    		dp += '<td>'+cantidad+'</td>';
    		dp += '<td>'+valor+'</td></tr>'
    		
    		$("#datos").append(dp);       	
    	}
    });  
}