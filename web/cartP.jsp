<%@page import="SERVICIOSJCT.EmailAdmo"%>
<%@page import="SERVICIOSJCT.Email"%>
<%@page import="PRODUCTOSJCT.Producto2"%>
<%@page import="PRODUCTOSJCT.ControladorProducto2"%>
<%@page import="PRODUCTOSJCT.Articulo2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%
        HttpSession sesion2 = request.getSession(true);
        ArrayList<Articulo2> articulos2 = sesion2.getAttribute("carrito2") == null ? null : (ArrayList) sesion2.getAttribute("carrito2");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cotización Productos</title>
        
        <link href="images/INNOV_1.png" rel="icon">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">     
        <link rel="shortcut icon" href="images/ico/favicon.ico">
                <link href="css/PopUp.css" rel="stylesheet">

    </head><!--/head-->

    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
  
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="Menu_Cliente.jsp"><i class="fa fa-user"></i> Menú</a></li>
                                    <li><a href="shop.jsp"><i class="fa fa-star"></i> Servicios</a></li>
                                    <li><a href="shopP.jsp"><i class="fa fa-crosshairs"></i> Productos</a></li>
                                    <li><a href="cart.jsp" class="active"><i class="fa fa-shopping-cart"></i> Carrito</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->
        </header><!--/header-->

        <section id="cart_items">
            <div class="container">
    <br><br>
                <div class="table-responsive cart_info" id="cart-container2">
                    <table class="table table-condensed" id="shop-table2">
                        <thead>
                            <tr class="cart_menu">
                                <th class="image">Imagen</th>
                                <th class="description">Nombre</th>
                                <th class="price">Precio</th>
                                <th class="quantity">Cantidad</th>
                                <th class="total">Total</th>
                                <th class=""></th>
                            </tr>
                        </thead>
                        <tbody id="no">
                            
                            <%
                            PRODUCTOSJCT.ControladorProducto2 cp = new ControladorProducto2();
                            double total =0;
                            if(articulos2 !=null){
                            for(Articulo2 a2: articulos2){
                            Producto2 producto2 = cp.getProducto2(a2.getIdProducto2());
                            total += a2.getCantidad2()*producto2.getPrecio2();
                            %>
                            
                            
                        <tr>
                <td class="cart_product"><a href=""><img src="<%=producto2.getImg2()%>" width="120" alt=""></a></td>
                     <td hidden>Nombre del producto:</td>
                <td class="cart_description"><h4><a href=""> <%=producto2.getNombre2()%></a></h4><!--<p>ID:<%=producto2.getId2()%></p>--></td>
                          <td hidden>Precio c/u:</td>
                <td class="cart_price"><p>$<%=producto2.getPrecio2()%></p></td>
                      <td hidden>Cantidad:<%=a2.getCantidad2()%></td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a onclick="menos()"  class="cart_quantity_up" href="#"> - </a>
                                        <input id="quantity" class="cart_quantity_input" type="text" name="quantity" value="<%=a2.getCantidad2()%>" autocomplete="off" size="2">
                                        <a onclick="mas()"  class="cart_quantity_up" href="#"> + </a>
                                       
                                    </div>
                                </td>
                                     <td hidden>Precio suma:</td>
                                     <td class="cart_total"><p id="total9" class="cart_total_price">$<%=Math.round(producto2.getPrecio2()*a2.getCantidad2()*100.0)/100.0%></p></td>
                   <td hidden>ID:</td>
                                <td class="cart_delete">
                                    <span id="idarticulo2" style="display: none"  ><%=producto2.getId2()%></span>
                                    <a class="cart_quantity_delete" href="" id="deleteitem2"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%
                                }}
                            %>
                        </tbody>
                    </table>
                                                 <%
                        if (articulos2 == null){ %>
                        <h1>No seleccionaste un producto</h1>
                        <%  }
                       
%>
                </div>
                <p href="javascript:window.history.go(-2);" class="btn btn-default update" id="cance2" >Cancelar cotizacion</p>
                <a href="javascript:window.history.go(-2);" class="btn btn-default update" >Añadir más productos</a>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="heading">
                            <h3>Si requieres más productos haz clic en añadir más productos</h3>
                    <p>Para finalizar da clic en generar PDF.</p>
                </div>
                <div class="row">
 
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                        
                                <li>Total final: <span id="txt-total2">$<%= Math.round(total*100.00)/100.00%></span></li>
                            </ul>
                              <a id="export" class="btn btn-default update" href="">Descargar PDF</a>
                                           <div class="contenedor">
            <article>
                <button id="btn-abrir-popup" class="btn-abrir-popup">Recibir por correo</button>
            </article> 
            <div  class="overlay" id="overlay">
                <div class="popup" id="popup">
                    <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                    <h3>Ingresa tu correo</h3>
                    <h4>A esta dirección enviaremos el resumen de tu cotización.</h4>
                    <form action="cartP.jsp" method="post">
                    <div class="contenedor-inputs">
                        
                    <input required type="text" name="para3" placeholder="E-mail"/>
                    <input hidden value="" type="text" name="de3"/>
                    <input hidden value="J3suscordero" type="password" name="clave3"/>
                    <input required type="text" name="asunto3" placeholder="Nombre"/>
                    <input hidden value="Aqui esta el resumen de tu cotizacion de productos" name="mensaje3" cols="40" rows="10"/>
                    
                    
                    <input hidden value="2518360032jcorderot@gmail.com" type="text" name="para4" />
                    <input hidden value="jesus.of.999@gmail.com" type="text" name="de4"/>
                    <input hidden value="J3suscordero" type="password" name="clave4"/>
                    <input hidden="" value="Se realizo una cotización de productos" name="mensaje4" cols="40" rows="10"/>
                    
                    <br><br> 
                    <input name="assd" id="export2" class="btn-submit" type="submit" value="ENVIAR"/>
                    </div>
                    </form> 
                </div>
            </div>
        </div>
                                                      <%
            
            Email em = new Email();
            
            String de = request.getParameter("de3");
            String clave = request.getParameter("clave3");
            String para = request.getParameter("para3");
            String mensaje = request.getParameter("mensaje3");
            String asunto = request.getParameter("asunto3");
            //String mas = request.getParameter("mas");
         
            boolean resultado = em.enviarCorreo(de, clave, para, mensaje, asunto);
            if(resultado){}else{}
            

          EmailAdmo am= new EmailAdmo(); 
            String de2 = request.getParameter("de4");
            String clave2 = request.getParameter("clave4");
            String para2 = request.getParameter("para4");
            String mensaje2 = request.getParameter("mensaje4");
            String asunto2 = request.getParameter("asunto3");

            boolean resultado2 = am.enviarCorreo(de2, clave2, para2, mensaje2, asunto2);
            if(resultado2){}else{}
            
        %>
                             
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#do_action-->
        
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
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
        <script src="js/Carro2.js"></script> 
        
        <script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.1/jspdf.debug.js" integrity="sha384-THVO/sM0mFD9h7dfSndI6TS0PgAGavwKvB5hAxRRvc0o9cPLohB0wb/PTA7LdUHs" crossorigin="anonymous"></script>
        <script src="jspdf.min.js"></script>
        <script src="jspdf.plugin.autotable.min.js"></script>
        
        <script src="js/jspdf.js"></script>
        <script src="js/jquery-2.1.3.js"></script>
        <script src="js/pdfFromHTML.js"></script>
        <script src="js/Carro3.js"></script>
        <script src="js/Botones.js"></script>
        <script src="js/PDF.js"></script>
                <script src="js/popup.js"></script>

        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="http://mrrio.github.io/jsPDF/dist/jspdf.min.js" type="text/javascript"></script>
        <script src="http://html2canvas.hertzen.com/build/html2canvas.js" type="text/javascript"></script> 
     
        
    </body>
</html>