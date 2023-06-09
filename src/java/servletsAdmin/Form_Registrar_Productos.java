/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAdmin;

import conexionJorge.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darkam
 */
public class Form_Registrar_Productos extends HttpServlet {

    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form_Registrar_Productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Form_Registrar_Productos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<fieldset>");
            out.println("<legend><h2>Registrar un producto</h2></legend>");
            out.println("<p> Nombre del nuevo producto zzzzzz </p>");
            out.println("<input type=\"text\" name=\"nombreProducto\" id=\"nombreProducto\" >");
            out.println("<p> Costo: </p>");
            out.println("<input type=\"text\" name=\"costo\" id=\"costo\" >");
            out.println("<p> Imágen del producto: </p>");
            out.println("<input type=\"file\" name=\"imagen\" id=\"imagen\" >");
            out.println("<p> Descripción: </p>");
            out.println("<textarea name=\"descripcion\" rows=\"5\" cols=\"40\" id=\"descripcion\"></textarea><br>");
            out.println("<br><br>");
            out.println("<input type=\"button\" name=\"registrarProducto\" id=\"registrarProducto\" value=\"Registrar producto\" onclick=\"registrarProducto();\">");

            out.println(" <p id=\"RespuestaRegistrarProducto\"></p>");

            out.println("</fieldset>");

            out.println("");
            out.println("");
            out.println("");

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
