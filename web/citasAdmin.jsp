<%-- 
CITAS ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas Administrador</title>
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
    </head>
    <body>
         <script type="text/javascript" src="script2.js"></script>
     
         
         <table>
        
            <table width="100%" border="1">
                <td width="20%" align="center"><a href="Menu_Administrador.jsp">MENU</a></td>
                <td width="20%" align="center" onclick="FormFiltros()"><a href="#menuC" onclick="DinamicoDiv('consuadmi');">CONSULTAR CITA</a></td>
                
            </table>
             <section id="menuC">
             <table width="100%" border="1">
            <tr width="100%">
                <td colspan="5">
                    <center>
                          <div class="limiter">
                            <div class="container-login100">
                                <div class="wrap-login100">
                     <div id="inicio"><h3>BIENVENIDO</h3></div>
                      <div id="consuadmi" style="display: none">
                          <p id="admimaque"></p>
                      </div>
                     </div>
                                </div>
                              </div>
                     </center>
                </td>
            </tr>
       
        </table>
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
            <a href="#intro" class="scrollto">Inicio</a>
            <a href="#about" class="scrollto">Nosotros</a>

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
