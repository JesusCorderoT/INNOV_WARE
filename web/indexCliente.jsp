<%-- 
    Document   : indexCliente
    Created on : 6/11/2019, 10:58:18 PM
    Author     : alvar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="ScriptServicios.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios Cliente</title>
  <link href="images/INNOV_1.png" rel="icon">
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
       
        <table width="100%" height="1%">
            <tr>
                <td width="30%" height="123"></td>
                <td width="70"><h1>Servicios Cliente INNOV&WARE</h1></td>
            </tr>
        </table>
        

        
        <table width="100%" border="1"> 
            <tr width="100%">
                <td colspan="5">
                    <div id="inicio">
                        <h3>Menú Servicios</h3>
                        <table border="3" width="100%">
                            <tr>
                                <td width="20%">
                                    <button id="b1" name="opcion" value="1" onclick="formularioConsultarServiciosCliente()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Ver Servicios</button><br/><br/>
                                    <button id="b2" name="opcion" value="2" onclick="formularioBuscarDescripcionServicioCliente()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Ver descripción de servicio</button><br/><br/>
                                    <button id="b3" name="opcion" value="3" onclick="GaleriaFotos()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Galeria de fotos</button><br/><br/>
                                    <button id="b4" name="opcion" value="4" onclick="GaleriaVideos()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Galeria de videos</button><br/><br/>
                                    <a href="Menu_Cliente.jsp"><input type="button" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" value="volver"></a>
                                </td>
                                <td>
                                    <div id="detalle"></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                    
                </td>
            </tr>
        </table>
        
        
        
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
