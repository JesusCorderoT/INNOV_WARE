/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eliminar_cuenta_cliente;

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
@WebServlet(name = "Elimina_cliente", urlPatterns = {"/Elimina_cliente"})
public class Elimina_cliente extends HttpServlet {
//ResultSet cdr = null;
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
            String usuario=request.getParameter("usuario");
            String contrasena=request.getParameter("contrasena");
            String verificar=request.getParameter("verificar");
            String val=request.getParameter("val");
            
            String validado = "si";
            
               
            
               if(!contrasena.equals(verificar)){
                   out.println("la confirmacion del password es diferente, por favor verifica que coincidan");
               }else if(contrasena.equals(verificar) && val.equals(validado)){
                   String strComando = "DELETE FROM usuario WHERE usuario='"+usuario+"' and contrasena='"+contrasena+"';";
               int cdr = sentenciaSQL.executeUpdate(strComando);
               out.println("se ha eliminado correctamente");
               response.sendRedirect("index.html");
               }else if(!val.equals(validado)){
                   out.println("Se ha cancelado la eliminacion.");
                   
               }else{
                   out.println("Error, verifica los datos.");
               }
               
          
        } catch (SQLException e) {
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
