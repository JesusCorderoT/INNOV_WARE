/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas_administrador.buscar_usuarios;

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
@WebServlet(name = "Resultado_busqueda_usuarios", urlPatterns = {"/Resultado_busqueda_usuarios"})
public class Resultado_busqueda_usuarios extends HttpServlet {
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
              out.println("<script type=\"text/javascript\" src=\"otro_cuenta.js\"> </script>");
             String usuario=request.getParameter("usuario");
             
             String strComando = "SELECT * FROM usuario WHERE usuario='"+usuario+"';";
                cdr = sentenciaSQL.executeQuery(strComando);
                
                while(cdr.next()){
                    out.println("<table border='2'>");
                    
                    out.println("<tr>");
                    
                    out.println(" <th>id_usuario  <input type=hidden id='usuario_e' value='"+cdr.getString("usuario")+"'> </th>");
                    out.println("<th>nombre</th>");
                    out.println("<th>apellidos</th>");
                    out.println("<th>telefono</th>");
                    out.println("<th>usuario   </th>");
                    out.println("<th>genero</th>");
                    out.println("<th>correo_electronico</th>");
                    out.println("<th>estado</th>");
                    
                    
                    
                    out.println("<tr>");
                    
                    
                    
                    
                    
                    
                    
                    out.println("<tr>");
                    out.println("<td>"+cdr.getString("id_usuario")+"</td>");
                    out.println("<td>"+cdr.getString("nombre")+"</td>");
                    out.println("<td>"+cdr.getString("apellidos")+"</td>");
                    out.println("<td>"+cdr.getString("telefono")+"</td>");
                    out.println("<td>"+cdr.getString("usuario")+"</td>");
                    out.println("<td>"+cdr.getString("genero")+"</td>");
                    out.println("<td>"+cdr.getString("correo_electronico")+"</td>");
                    out.println("<td>"+cdr.getString("estado")+"</td>");
                    
                    out.println("</tr> ");
                    out.println("<tr>");
                    out.println("<td> <input type=\"button\" value=\"Eliminar cuenta\" onclick=\"radio_elimina()\"></td>");
                    out.println("</tr>");
                    out.println("</table>");
                    
                    
                    
                    
                    
                    
                   
                   
                }
                
                
        } catch (SQLException e) {
            out.println("error sql"+e);
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
