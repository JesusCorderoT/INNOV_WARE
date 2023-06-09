<%-- 
   CITAS CLIENTE 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="script2.js"></script>
        <title>Citas cliente</title>

        <link rel="stylesheet" type="text/css" href="css/Fo1.css">

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
        <table>
            <tr>
                <td width="70%"><h1>CITAS CLIENTE</h1></td>
            </tr>
            <table width="100%" border="1">
                <td width="20%" align="center"><a href="Menu_Cliente.jsp">REGRESAR</a></td>
                <td width="20%" align="center" onclick="FormAgendar()"><a href="#" onclick="DinamicoDiv('agendar');">AGENDAR CITA</a></td>
                <td width="20%" align="center" onclick="Formcita()"><a href="#" onclick="DinamicoDiv('consultar');">CONSULTAR CITA</a></td>
                <td width="20%" align="center" onclick="FormModificar()"><a href="#" onclick="DinamicoDiv('modificar');">MODIFICAR CITA</a></td>
                <td width="20%" align="center" onclick="FormCancelar()" ><a href="#" onclick="DinamicoDiv('cancelar');">CANCELAR CITA</a></td>
            </table>
            <table width="100%" border="1">
                <tr width="100%">
                    <td colspan="5">
                        <div id="inicio"><h3>Bienvenido agenda una cita para que podamos ayudarte a seleccionar los mejores articulos para ti</h3></div>
                <center> <div id="agendar" style="display: none">
                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <h3>AGENDAR CITA</h3>
                                    <p id="maque"></p>
                                </div>
                            </div>
                        </div>
                    </div></center>
                <center><div id="consultar" style="display: none">
                         <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <h3>CONSULTAR CITA</h3>
                        <p id="maquet"></p>
                        </div>
                                </div>
                             </div>
                    </div></center>
                <center><div id="modificar" style="display: none">
                          <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <h3>MODIFICAR CITA</h3>
                        <p id="maqueta"></p>
                        </div>
                                </div>
                              </div>
                    </div></center>
                <center><div id="cancelar" style="display: none">
                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <h3>CANCELAR CITA</h3>
                        <p id="maquetado"></p>
                        </div>
                                </div>
                            </div>
                    </div></center>
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
                                <a href="index.html" class="scrollto">Inicio</a>
                                <a href="#about" class="scrollto">Nosotros</a>
                                <a href="#">Privacidad</a>
                                <a href="#">Terminos de uso</a>
                            </nav>
                        </div>
                    </div>
                </div>
            </footer><!-- FIN Footer -->

    </body>
</html>
