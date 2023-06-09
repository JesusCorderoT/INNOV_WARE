

$(function (b) {
    $('tr #deleteitem2').click(function (a) {
        a.preventDefault();
        var elemento2 = $(this);
        var idproducto2 = elemento2.parent().find('#idarticulo2').text();
        //alert('carro 2 de productos'+idproducto2);
        $.ajax({
            url: 'borraritem1',
            type: 'post',
            data: {idproducto2: idproducto2},
            success: function (l) {
                elemento2.parent().parent().remove();

                var elementostabla2 = $('#shop-table2 tr');
                if (elementostabla2.length <= 1) {
                    $('#cart-container2').append("<h1>No seleccionaste productos</h1>");
                }
                $('#txt-subtotal2').text(l);
                $('#txt-total2').text(l);
            }
        })
    });
}); 