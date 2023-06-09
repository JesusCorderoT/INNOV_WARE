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
 * @author Darkam
 */
@WebServlet(name = "Mas_Opciones", urlPatterns = {"/Mas_Opciones"})

public class Mas_Opciones extends HttpServlet {

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
        /*try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mas_Opciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Mas_Opciones at " + request.getContextPath() + "</h1>");
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
        try {
            String strComando = "Select * from productos where id_producto=" + id_producto + ";";
            cdr = sentenciaSQL.executeQuery(strComando);

            out.println("<table width=100% border=1>");
            out.println("<tr>");

            out.println("<th>ID Producto</th> <th>Producto</th> <th>Descripci&oacute;n</th> <th>Costo</th> <th>Imagen</th> <th>Disponible</th> <th>********</th> <th>Descripcion</th> <th>Imágen</th> <th>Disponibilidad</th>");
            out.println("</tr>");
            while (cdr.next()) {

                out.println("<tr>");
                out.println("<td width=10%>" + cdr.getInt(1) + "</td>");
                out.println("<td width=40%>" + cdr.getString(2) + "</td>");
                out.println("<td width=20%>" + cdr.getString(3) + "</td>");
                out.println("<td width=10%>" + cdr.getString(4) + "</td>");
                out.println("<td width=10%>" + cdr.getString(6) + "</td>");
                out.println("<td width=10%>" + cdr.getString(7) + "</td>");
                out.println("<td width=10%></td>");
                out.println("<td width=10%>"
                        + "<input type=\"button\" name=\"AgregarDescripcion\" id=\"AgregarDescripcion\" value=\"Agregar nueva descripcion\" onclick=\"formRegistrarProducto2(" + cdr.getString(1) + ");\">"
                        + "<input type=\"button\" name=\"EditarDescripcion\" id=\"EditarDescripcion\" value=\"Editar descripcion\" onclick=\"editarDescripcion(" + cdr.getString(1) + ");\">"
                        + "<input type=\"button\" name=\"EliminarDescripcion\" id=\"EliminarDescripcion\" value=\"Eliminar descripcion\" onclick=\"eliminarDescripcion(" + cdr.getString(1) + ");\">"
                        + "</td>");

                out.println("<td width=10%>"
                        + "<input type=\"button\" name=\"AgregarImagen\" id=\"AgregarImagen\" value=\"Agregar nueva Imágen\" onclick=\"formAgregarImagen1(" + cdr.getString(1) + ");\">"
                        + "<input type=\"button\" name=\"ActualizarImagen\" id=\"ActualizarImagen\" value=\"Actualizar Imágen\" onclick=\"formActualizarImagen(" + cdr.getString(1) + ");\">"
                        + "<input type=\"button\" name=\"EliminarImagen\" id=\"EliminarImagen\" value=\"Eliminar Imágen\" onclick=\"eliminarImagenProducto(" + cdr.getString(1) + ");\">"
                        + "</td>");

                out.println("<td width=10%>"
                        + "<input type=\"button\" name=\"existe\" id=\"existe\" value=\"En existencia\" onclick=\"ProductoDisponible(" + cdr.getString(1) + ");\">"
                        + "<input type=\"button\" name=\"no_existe\" id=\"no_existe\" value=\"Sin existencia\" onclick=\"ProductoNoDisponible(" + cdr.getString(1) + ");\">"
                        + "</td>");
            }
            out.println("</table>");
            out.println("<p id=\"RespuestMasOpcionesServlet\"> </p>");
        } catch (SQLException e) {
            out.println("Excepcion SQL: " + e.getMessage());
        } catch (NullPointerException e) {
            out.println("Apuntando SQL: " + e.getMessage());
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
