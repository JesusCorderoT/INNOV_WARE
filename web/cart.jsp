<%@page import="SERVICIOSJCT.EmailAdmo"%>
<%@page import="SERVICIOSJCT.Email"%>
<%@page import="SERVICIOSJCT.Producto"%>
<%@page import="SERVICIOSJCT.ControladorProducto"%>
<%@page import="SERVICIOSJCT.Articulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cotización Servicios</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/PopUp.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">     
       <link href="images/INNOV_1.png" rel="icon">
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
                <div class="table-responsive cart_info" id="cart-container">
                    <table class="table table-condensed" id="shop-table">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Imagen</td>
                                <td class="description">Nombre</td>
                                <td class="price">Precio</td>
                                <td class="quantity">Cantidad</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody  id="no2">
                            
                            <%
                            SERVICIOSJCT.ControladorProducto cp = new ControladorProducto();
                            double total =0;
                            if(articulos !=null){
                            for(Articulo a: articulos){
                            Producto producto = cp.getProducto(a.getIdProducto());
                            total += a.getCantidad()*producto.getPrecio();
                            %>
                              
                            
                             <tr>
         <td class="cart_product"><a href=""><img src="<%=producto.getImg()%>" width="120" alt=""></a></td>
         <td hidden>Nombre del servicio:</td>
         <td class="cart_description"><h4><a href=""> <%=producto.getNombre()%></a></h4><!--<p>ID:<%=producto.getId()%>--></p></td>
         <td hidden>Precio c/u:$</td>
         <td class="cart_price"><p><%=producto.getPrecio()%></p></td>
         <td hidden>Cantidad:<%=a.getCantidad()%></td>
         <td hidden></td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a href="#" onclick="document.getElementById('cantidad').value = parseInt(document.getElementById('cantidad').value) + 1" class="cart_quantity_up" > + </a> 
                                        <input id="quantity" class="cart_quantity_input" type="text" name="quantity" value="<%=a.getCantidad()%>" autocomplete="off" size="2">
                                         <a class="cart_quantity_down" href=""> - </a> 
                                    </div>
                                </td>
                                   <td hidden>Precio suma:$</td>
        <td class="cart_total"><p class="cart_total_price">$<%=Math.round(producto.getPrecio()*a.getCantidad()*100.0)/100.0%></p></td>
        <td hidden>ID:</td>
                                <td class="cart_delete">
                                    <span id="idarticulo" style="display: none"  ><%=producto.getId()%></span>
                                    <a class="cart_quantity_delete" href="" id="deleteitem"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%
                                }}
                            %>
                        </tbody>
                    </table>
                                                 <%
                        if (articulos == null){ %>
                        <h1>No seleccionaste un servicio</h1>
                      
                        <%  }
                       
%>
                </div>
                <p href="javascript:window.history.go(-2);" class="btn btn-default update" id="cance" >Cancelar</p>
                <a href="javascript:window.history.go(-2);" class="btn btn-default update" >Añadir más servicios</a>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="heading">
                    <h3>Si requieres más servicios haz clic en añadir más servicios</h3>
                    <p>Para finalizar da clic en descargar tu PDF.</p>
                </div>
                <div class="row">
 
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li name="mas" id="mas">Total final: <span  id="txt-total">$<%= Math.round(total*100.00)/100.00%></span></li>
                            </ul>
                            
                          
                              <a id="export2" class="btn btn-default update" href="">Descargar PDF</a>
                                   <div class="contenedor">
            <article>
                <button id="btn-abrir-popup" class="btn-abrir-popup">Recibir por correo</button>
            </article>
            <div  class="overlay" id="overlay">
                <div class="popup" id="popup">
                    <a href="#" id="btn-cerrar-popup" class="btn-cerrar-popup"><i class="fas fa-times"></i></a>
                    <h3>Ingresa tu correo</h3>
                    <h4>A esta dirección enviaremos tú PDF.</h4>
                    <form action="cart.jsp" method="post">
                    <div class="contenedor-inputs">
                    <input required type="text" name="para" placeholder="E-mail"/>
                    <input hidden value="jesus.of.999@gmail.com" type="text" name="de"/>
                    <input hidden value="J3suscordero" type="password" name="clave"/>
                    <input required type="text" name="asunto" placeholder="Nombre"/>
                    <input hidden value="Aqui esta el resumen de tu cotizacion de serviciós" name="mensaje" cols="40" rows="10"/>
                    
                    <input hidden value="2518360032jcorderot@gmail.com" type="text" name="para2" />
                    <input hidden value="jesus.of.999@gmail.com" type="text" name="de2"/>
                    <input hidden value="J3suscordero" type="password" name="clave2"/>
                    
                    <input hidden="" value="Se realizo una cotización de servicios" name="mensaje2" cols="40" rows="10"/>
                    
                    <br><br> 
                    <input name="assd" id="export2" class="btn-submit" type="submit" value="ENVIAR"/>
                    </div>
                    </form> 
                </div>
            </div>
        </div>
                                <%
            
            Email email = new Email();
            
            String de = request.getParameter("de");
            String clave = request.getParameter("clave");
            String para = request.getParameter("para");
            String mensaje = request.getParameter("mensaje");
            String asunto = request.getParameter("asunto");
            //String mas = request.getParameter("mas");
         
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            if(resultado){}else{}
            

          EmailAdmo a= new EmailAdmo(); 
            String de2 = request.getParameter("de2");
            String clave2 = request.getParameter("clave2");
            String para2 = request.getParameter("para2");
            String mensaje2 = request.getParameter("mensaje2");
            String asunto2 = request.getParameter("asunto");

            boolean resultado2 = a.enviarCorreo(de2, clave2, para2, mensaje2, asunto2);
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
        <script src="js/Carro1.js"></script> 
        
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
        <script src="js/PDF2.js"></script>
        
        <script src="js/popup.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="http://mrrio.github.io/jsPDF/dist/jspdf.min.js" type="text/javascript"></script>
        <script src="http://html2canvas.hertzen.com/build/html2canvas.js" type="text/javascript"></script> 
    </body>
</html>