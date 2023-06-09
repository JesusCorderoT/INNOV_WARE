<%-- 
    Document   : index
    Created on : 30/10/2019, 08:05:45 PM
    Author     : alvar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="ScriptServicios.js" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
   <link href="images/INNOV_1.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
        <title>Menú de Servicios </title>
    </head>
    
    <body>
        

        
        
        <section id="a">
        <table width="100%" height="1%">
            <tr>
                <td width="30%" height="123"></td>
                <td width="70"><h1>Menú Servicios INNOV&WARE</h1></td>
            </tr>
        </table>
        

        
        <table width="100%" border="1"> 
            <tr width="100%">
                <td colspan="5">
                    <div id="inicio">
                        <table border="3" width="100%">
                            <tr>
                                <td width="20%">
                                    <button id="b1" name="opcion" value="1" onclick="formularioRegistar()"style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Registrar Servicio</button><br/><br/>
                                    <button id="b2" name="opcion" value="2" onclick="formularioConsultarServicios()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Ver servicios</button><br/><br/>
                                    <button id="b3" name="opcion" value="3" onclick="formularioRegistrarDescripcionServicio()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Registrar descripción de servicio</button><br/><br/>
                                    <button id="b4" name="opcion" value="4" onclick="formularioBuscarDescripcionServicio()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Ver descripción de servicio</button><br/><br/>
                                    <button id="b5" name="opcion" value="5" onclick="formularioRegistroCategoria()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Registro de categoría</button><br/><br/>
                                    <button id="b6" name="opcion" value="6" onclick="buscarCategorias()" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;"/>Ver categoría</button><br/><br/>
                                    <a href="Menu_Administrador.jsp"><input type="button" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" value="volver"></a>
                                </td>
                                
                                <td>
                                    
                                    <div style="text-align: center" id="detalle"></div>
                                </td>
                                
                            </tr>
                        </table>
                    </div>
                    
                </td>
            </tr>
            <tr>
                <td colspan="5" align="center"><strong>Realizado por NERV </strong></td>
            </tr>
        </table></section>
        
        
        
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
