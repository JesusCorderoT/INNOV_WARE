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
 * @author Lab-CB08
 */
@WebServlet(name = "Filtros", urlPatterns = {"/Filtros"})
public class Filtros extends HttpServlet {
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
       /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Filtros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Filtros at " + request.getContextPath() + "</h1>");
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
        out.println("<h2>Consulta de citas</h2>");
        out.println("Ingresa una fecha:<input type=\"date\" id=\"fecha\" name=\"fecha\"><input type=\"button\" id=\"boton\" value=Filtrar name=\"filtro\" onclick=\"fltrofecha()\"><br>");
        out.println("Ingresa un nombre del cliente:<input type=\"text\" id=\"cliente\" name=\"cliente\"><input type=\"button\" id=\"filtra\" value=Filtrar name=\"filtra\" onclick=\"fltronombre()\"><br>");
        out.println("Ingresa el nombre de una empresa:<input type=\"text\" id=\"empresa\" name=\"empresa\"><input type=\"button\" id=\"fil\" value=Filtrar name=\"fil\" onclick=\"fltroNombreE()\"><br>");
        out.println("<p id=tabla></p>");
         out.println("<p id=Estado></p>");
         out.println("<p id=RespuestaEstado></p>");
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
