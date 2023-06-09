<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        
          <link href="images/INNOV_1.png" rel="icon">

        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/mainLogin.css">
                
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <!--<link href="css/main.css" rel="stylesheet"> -->
        <link href="css/responsive.css" rel="stylesheet">     
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        
        
        <script type="text/javascript" src="otro_cuenta.js"></script>
        <script type="text/javascript" src="cliente.js"></script>
        <script type="text/javascript" src="sesion.js"></script>
        <script type="text/javascript" src="Cuentas_de_cliente.js"> </script>
    </head>
    <body>

         <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
     
          <form action="Login_sesion" method="POST" id="formInicio" >
             <center><h1>Iniciar sesión.</h1></center>
              
                    
                    
            <p style="text-align: center">Ingresa tu nombre de usuario</p>   
            <input style="align-content: center" autofocus placeholder="Usuario" type="text" name="usuario"  id="txtemail" required> 
            <br>
            <br>
                    
                    <p style="text-align: center">Ingresa tu contraseña</p>  
            <input style="align-content: center" autofocus placeholder="Contraseña" type="password" name="password" id="pass" required >
            <br>
            <br>
          <center>  
              <input style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" class="btn btn-default update" type="submit" value="Iniciar sesión" id="iniciar" name="ingresar"><br><br>
            
        </center>
            
            <br>
        </form>
     
        <br>
        <br>
        <div id="mensajes_inicio"  style="text-align: center">
        </div>
       
        <center>
        <div id="crear_cuenta_cliente" >
            <center>
            <label>¿No tienes cuenta?</label>
            </center>
            <br>
            <div>
                <a style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" class="btn btn-default update" onclick="mostrarFormulario_c()" >Crear cuenta</a><br><br>
                <a style="background: linear-gradient(45deg, violet, rgba(29, 200, 205, 0.8));;" class="btn btn-default update" href="index.html">Regresar al inicio</a>    
            </div>
            <br>
            <div id="formulario_registro_cliente">
            </div>
            <br>
            <br>
            <div id="cliente_mensajes"></div>
            <br>
            <br>
            <div id="funciones_cuenta"></div>
            <br>
            <div id="mensajes_cuenta"></div>
            
            
            <br>
           
        </div>
        </center>
                   
                </div>
            </div>
        </div>
     
           <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <script src="js/mainLogin.js"></script>
    </body>
</html>
