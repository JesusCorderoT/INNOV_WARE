/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletConfig;
/**
 *
 * @author brandon
 */
@WebServlet(name = "Formulario_noticia", urlPatterns = {"/Formulario_noticia"})
public class Formulario_noticia extends HttpServlet {
Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
      ResultSet cdr = null;
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
            out.println(" <script type=\"text/javascript\" src=\"Noticia_Administrador.js\"> </script>");
            
            out.println("<h3>Crea Noticia</h3>");
            out.println("<br>");
            out.println(" <input placeholder=\"Titulo\" type=\"text\" id='titulo_noticia'  required maxlength=\"20\">");
            out.println("<br><br>");
            out.println(" <textarea placeholder=\"Descripcion\" id='descripcion_noticia'  required maxlength=\"200\"></textarea>");
            out.println("<br><br>");
            out.println("<input placeholder=\"Autor\" type=\"text\" id='autor'  required maxlength=\"10\">");
            out.println("<br><br>");
            out.println("<input placeholder=\"Fecha\" type=\"date\" id='fecha'  required maxlength=\"10\">");
            out.println("<br><br>");
            out.println("<input type=\"button\" id=\"botonR\" value=\"REGISTRAR\" onclick=\"mostrar_registro_noticia()\" >");
        } catch (Exception e) {
            out.println(e);
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
