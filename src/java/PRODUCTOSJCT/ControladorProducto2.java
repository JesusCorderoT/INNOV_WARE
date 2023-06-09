package PRODUCTOSJCT;

public class ControladorProducto2 {
 
    public String getProductos2() {
        ModeloProducto mp = new ModeloProducto();
        String htmlcode = "";
        for (Producto2 producto : mp.getAllProductos2()) {
            htmlcode += "<div class=\"col-sm-4\">\n"
        + "	<div class=\"product-image-wrapper\">\n"
        + "	<div class=\"single-products\">\n"
        + "	<div class=\"productinfo text-center\">\n"
        + "	<img src=\"" + producto.getImg2() + "\" alt=\"\" />\n"
        + "	<h2>$" + producto.getPrecio2() + "</h2>\n"
        + "	<p>" + producto.getNombre2() + "</p>\n"
        + "</div>\n"
        + "<div class=\"product-overlay\">\n"
        + "<div class=\"overlay-content\">\n"
        + "<h2>$" + producto.getPrecio2() + "</h2>\n"
        + "<p>" + producto.getNombre2() + "</p>\n"
        + "	<a href=\"product-detailsP.jsp?id=" + producto.getId2() + "\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Ver Detalles</a>\n"
        + "	</div>\n"
        + "</div>\n"
        + "	</div>\n"
        + "	<div class=\"choose\">\n"
        + "	<ul class=\"nav nav-pills nav-justified\">\n"
        + "	</ul>\n"
        + "	</div>\n"
        + "	</div>\n"
        + "	</div>";
        }
        return htmlcode;
    }

    public Producto2 getProducto2(int id) {
        return new ModeloProducto().getProducto2(id);
    }
}
