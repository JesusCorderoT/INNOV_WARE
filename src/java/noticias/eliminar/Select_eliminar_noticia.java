/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noticias.eliminar;

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
@WebServlet(name = "Select_eliminar_noticia", urlPatterns = {"/Select_eliminar_noticia"})
public class Select_eliminar_noticia extends HttpServlet {
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
          
           
       
            String strComando = "SELECT * FROM boletin";
            cdr = sentenciaSQL.executeQuery(strComando);

            out.println(" <script type=\"text/javascript\" src=\"Noticia_Administrador.js\" ></script>");

            
            
            out.println("<label> Selecciona la noticia que desea eliminar</label>");
            out.println("<select id='select'  onchange=\"mostrar_radios_eliminar_noticia()\" >");
            out.println("<option>selecciona</option>");
            while (cdr.next()) {
                out.println("<option value='" + cdr.getString("titulo_noticia") + "'>" + cdr.getString("titulo_noticia") + "</option>");
            }

            out.println("</select>");

            out.println("<br><br>");

            
            
            
             
        } catch (SQLException e) {
            out.println("error al cargar las noticias");
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
