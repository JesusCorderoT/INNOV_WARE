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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Darkam
 */
@WebServlet(name = "Form_Editar_Descripcion", urlPatterns = {"/Form_Editar_Descripcion"})

public class Form_Editar_Descripcion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        /* try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form_Editar_Descripcion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Form_Editar_Descripcion at " + request.getContextPath() + "</h1>");
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
        String id_producto = request.getParameter("id_producto");
        String comando = "Select * from productos where id_producto = " + id_producto + " ";

        try {
            cdr = sentenciaSQL.executeQuery(comando);

            while (cdr.next()) {
                out.println("<p> Descripcion actual: <br> <textarea name=\"descripcionantigua\" id=\"descripcionantigua\" readonly=\"\">" + cdr.getString(3) + "</textarea> </p>");
                out.println("<br>");
            }
            out.println("<input type=\"text\" id=\"id_Pro1\" value=\""+id_producto+"\">");
            out.println("<p> Descripcion nueva: <br> <textarea name=\"descripcionActual\" id=\"descripcionActual\"></textarea> </p>");
            out.println("<input type=\"button\" name=\"editarDesc\" id=\"editarDesc\" value=\"Guardar Descripcion\" onclick=\"editarDescripcionFinal();\">");
            out.println("<div id=\"RespuestaEditarDesc\">  </div>");
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
