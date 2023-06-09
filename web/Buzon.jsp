<%-- 
    Document   : Buzon
    Created on : 28/11/2019, 12:59:23 PM
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sugerencias</title>
        <script type="text/javascript" src="buzon.js"></script>
       <link href="images/INNOV_1.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/mainLogin.css">
  <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
            <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <center>
        <h1>Enviar correo con sugerencia</h1>
        </center>
        <input type="text" value="" id="correo" placeholder="Email" maxlength="40" required >
        <br>
        <br>
        <input type="text" value="" id="nombre_usuario" placeholder="Nombre de usuario" maxlength="15" required >
        <br>
        <br>
        <textarea id="asunto"></textarea>
        <br>
        <br>
        <center>
        <input style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" type="submit" onclick="enviar_buz()" value="  Enviar  ">
        <br>
        <br>
           <a href="Menu_Cliente.jsp"><input type="button" style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" value="  Volver  "></a>
        <div id="div_buz">
            
            
        </div>
           </center>
        </div>
                </div>
                </div>
        
        <br>
        <br>
     
    </body>
</html>
