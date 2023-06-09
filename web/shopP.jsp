<%@page import="PRODUCTOSJCT.ControladorProducto2"%>
<%
    PRODUCTOSJCT.ControladorProducto2 cp = new ControladorProducto2();
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Catalogo productos</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        

<link href="images/INNOV_1.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">  
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
      
        <!--==========================
          SECCION Intro 
        ============================-->
        <section id="intro">

            <div class="intro-text">
                <br><br><br><br><br><br><br><br><br><br><br>
                <h2>Productos</h2>
                <p>Realiza una cotizacion de los productos que ofrecemos</p>
                <a href="Menu_Cliente.jsp" class="btn-get-started scrollto">Regresar</a>
            </div>





        </section><!-- #intro -->
        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <br>
                            <h2>Categorias</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-parent="#accordian" href="shop.jsp">
                                                Servicios
                                            </a>
                                        </h4>
                                    </div>
                             
                                </div>


                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-parent="#accordian" href="shopP.jsp">
                                       Productos
                                            </a>
                                        </h4>
                                    </div>

                                </div>

                            </div><!--/category-productsr-->
                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <br>
                            <h2 class="title text-center">Selecciona algunos productos para añadir a la cotización</h2>

                            <!-- CARGAR PRODUCTOS REALES--> 
                            <%=cp.getProductos2()%>   

                        </div><!--features_items-->
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
                            <a href="Menu_Cliente.jsp" class="scrollto">Inicio</a>
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
        <script src="js/Carro2.js"></script> 
    </body>
</html>