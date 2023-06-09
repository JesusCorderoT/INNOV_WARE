
<%@page import="SERVICIOSJCT.EmailAdmo"%>
<%@page import="SERVICIOSJCT.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULTADO CORREO ELECTRONICO</title>
    </head>
    <body>
    
        <%
            
            Email email = new Email();
            
            String de = request.getParameter("de");
            String clave = request.getParameter("clave");
            String para = request.getParameter("para");
            String mensaje = request.getParameter("mensaje");
            String asunto = request.getParameter("asunto");
   
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            
            if(resultado){
                
            }else{
                
            }
            
            EmailAdmo a= new EmailAdmo(); 
             String de2 = request.getParameter("de2");
            String clave2 = request.getParameter("clave2");
            String para2 = request.getParameter("para2");
            String mensaje2 = request.getParameter("mensaje2");
            String asunto2 = request.getParameter("asunto2");

   boolean resultado2 = email.enviarCorreo(de2, clave2, para2, mensaje2, asunto2);
            
            if(resultado2){
               
            }else{
              
            }

            
        %>

    </body>
</html>
       