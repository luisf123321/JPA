function buscarDocumento(){
	var documento = document.getElementById("cedula").value;
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Clientes/list/" + documento, function(result){
    	
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].id;
    		var name = result[row].nombre;
    		var apellido = result[row].apellido;
    		console.log(id + " "+name+" "+apellido);
    		
    		$("#apellido").val(apellido);
    		$("#nombre").val(name);
    	}
    });
}