<%@page import="java.sql.SQLException"%>
<%@page import="SERVICIOSJCT.Conexion1"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="SERVICIOSJCT.ControladorProducto"%>
<%@page import="SERVICIOSJCT.Producto"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Producto producto = new ControladorProducto().getProducto(id);

    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion1 conecta = new Conexion1();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Detalle de servicio</title>
        <link href="images/INNOV_1.png" rel="icon">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link rel="shortcut icon" href="images/ico/favicon.ico">




    </head><!--/head-->

    <body>
        <header id="header"><!--header-->
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="Menu_Cliente.jsp"><i class="fa fa-user"></i> Men�</a></li>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Carrito</a></li>
                               
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->
        </header><!--/header-->

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">

                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            </div><!--/category-products-->
                            <div class="shipping text-center"><!--shipping-->
                                <!-- <img src="images/home/INNOV.png" alt="" /> -->
                            </div><!--/shipping-->
                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img src="<%=producto.getImg()%>" alt="" />
                                </div>

                            </div>
                            <div class="col-sm-7">
                                <div class="product-information"><!--/product-information-->
                                    <h2><%=producto.getNombre()%></h2>
                                    <p>ID:<%=producto.getId()%></p>
                                    <form action="agregarproducto" method="post" >
                                        <span>
                                            <span>$<%=producto.getPrecio()%></span>
                                            <label>Cantidad:</label>
                                            <input type="hidden" name="idproducto"  value="<%=producto.getId()%>" />
                                            <input type="text" value="1" id="txt-cantidad" name="cantidad" />
                                            <button type="submit" class="btn btn-fefault cart">
                                                <i class="fa fa-shopping-cart"></i>
                                                A�adir al carrito
                                            </button>
                                        </span>
                                    </form>



                                    <% conecta.Conectar();
                                        sentenciaSQL = conecta.getSentenciaSQL();
                                        try {
                                            String comando = "select descripcion from detalle_servicio where id_detalle="+producto.getId();
                                            cdr = sentenciaSQL.executeQuery(comando);
                                    %>
                                    <%while (cdr.next()) {%>
                                    Descripci�n: <p value="<%=cdr.getString(1)%>"><b><%=cdr.getString(1)%></b></a>
                                            <%}%>
                                            <%
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                            %>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->
                    </div>
                </div>
            </div>
        </section>

        <!--==========================
SECCION Footer
============================-->
        <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 text-lg-left text-center">
                        <div class="copyright">
                            &copy; Copyright <strong>INNOV&WARE</strong>. All Rights Reserved
                        </div>
                        <div class="credits">
                            Designed by <a href="#">NERV</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="footer-links text-lg-right text-center pt-2 pt-lg-0">
                            <a href="#intro" class="scrollto">Inicio</a>
                            <a href="#about" class="scrollto">Nosotros</a>
                            <a href="#">Privacidad</a>
                            <a href="#">Terminos de uso</a>
                        </nav>
                    </div>
                </div>
            </div>
        </footer><!-- FIN Footer -->

        <script src="js/jquery.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>