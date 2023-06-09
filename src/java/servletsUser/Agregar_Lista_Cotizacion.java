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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Agregar_Lista_Cotizacion", urlPatterns = {"/Agregar_Lista_Cotizacion"})
public class Agregar_Lista_Cotizacion extends HttpServlet {

    ResultSet cdr = null;
    ResultSet cdr1 = null;
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
            out.println("<title>Servlet GenerarGarantiaBD</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GenerarGarantiaBD at " + request.getContextPath() + "</h1>");
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

        ///////////////////////////////

        /*Datos del productopara la descripcion*/
        String id_producto = request.getParameter("id_producto");

        String strComando11 = "Select * from productos where id_producto = " + id_producto + "";

        try {
            cdr = sentenciaSQL.executeQuery(strComando11);
            while (cdr.next()) {

                String nombre = cdr.getString(2);
                String descripcion = cdr.getString(3);
                String costo = cdr.getString(4);

                String descripcion_productos = "ID del producto: " + id_producto + " \n Nombre del producto: " + nombre + " \n Descripción: " + descripcion + ""
                        + " \n Costo: " + costo + " ";

                /*Insert a la tabla*/
                String id_usuario = request.getParameter("id_usuario");
                String total_cotizacion = request.getParameter("total_cotizacion");

                Calendar c1 = Calendar.getInstance();
                Calendar c2 = new GregorianCalendar();

                String dia = Integer.toString(c1.get(Calendar.DATE));
                String mes = Integer.toString(c1.get(Calendar.MONTH));
                String annio = Integer.toString(c1.get(Calendar.YEAR));

                String fecha = annio+ "/" + mes +"/" + dia;

                try {
                    out.println("<p>Id producto: <input type=\"text\" name=\"id_produ\" id=\"id_produ\" value=\"" + id_producto + "\"  ></p>\n");
                    out.println("<p>descricpion cotizacion: <input type=\"text\" name=\"descripcionCoti\" id=\"descripcionCoti\" value=\"" + descripcion_productos + "\"  ></p>\n");
                    out.println("<p>totalCoti: <input type=\"text\" name=\"totalCoti\" id=\"totalCoti\" value=\"" + costo + "\"  ></p>\n");
                    out.println("<p>fecha: <input type=\"text\" name=\"fecha\" id=\"fecha\" value=\"" + fecha + "\"  ></p>\n");

                    out.println("<p>Ingres su ID de cliente: <input type=\"text\" name=\"id_cliente\" id=\"id_cliente\" value=\"\" ></p>");
                    out.println("<input type=\"button\" name=\"Agregar_A_CotizacionB\" id=\"Agregar_A_CotizacionB\" value=\"Agregar a cotizacion\" onclick=\"RegistrarCotizacion();\">\n");
                    out.println("");

                } catch (Exception e) {
                }

                out.println("<p id=\"AnswerCotizacionBD\"> </p>");

            }
        } catch (SQLException ex) {
            out.println(ex);
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
