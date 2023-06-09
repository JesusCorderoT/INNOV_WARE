/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsUser;

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
 * @author Darkam
 */
@WebServlet(name = "Form_Agregar_Lista_Pendiente", urlPatterns = {"/Form_Agregar_Lista_Pendiente"})

public class Form_Agregar_Lista_Pendiente extends HttpServlet {

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
            out.println("<title>Servlet Form_Agregar_Lista_Pendiente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Form_Agregar_Lista_Pendiente at " + request.getContextPath() + "</h1>");
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

        String descripcion = request.getParameter("descripcion");
        String id_user = request.getParameter("id_user");
        String costo = request.getParameter("costo");
        String nombre_producto = request.getParameter("nombre_producto");

        String desc = " " + id_user + ", " + nombre_producto + ", " + descripcion + ", " + costo + " ";

       

        String comando1 = "Select nombre_producto, costo from productos where id_producto= "+id_user+"";

        try {
            cdr = sentenciaSQL.executeQuery(comando1);
            out.println("<p>Id producto: <input type=\"text\" name=\"id_producto\" id=\"id_producto\" value=\"" + id_user + "\" readonly=\"\"></p>");
            while (cdr.next()) {
                out.println("<p>Nombre del producto: <input type=\"text\" name=\"nombre_producto\" id=\"nombre_producto\" value=\""+cdr.getString(1)+"\" ></p>");
                out.println("<p>Costo: <input type=\"text\" name=\"costo\" id=\"costo\" value=\""+cdr.getString(2)+"\" ></p>");
            }

            out.println("<p>Ingrese su Id de usuario :v: <input type=\"text\" name=\"iduser\" id=\"iduser\"></p>");
            out.println("<input type=\"button\" name=\"agregarPendiente\" id=\"agregarPendiente\" value=\"Agreagr a lista 'Pendiente'\" onclick=\"añadirListaPendiente();\">");
            out.println("<div id=\"RespuestaListaPendiente\"> </div>");

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
