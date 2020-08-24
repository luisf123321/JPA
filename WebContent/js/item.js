function getItem(){
	var idpro = document.getElementById("producto").value;
	var cantidad = document.getElementById("cantidad").value;
	
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/item/add/"+idpro+"/"+cantidad, function(result){
    	console.log(result);
    });
    
}
function getCancelarPro(){
	var idpro = document.getElementById("producto").value;
	var cantidad = document.getElementById("cantidad").value;
	
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/item/Cancelar", function(result){
    	console.log(result);
    });
    
}
function getAceptar(){
	
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Factura/Nuevo", function(result){
    	console.log(result);
    });
    location.href="http://localhost:8080/JPAProfundizacion/usuario/factura.jsp";    
}
function Regresar(){
	
    $.getJSON("http://localhost:8080/JPAProfundizacion/services/Factura/Fin", function(result){
    	console.log(result);
    });
    location.href="http://localhost:8080/JPAProfundizacion/usuario/index.jsp";    
}