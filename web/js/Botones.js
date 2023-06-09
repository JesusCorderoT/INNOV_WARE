
//--
$(function () {
    $('#cance').click(function (e) {
        e.preventDefault();
        var elemento = $(this);
        var idproducto = elemento.parent().find('#idarticulo').text();
       // alert(idproducto);
        $.ajax({
            url: 'borraritem4',
            type: 'post',
            data: {idproducto: idproducto},
            success: function (r) {
                alert('Cotizacion cancelada Servicios'); 
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                sessionStorage.clear();
                sessionStorage.clear();
                 window.history.go(-2);
                $('#txt-total').text(r);
            }  
        })
    });
}); 


$(function () {
    $('#cance2').click(function (e) {
        e.preventDefault();
        var elemento = $(this);
        var idproducto2 = elemento.parent().find('#idarticulo2').text();
       // alert(idproducto);
        $.ajax({
            url: 'borraritem1',
            type: 'post',
            data: {idproducto2: idproducto2},
            success: function (r) {
                alert('Cotizacion cancelada Productos'); 
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                elemento.parent().parent().remove();
                sessionStorage.clear();
                sessionStorage.clear();
                 window.history.go(-2);
                $('#txt-total2').text(r);
            }  
        })
    });
}); 

function menos(){

    document.getElementById('quantity').value = parseInt(document.getElementById('quantity').value) - 1

}
function mas(){
    document.getElementById('quantity').value = parseInt(document.getElementById('quantity').value) + 1
}

function menos2(){
var can = document.getElementById('txt-cantidad').textContent;
    alert(can);
    document.getElementById('txt-cantidad').value = parseInt(document.getElementById('txt-cantidad').value) - 1

}
function mas2(){
    var can = document.getElementById('txt-cantidad').textContent;
    alert(can);
    document.getElementById('txt-cantidad').value = parseInt(document.getElementById('txt-cantidad').value) + 1
}

function ala(){
    
    var can = document.getElementById('txt-cantidad').textContent;
    alert(can); 
}
