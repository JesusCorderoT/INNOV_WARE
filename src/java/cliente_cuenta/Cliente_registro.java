/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_cuenta;

import conexion.Conexion;
import correo.Controlador;
import correo.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.UUID;
import javax.servlet.ServletConfig;
/**
 *
 * @author brandon
 */
@WebServlet(name = "Cliente_registro", urlPatterns = {"/Cliente_registro"})
public class Cliente_registro extends HttpServlet {
Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init(ServletConfig config)throws ServletException{
      super.init();
      conecta.Conectar();
      sentenciaSQL= conecta.getSenteciaSQL();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        

        try {
            String nombre=request.getParameter("nombre_usuario");
           String apellidos=request.getParameter("apellidos");
           String telefono=request.getParameter("telefono");
           String usuario_c=request.getParameter("usuario");
           String contrasena=request.getParameter("password_user");
           String genero=request.getParameter("sexo");
           String correo_electronico=request.getParameter("correo_electronico");
           String dominio=request.getParameter("dominio");
           String codigo = UUID.randomUUID().toString().toUpperCase().substring(0, 6);//codigo
           String es = "inactiva";
           int nivel=2;
           String envio="enviado";
           
           if(nombre=="" || apellidos=="" ||telefono=="" || usuario_c=="" || contrasena=="" || genero=="" ){
               out.println("no se aceptan campos vacios");
           }else if(usuario_c.length()>15 || usuario_c.length()<3){
            out.println("el usuario no puede ser menor a 3 caracteres o mayor a 15");
        }else if(nombre.length()>15){
            out.println("el nombre es demasiado largo");
        }else if(contrasena.length()<5){
            out.println("tu contraseña es muy corta");
        }else if(telefono.length()<10){
            out.println("ingresa un telefono valido");
        }else{
                 Correo c = new Correo();
            c.setContrasena("zakisnvlcjukapwi");
            c.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
            c.setDestino(correo_electronico + dominio);
            c.setAsunto("Verificación de cuenta ");
            c.setMensaje("Este es el código de activación para la verficación de cuenta: " + "\n" + codigo + "\n");
            Controlador co = new Controlador();
            co.enviarcorreo(c);
            
            
              String strComando = "insert into usuario(nombre, apellidos, telefono, usuario, contrasena, genero, correo_electronico, codigo_verificacion, nivel, estado,correo_enviado) values('"+nombre+"','"+apellidos+"', '"+telefono+"', '"+usuario_c+"', '"+contrasena+"','"+genero+"','"+correo_electronico + dominio+"','"+codigo+"',"+nivel+",'"+es+"','"+envio+"');";  
             
            int cdr = sentenciaSQL.executeUpdate(strComando);
            
            
            
            
          if(cdr==1){
                  
                  out.println(" <script type=\"text/javascript\" src=\"cuenta_administrador.js\"> </script>");
               out.println("<h2>La cuenta se ha registrado</h2>");
               out.println("<label>por favor verifica tu cuenta con el codigo que hemos enviado a tu correo</label>");
               out.println("<br><br>");
               out.println("<input type=\"button\" value=\"verificar\" onclick=\"mostrar_formulario_verificacion_c()\">");
           }else{
              out.println("no se ha podido verificar la cuenta");
          }
            
        }
           
           
          
           
           
          
           
          
            
            

            
         
           
            
    }catch(SQLException e){
        out.println("error sql"+e);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
