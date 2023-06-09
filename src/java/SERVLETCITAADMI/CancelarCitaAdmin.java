/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETCITAADMI;

import java.sql.*;
import conexionCarlos.Conexion;
import correo.Controlador;
import correo.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos toto
 */
@WebServlet(name = "CancelarCitaAdmin", urlPatterns = {"/CancelarCitaAdmin"})
public class CancelarCitaAdmin extends HttpServlet {
ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta = new Conexion();
    public void init(ServletConfig config)throws ServletException{
       super.init(config);
       conecta.Conectar();
       sentenciaSQL=conecta.getSentenciaSQL();
   }
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
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CancelarCitaAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelarCitaAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }*/
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String estado=request.getParameter("estado");
        String folio=request.getParameter("folio");
        String asunto=request.getParameter("asunto");
         String nombre=request.getParameter("nombre");
        String correo=null;
        try {
            String comando1 = "select correo_electronico from usuario where nombre like '%" + nombre + "%';";
               String comando="Update agenda set estado='cancelada' , asunto='"+asunto+"' where folio='"+folio+"';";
            if(sentenciaSQL.executeUpdate(comando)==1){
                
                out.println("Se actualizo el estado de la cita correctamente.<br>");
                 cdr = sentenciaSQL.executeQuery(comando1);
                    while (cdr.next()) {
                        correo = cdr.getString(1);
                    }
                 Correo c = new Correo();
                        c.setContrasena("zakisnvlcjukapwi");
                        c.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
                        c.setDestino(correo);
                        c.setAsunto("INNOV&WARE CANCELO SU CITA");
                        c.setMensaje("cliente:" + nombre + "\n" + "asunto por el cual se cancelo la cita: " + asunto + "\n");
                        Controlador co = new Controlador();
                        if (co.enviarcorreo(c)) {
                            out.println("El correo se envio exitosamente<br>");
                        } else {
                            out.println("falla al enviar el correo<br>");
                        }
            }else{
                out.println("Hubo un error al actualizar el estado.");
            }
        } catch (Exception e) {
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
