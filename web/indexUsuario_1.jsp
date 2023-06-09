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
        <title>Innov&Ware: Usuario</title>
                       
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
        
        <script type="text/javascript" src="JavaScriptJorgeChido.js"></script>


        <table width="100%" border="1">
            <tr width="100%">
                <td width="20%" align="center"><a href="Menu_Cliente.jsp" onclick="DinamicoDiv('inicio');">INICIO</a></td>
                <td width="20%" align="center"><a href="#" onclick="DinamicoDiv('productos');">PRODUCTOS</a></td>
                <td width="20%" align="center"><a href="#" onclick="DinamicoDiv('servicios');">SERVICIOS</a></td>
                <td width="20%" align="center"><a href="#" onclick="DinamicoDiv('boletin');">BOLETIN</a></td>
                <td width="20%" align="center"><a href="#" onclick="DinamicoDiv('usuario');">USUARIO</a></td>
            </tr>
        </table>
        <table width="100%" border="1">
            <tr width="100%">
                <td colspan="5">
                    <div id="inicio">
                        <h3 align="center" >Bienvenido</h3>
                        <table border="3" width="100%">
                            <tr>
                                <td width="20%">
                                    <p></p>
                                </td> 
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
                                        <input type="button" name="buscarProducto" id="buscarProducto" value="Buscar producto" onclick="Prueba();"> 
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
        </table>



    </body>
</html>
