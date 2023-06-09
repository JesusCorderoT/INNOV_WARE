<%-- 
  MENU CLIENTE
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpServlet.*"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" >
            history.forward();

        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu cliente</title>

        <link href="images/INNOV_1.png" rel="icon">

        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
        <link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/Fo1.css">


        <script type="text/javascript" src="teatroScript.js"></script>
        <script type="text/javascript" src="Noticia_Administrador.js"></script>
        <script type="text/javascript" src="Cliente_comentario.js"></script>
        <script type="text/javascript" src="cuentas_admin.js"></script>
        <script type="text/javascript" src="otro_cuenta.js"></script>
        <script type="text/javascript" src="comentarios_ad.js"></script>
        <script type="text/javascript" src="reporte_noticia.js"></script>
        <script type="text/javascript" src="modificar_cuenta.js"></script>
        <script type="text/javascript" src="Cuentas_de_cliente.js"></script>
        <script type="text/javascript" src="JavaScriptDarkam_1.js"></script>

    </head>
    <body>


        <section id="intro">
            <div class="intro-text">
                <br><br><br><br><br><br><br><br><br><br><br>
                <h2>Bienvenido</h2>
                <p>Ingresaste como Cliente</p>
                <a href="#menuC" class="btn-get-started scrollto">Iniciar</a>
            </div>
        </section><!-- #intro -->

        <section id="menuC">
            <table width="100%" border="1">
                <tr width="100%" >
                    <td width="20%" align="center" ><a href="#menuC" onclick="DinamicoDiv('inicio');">INICIO</a></td>             
                    <td width="20%" align="center" ><a href="#menuC" onclick="DinamicoDiv('cuentas');">CUENTAS</a></td>
                    <td width="20%" align="center" ><a href="#menuC" onclick="DinamicoDiv('noticias');">NOTICIAS</a></td>
                    <td width="20%" align="center" ><a href="#menuC" onclick="DinamicoDiv('comentarios');">COMENTARIOS</a></td>
                    <td width="20%" align="center" ><a href="citasCliente.jsp" >CITAS</a></td>
                    <td width="20%" align="center" ><a href="indexUsuario_1.jsp" >PRODUCTOS</a></td>
                    <td width="20%" align="center"> <a href="indexCliente.jsp" > SERVICIOS</a></td>
                    <td width="20%" align="center"> <a href="Buzon.jsp" > Buz&oacute;n</a></td>
                    <td width="20%" align="center" ><a href="Cerrar" >SALIR</a></td>
                </tr>
            </table>
        </section>

        <table width="100%" border="1">
            <tr width="100%">
                <td colspan="5" >
                    <div id="inicio">

                        <!--==========================
    SECCION DE COTIZACIONES
  ============================-->
                        <section id="pricing" class="section-bg">
                            <div class="container">

                                <div class="section-header">
                                    <h3 class="section-title">Cotizaciones</h3>
                                    <span class="section-divider"></span>
                                    <p class="section-description">Realiza una cotizacion de los servicios o productos o haz una cita
                                        <br>La cotizacion te dara un PDF el cual podras descargar o recibirlo por correo</p>
                                </div>

                                <div class="row">
                                    <div class="col-lg-4 col-md-6">
                                        <div class="box featured wow fadeInUp">
                                            <h3>Productos</h3>
                                            <ul>
                                                <li><i class="ion-android-checkmark-circle"></i> Aqui podras hacer una cotizacion de los productos de tu agrado</li>
                                                <li><i class="ion-android-checkmark-circle"></i> Haz clic en cotizar para empezar</li>

                                            </ul>
                                            <a href="shopP.jsp" class="get-started-btn">Cotiza</a>
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="box featured wow fadeInUp">

                                            <ul>
                                                <img src="images/home/Laptop.png"
                                            </ul>

                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="box featured wow fadeInUp">
                                            <h3>Servicios</h3>
                                            <ul>
                                                <li><i class="ion-android-checkmark-circle"></i>Aqui podras hacer una cotización de los servicios de tu agrado </li>
                                                <li><i class="ion-android-checkmark-circle"></i> Haz clic en cotizar para empezar</li>
                                            </ul>
                                            <a href="shop.jsp" class="get-started-btn">Cotiza</a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </section><!-- FIN COTIZACIONES -->


                    </div>

            <center>
                <div id="cuentas" style="display: none">

                    <table>
                        <tr>

                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <center>
                                        <div id="botones_cuenta">
                                            <h1>CUENTAS</h1>  
                                            <input class="b1" type="button" onclick="cambiar_contra()" value="Cambiar password" id="boton">
                                            <br>
                                            <br>
                                            <input class="b1" type="button" onclick="formulario_elimina_cliente()" value="Eliminar Cuenta" id="boton">
                                            <br>
                                            <br>
                                            <input class="b1" type="button" onclick="form_modificar()" value="Modificar Cuenta" id="boton">
                                            <br>
                                        </div>
                                    </center>
                                </div>
                            </div>
                        </div>

                        <td>
                        <center>
                            <div id="funciones_cuenta"> </div>
                            <div id="validaciones_cuenta"></div>
                            <div id="mensajes_cuenta"></div>
                        </center>
                        </td>
                        </tr>
                    </table>
                </div>
            </center>

            <center>
                <div id="noticias" style="display: none">
                    <table width="100%" border="1">
                        <tr>     
                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <center>
                                        <h1>NOTICIAS</h1>  
                                        <div id="botones_noticia">               
                                            <input class="b1" id="boton_mostrar_noticia" type="button" value="Mostrar Noticia" onclick="mostrar_noticias_admin()">
                                            <br><br>
                                            <input class="b1" id="boton_buscar_noticia" type="button" value="Buscar noticia" onclick="mostrar_titulos_para_buscar();">
                                            <br><br>
                                            <input class="b1" id="boton_reportar_noticia" type="button" value="Reportar noticia" onclick="formulario_reportar();">
                                        </div>    
                                    </center>
                                </div>
                            </div>
                        </div>

                        <td>
                        <center>
                            <div id="funciones_noticia"></div>
                            <div id="validaciones_noticia"></div>
                            <div id="mostrar_mensajes_noticias"></div>
                        </center>
                        </td>
                        </tr>
                    </table>
                </div>
            </center>
            <center>
                <div id="comentarios" style="display: none">

                    <table>
                        <tr>
                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <center>
                                        <div id="botones_comentarios">
                                            <h1>COMENTARIOS</h1>
                                            <input class="b1" type="button" id="boton" onclick="ver_comen_cliente()" value="Ver Comentarios">
                                            <br><br>
                                            <input class="b1" type="button" value="crear comentario" onclick="mostrar_formulario_comentario()">
                                            <br><br>
                                            <input class="b1" type="button" value="Modificar comentario" onclick="formualrio_mod()">
                                        </div> 
                                    </center>
                                </div>    
                            </div>    
                        </div>    

                        <td>
                            <div id="funciones_comentarios"> </div>
                            <div id="validaciones_comentarios"></div>
                            <div id="mensajes_comentarios"></div>
                        </td>
                        </tr>
                    </table>
                </div>
            </center>
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
