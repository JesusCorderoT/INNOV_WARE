$(function () {
    $('tr #deleteitem').click(function (e) {
        e.preventDefault();
        var elemento = $(this);
        var idproducto = elemento.parent().find('#idarticulo').text();
        alert(idproducto);
        $.ajax({
            url: 'borraritem',
            type: 'post',
            data: {idproducto: idproducto},
            success: function (r) {
                elemento.parent().parent().remove();

                var elementostabla = $('#shop-table tr');
                if (elementostabla.length <= 1) {
                    $('#cart-container').append("<h1>No seleccionaste servicios carro 1</h1>");
                }
                $('#txt-subtotal').text(r);
                $('#txt-total').text(r);
            }
        })
    });
}); 


/*
$(function c() {
    $('tr #deleteitem2').click(function (e) {
        e.preventDefault();
        var elemento2 = $(this);
        var idproducto2 = elemento2.parent().find('#idarticulo2').text();
        //alert(idproducto);
        $.ajax({
            url: 'borraritem2',
            type: 'post',
            data: {idproducto2: idproducto2},
            success: function c(r) {
                elemento2.parent().parent().remove();

                var elementostabla2 = $('#shop-table2 tr');
                if (elementostabla2.length <= 1) {
                    $('#cart-container2').append("<h1>No seleccionaste productos JS</h1>");
                }
                $('#txt-subtotal2').text(r);
                $('#txt-total2').text(r);
            }
        })
    });
}); */