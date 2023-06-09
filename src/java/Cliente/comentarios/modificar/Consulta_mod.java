/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.comentarios.modificar;

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
@WebServlet(name = "Consulta_mod", urlPatterns = {"/Consulta_mod"})
public class Consulta_mod extends HttpServlet {
ResultSet cdr = null;
ResultSet cd=null;
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
                out.println("<script type=\"text/javascript\" src=\"Cliente_comentario.js\"></script>");
                 
             String contrasena=request.getParameter("contrasena");
             String usuario=request.getParameter("usuario");
                
               
               
                
                String strcomando2="select comentario.usuario, descripcion_noticia, fecha from comentario inner join usuario on usuario.usuario=comentario.usuario where usuario.usuario='"+usuario+"' and contrasena='"+contrasena+"'; ";
                
                cd=sentenciaSQL.executeQuery(strcomando2);
                
                while(cd.next()){
                    out.println("<h1>su comentario es:</h1>");
                   out.println("<br><br>");
                    out.println("<input type=text value='"+cd.getString("comentario.usuario")+"' id='usuario' readonly>");
                    out.println("<br><br>");
                    out.println("<input type=text value='"+cd.getString("descripcion_noticia")+"' id='descripcion_noticia'>");
                    out.println("<br><br>");
                    out.println("<input type=date value='"+cd.getString("fecha")+"' id='fecha'>");
                    out.println("<br><br>");
                    out.println("<input type=button value='modificar' onclick='actualiza();'>   <input type=button value='eliminar' onclick='radios_comen();' id='boton'>");

                }

                
            }catch(SQLException e){
                out.println("error sql: "+e);
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
