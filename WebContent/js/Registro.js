function send() {
        var person = {
            nombre: document.getElementById("nombre").value,
            dirrecion:document.getElementById("dirrecion").value,
            celular:document.getElementById("celular").value,
            apellido:document.getElementById("apellido").value,
            tipoDocumento:document.getElementById("tipoDocumento").value,
            numeroDocumento:document.getElementById("numeroDocumento").value
        }
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Well done!</h4>';
        htmnn += '<p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p> ';
        htmnn += '<hr> <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>    </div>   ';
        
        console.log(person);
        console.log(JSON.stringify(person));
        $.ajax({
            url: 'services/Clientes/Nuevo',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
            	$('#div_review_response').append(htmnn);
            },
            data: JSON.stringify(person),
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
       
        
}