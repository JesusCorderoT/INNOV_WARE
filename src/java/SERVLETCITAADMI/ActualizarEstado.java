/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETCITAADMI;

import conexionCarlos.Conexion;
import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos toto
 */
@WebServlet(name = "ActualizarEstado", urlPatterns = {"/ActualizarEstado"})
public class ActualizarEstado extends HttpServlet {
ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
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
       /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarEstado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarEstado at " + request.getContextPath() + "</h1>");
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
        boolean cance=false;
        try {
            if(estado.equalsIgnoreCase("cancelar")){
            cance=true;
        }else{
                cance=false;
            }
            if(cance==true){
                 out.println("<h3>Ingresa un pequeña descripción del motivo por el cual desea cancelar la cita</h3>");
                 out.println("<textarea id=\"asunto1\" name=\"asunto1\" rows=\"5\" cols=\"40\" required></textarea><br>");
             out.println("<input type=\"submit\" id=\"enviar\" name=\"enviar\" onclick=\"CancelarCitaADmi()\" value=\"CANCELAR\"><br>");
            }else{
                String comando="Update agenda set estado='"+estado+"' where folio='"+folio+"';";
            if(sentenciaSQL.executeUpdate(comando)==1){
                out.println("Se actualizo el estado de la cita correctamente.");
            }else{
                out.println("Hubo un error al actualizar el estado.");
            }
            }
            
        } catch (SQLException e) {
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
