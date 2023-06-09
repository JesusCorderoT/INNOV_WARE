/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noticias.buscar_por_titulo;

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
@WebServlet(name = "Resultado_de_busqueda", urlPatterns = {"/Resultado_de_busqueda"})
public class Resultado_de_busqueda extends HttpServlet {
ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
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
            String titulo_noticia=request.getParameter("titulo_noticia");
            
             String strComando = "SELECT * FROM boletin WHERE titulo_noticia='"+titulo_noticia+"';";
                cdr = sentenciaSQL.executeQuery(strComando);

               
out.println("<h1>Resultado de busqueda</h1>");
                out.println("<table width=100% border=1>");

                out.println("<tr>");

                out.println(" <th>titulo_noticia</th>  <th>descripcion_noticia</th> <th>autor</th> <th>fecha</th>");

                out.println("</tr>");

                while (cdr.next()) {
                    out.println("<tr>");
                    out.println("<td width=10% >" + cdr.getString("titulo_noticia") + "</td>");
                    out.println("<td width=40% >" + cdr.getString("descripcion_noticia") + "</td>");
                    out.println("<td width=20% >" + cdr.getString("autor") + "</td>");
                    out.println("<td width=10% >" + cdr.getString("fecha") + "</td>");
                    
                    out.println("</tr>");
                }

                out.println("</table>");

                
                out.println("</body></html>");

            
        } catch (SQLException e) {
            out.println("error sql:"+e);
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
