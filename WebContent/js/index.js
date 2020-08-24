function getCategories(category_id){
    $.getJSON("services/Categorias/list", function(result){
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].idCatalogo;
    		var name = result[row].nombre;
    		
    		var item_class = "list-group-item";
    		if(id == category_id){
    			item_class = "list-group-item active";	
    		}
    		$("#div_categories").append("<a href='javascript:getProductos(" + id + ");' id='category_" + id + "' class='" + item_class + "'>" + name + "</a>");
    	}
    });
}
