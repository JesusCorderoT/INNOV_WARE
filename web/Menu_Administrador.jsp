<%-- 
   MENU ADMINITRADOR
--%>
<%@page session="true" %>
<%@page import="javax.servlet.http.HttpServlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
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
        <script type="text/javascript" src="cuentas_admin.js"></script>
        <script type="text/javascript" src="comentarios_ad.js"></script>
        <script type="text/javascript" src="otro_cuenta.js"></script>
        <script type="text/javascript" src="Cliente_comentario.js"></script>
        <script type="text/javascript" src="reporte_noticia.js"></script>
        <script type="text/javascript" src="modificar_cuenta.js"></script>
        <script type="text/javascript" src="Cuentas_de_cliente.js"></script>
        <script type="text/javascript" src="JavaScriptJorgeChido.js"></script>




    </head>
    <section id="intro">

        <div class="intro-text">
            <br><br><br><br><br><br><br><br><br><br><br>
            <h2>Bienvenido</h2>
            <script type="text/javascript" >
                history.forward();

            </script>
            <p>Ingresaste como Administrador</p>
            <a href="#a" class="btn-get-started scrollto">Iniciar</a>
        </div>
    </section><!-- #intro --> 
    <body>

        <section id="a" >
            <table width="100%" border="1">
                <tr width="100%" >
                    <td width="20%" align="center" ><a href="#a" onclick="DinamicoDiv('inicio');">INICIO</a></td>             
                    <td width="20%" align="center" ><a href="#a" onclick="DinamicoDiv('cuentas');">CUENTAS</a></td>
                    <td width="20%" align="center" ><a href="#a" onclick="DinamicoDiv('noticias');">NOTICIAS</a></td>
                    <td width="20%" align="center" ><a href="#a" onclick="DinamicoDiv('comentarios');">COMENTARIOS</a></td>
                    <td width="20%" align="center"> <a href="#a" onclick="DinamicoDiv(('PRODUCTOS'))" > PRODUCTOS</td>
                    <td width="20%" align="center"> <a href="citasAdmin.jsp" > CITAS</a></td>
                    <td width="20%" align="center"> <a href="index.jsp" > SERVICIOS</a></td>
                    <td width="20%" align="center" ><a href="Cerrar" >SALIR</a></td>
                </tr>
            </table>
        </section>

        <table width="100%" border="1">
            <tr width="100%">
                <td colspan="5" >
                    <div id="inicio">
                        <center>
                            <h3>Administra todas las funciones de tu paginá web </h3>
                            <h3>Iniciemos seleccionando una opción</h3>
                        </center>
                    </div>






            <center>  <div id="cuentas" style="display: none">
               
                    <table>
                        <tr>

                        <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                    <div id="botones_cuenta">
                                               <h1>CUENTAS</h1>   
                                        <input class="b1" type="button" value="crear cuenta" onclick="mostrarFormulario()">
                                        <br>
                                        <br>
                                        <input class="b1" type="button" onclick="cambiar_contra()" value="Cambiar password" id="boton">
                                        <br>
                                        <br>
                                        <input class="b1" type="button" onclick="ver_usuarios()" value="Buscar usuarios" id="boton">
                                        <br>
                                        <br>
                                        <input class="b1" type="button" onclick="form_modificar()" value="Modificar Cuenta" id="boton">
                                    </div>
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
                </div> </center>

            <center> <div id="noticias" style="display: none">
                    <table width="100%" border="1">
                        <tr>
                        <center>
                            <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                            <div id="botones_noticia">
                                      <h1>NOTICIAS</h1>
                                <br>
                                <input class="b1" id="boton_crear_noticia" type="button" value="Crear noticia" onclick="mostrar_formulario_noticia()">
                                <br><br>
                                <input class="b1" id="boton_mostrar_noticia" type="button" value="Mostrar Noticia" onclick="mostrar_noticias_admin()">
                                <br><br>
                                <input class="b1" id="boton_buscar_noticia" type="button" value="Buscar noticia" onclick="mostrar_titulos_para_buscar();">
                                <br><br>
                                <input class="b1" id="boton_eliminar_noticia" type="button" value="Eliminar noticia" onclick="mostrar_noticia_para_eliminar()">
                                <br><br>
                                <input class="b1" id="modificar_noticia" type="button" value="Modificar noticia" onclick="mostrar_noticias_modificar()">
                                <br><br>
                                <input class="b1" id="modificar_noticia" type="button" value="ver reportes de noticia" onclick="ver_reportes()">
                            </div>
                                    </div>
                                </div>
                                </div>
                        </center>
                        <td>
                        <center>
                            <div id="funciones_noticia"></div>
                            <div id="validaciones_noticia"></div>
                            <div id="mostrar_mensajes_noticias"></div>
                            </center>
                        </td>
                        </tr>
                    </table>
                </div></center>

            <center>
                <div id="comentarios" style="display: none">
                    <table>
                        <tr>
                              <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                                <div id="botones_comentarios">
                                          <h1>COMENTARIOS</h1>
                                          <input class="b1" type="button" value="crear comentario" onclick="mostrar_formulario_comentario()">
                                    <br><br>
                                    <input class="b1" type="button" value="ver comentarios" onclick="ver_comentarios_ad()">
                                    <br><br>
                                    <input class="b1" type="button" value="Modificar comentario" onclick="formualrio_mod()">
                                </div>  
                                    </div>
                                </div>
                                  </div>
                            
                            <td>
                                <center>
                                <div id="funciones_comentarios"> </div>
                                <div id="validaciones_comentarios"></div>
                                <div id="mensajes_comentarios"></div>
                                </center>
                            </td>
                        </tr>
                    </table>
                </div>
            </center>



            <center>
                <div id="PRODUCTOS" style="display: none">
                    <h1>PRODUCTOS</h1>

                    <table align="center" >
                        <tr>
                            <td>
                                <input class="b1" type="button" id="registrarProductos" value="Regristrar productos" onclick="formRegistrarProducto();" align="center">
                                <input class="b1" type="button" id="verProductos" value="Ver todos productos" onclick="formMostrarTodosLosProductos();" align="center">
                                <input class="b1" type="button" id="cotizaciones" value="Ver lista de cotizaciones" onclick="MostrarListaCotizaciones();" align="center">
                                <input class="b1" type="button" id="pendientes" value="Ver lista de pendientes" onclick="MostrarListaPendientes();" align="center">
                                <input class="b1" type="button" id="Garantias" value="Ver Garantias" onclick="FormMostarGarantia();" align="center">

                            </td>
                        </tr>
                    </table>


                    <table align="center">
                        <tr>
                            <td align="center">
                                <p>Buscar producto por nombre: </p>
                            </td>
                            <td align="center">
                                <p><input  type="text" name="nombre_producto" id="nombre_productoJ"> 
                                    <input class="b1" type="button" name="buscarPro" id="buscarPro" value="Buscar producto" onclick="buscarProductoNombre();"> </p>

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
                <div id="servicios" style="display: none">
                    <h3>Servicios</h3>
                </div>
                <div id="boletin" style="display: none">
                    <h3>Boletín</h3>
                </div>
                <div id="usuario" style="display: none">
                    <h3>Usuarios</h3>
                </div>
                </td>
                </tr>
                </div>
                <tr>   
                    <td>
                    </td>
                </tr>
        </table>
    </td>
</tr>
<tr>
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
