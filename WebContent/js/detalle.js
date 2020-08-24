function getFactura(){
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Factura/list", function(result){
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var fecha = result[row].fecha;
    		var hora = result[row].hora;
    		var valortotal = result[row].valor_Total;
    		var nombrecliente = result[row].nombreCliente;
    		var nombrecajero = result[row].nombreUsuario;    		
    		var fac='<div class="row"><label> <strong>Fecha :</strong> </label><label> '+fecha+'</label></div>';
    		fac = fac+ '<div class="row"><label><strong> hora : </strong></label><label> '+hora+'</label></div>';
    		fac = fac+ '<div class="row"><label><strong> Nombre Cliente :</strong> </label><label> '+nombrecliente+'</label></div>';
    		fac = fac+ '<div class="row"><label><strong> Cajero : </strong></label><label> '+nombrecajero+'</label></div>';
    		fac = fac+ '<div class="row"><label><strong> Valor Total : <strong></label><label> '+valortotal+'</label></div>';
    		
    		$("#dacfactura").append(fac);
    		
    		
    	}
    });
}



function getDetalle(){
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Detalle/list", function(result){
		var table = '<table class="table table-striped"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col"> Precio </th><th scope="col">Cantidad</th><th scope="col">Valor</th>';
		table = table +'</tr></thead><tbody id="data"></tbody></table>';
		$("#detalle").append(table);
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].idProducto;
    		var name = result[row].nombre;
    		var precio = result[row].precio;
    		var cantidad = result[row].cantidad;
    		var valorUni = precio*cantidad;
    		console.log(id +" "+name+" "+precio+" "+cantidad);
    		var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td><td>';
    		fac = fac+ precio +'</td> <td> '+cantidad+'</td><td>'+valorUni+'</td></tr>';    		
    		$("#data").append(fac);
    	}
    });
}
