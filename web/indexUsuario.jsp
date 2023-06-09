<%-- 
    Document   : indexUsuario
    Created on : 7/11/2019, 02:04:01 AM
    Author     : Darkam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
               
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        
        <script type="text/javascript" src="JavaScriptJorge.js"></script>

     

        <table width="100%" border="1">
            <tr width="100%">
                <td width="20%" align="center"><a href="Menu_Cliente.jsp" >Regresar</a></td>
                <td width="20%" align="center"><a href="#" onclick="DinamicoDiv('productos');">PRODUCTOS</a></td>
               
            </tr>
        </table>
        <table width="100%" border="1">
            <tr width="100%">
                <td colspan="5">
                    <div id="inicio">
                      
                        <table border="3" width="100%">
                            <tr>
                           Aqui que o que?
                                <td>
                                    <div id="detalle">  </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                   <div id="productos" style="display: none">
                       
                                    <h3 align="center">Productos</h3>
                       
                        
                        <table align="center">
                            <tr>
                                <td align="center">
                                    <p>Buscar producto por nombre: </p>
                                </td>
                                <td align="center">
                                    <p><input type="text" name="nombre_producto" id="nombre_producto"> 
                                        <input type="button" name="buscarPro" id="buscarPro" value="Buscar producto" onclick="buscarProductoNombreUser();"> 
                                        <input type="button" name="VerCotizados" id="VerCotizados" id="verMisProductos" value="Ver Mis productos" onclick="FormMisProductos();">
                                    </p>
                                    
                                </td>
                            </tr>
                        </table>
                        
                        <table border="0.5" align="center">
                            <tr>
                                <td>

                                    <div id="Respuesta" align="center"></div>
                                </td>


                                <td>

                                    <br>
                                    <div id="RespuestaTodosLosProcudtos" align="center"></div>
                                </td>




                            </tr>
                        </table>

                        <table align="center">
                            <tr>
                                <td>
                                    <div id="RespuestaMasOpciones"></div>
                                </td>
                            </tr>
                        </table>

                        <table align="center">
                            <tr>
                                <td>
                                    <div id="RespuestaMasOpciones2"></div>
                                </td>
                            </tr>
                        </table>

                        <table align="center">
                            <tr>
                                <td>
                                    <div id="RespuestaMasOpciones3"></div>
                                </td>
                            </tr>
                        </table>



                    </div>
                    
                </td>
            </tr>

            
        </table>


        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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

              <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
  <script src="lib/magnific-popup/magnific-popup.min.js"></script>
  <script src="js/main2.js"></script>
    </body>
</html>
