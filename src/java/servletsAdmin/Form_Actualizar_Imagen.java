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
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "Form_Actualizar_Imagen", urlPatterns = {"/Form_Actualizar_Imagen"})
public class Form_Actualizar_Imagen extends HttpServlet {
    
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();

    @Override
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
        response.setContentType("text/html;charset=UTF-8");
       /* try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form_Actualizar_Imagen</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Form_Actualizar_Imagen at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id = request.getParameter("id_producto");

        String comando = "Select imagen_producto from productos where id_producto= " + id + ";";
        out.println("<p><input type=\"text\" name=\"id_producto\" id=\"id_producto\" readonly=\"\" value=\" " + id + "\"></p>");
        try {

            cdr = sentenciaSQL.executeQuery(comando);

            while (cdr.next()) {
                out.println("<p> Imagen anterior: <input type=\"text\" name=\"imagenAnterior\" id=\"imagenAnterior\" readonly=\"\" value=\"" + cdr.getString("imagen_producto") + "\"></p>");
            }

            out.println("<p>Selecciona una imagen para actualizar: <input type=\"file\" name=\"imagen\" id=\"imagen\"></p>");
            out.println("<p><input type=\"button\" name=\"actualizarImagen\" id=\"actualizarImagen\" value=\"Actualizar imagen\" onclick=\"actualizarImagen();\"></p>");

            out.println("");

        } catch (SQLException e) {
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
