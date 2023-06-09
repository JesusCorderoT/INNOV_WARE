/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETSCITACLIENTE;

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
@WebServlet(name = "AGENDARCITA", urlPatterns = {"/AGENDARCITA"})
public class AGENDARCITA extends HttpServlet {
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
            out.println("<title>Servlet AGENDARCITA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AGENDARCITA at " + request.getContextPath() + "</h1>");
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
        
        out.println("Nombre:<input type=\"text\" id=\"nombre\" name=\"nombre\" required><br>");
        out.println("Apellidos:<input type=\"text\" id=\"apellidos\" name=\"apellidos\" required><br>");
        out.println("Nombre empresa:<input type=\"text\" id=\"empresa\" name=\"empresa\"><br>asunto:");
        out.println("<textarea id=\"asunto\" name=\"asunto\" rows=\"5\" cols=\"40\" required></textarea><br>");
        out.println("fecha:<input type=\"date\" id=\"fecha\" name=\"fecha\" required><br>");
        out.println("hora:<input type=\"time\" id=\"hora\" name=\"hora\" required><br>");
        out.println("<input type=\"submit\" id=\"enviar\" name=\"enviar\" onclick=\"MensajeConf()\" value=\"REGISTRARSE\"><br>");
        
        out.println("<p id=mensajeco><p>");
        out.println("<p id=respuestaagenda><p>");
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
