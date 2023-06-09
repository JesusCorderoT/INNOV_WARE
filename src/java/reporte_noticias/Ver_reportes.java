/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte_noticias;

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
@WebServlet(name = "Ver_reportes", urlPatterns = {"/Ver_reportes"})
public class Ver_reportes extends HttpServlet {
Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    ResultSet cdr=null;
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
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.Conectar();
        sentenciaSQL = conecta.getSenteciaSQL();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

            try {
                String strComando = "SELECT * FROM reporte";
                cdr = sentenciaSQL.executeQuery(strComando);

               
out.println("<h1>Reportes de Noticias</h1>");
                out.println("<table width=100% border=1>");

                out.println("<tr>");

                out.println(" <th>id_reporte</th>  <th>usuario</th> <th>descripccion_reporte</th> <th>titulo_noticia</th>");

                out.println("</tr>");

                while (cdr.next()) {
                    out.println("<tr>");
                    out.println("<td width=10% >" + cdr.getString("id_reporte") + "</td>");
                    out.println("<td width=40% >" + cdr.getString("usuario") + "</td>");
                    out.println("<td width=20% >" + cdr.getString("descripccion_reporte") + "</td>");
                    out.println("<td width=10% >" + cdr.getString("titulo_noticia") + "</td>");
                    
                    out.println("</tr>");
                }

                out.println("</table>");

                
                out.println("</body></html>");

            } catch (SQLException e) {
                out.println("EXCEPCION SQL: " + e.getMessage());
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
