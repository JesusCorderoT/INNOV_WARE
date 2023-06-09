/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas_administrador.password;

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
@WebServlet(name = "Cambiar_password", urlPatterns = {"/Cambiar_password"})
public class Cambiar_password extends HttpServlet {
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
            String usuario =request.getParameter("usuario");
            String password =request.getParameter("password");
            String nuevo_password =request.getParameter("nuevo_password");
            String confirmacion =request.getParameter("confirmacion");
            
            
            
                if(password.equals(nuevo_password)){
                    out.println("el password no puede ser igual que el anterior");
                }else if(nuevo_password.length()<5){
                    out.println("la contraseña no puede tener menos de 5 digitos");
                    }else if(!nuevo_password.equals(confirmacion)){
                     out.println("la confirmacion no es igual que su password nuevo");
                    
                }else if(!password.equals(nuevo_password) && nuevo_password.equals(confirmacion)){
                     String strComando = "UPDATE usuario SET contrasena='"+nuevo_password+"' where usuario='" + usuario + "' and contrasena='"+password+"'";
                 int cdr = sentenciaSQL.executeUpdate(strComando);
                    out.println("se ha modificado su password");
                }else  {
                    out.println("error al modificar");
                }
                
          
        } catch (SQLException e) {
            out.println(" ERROR SQL:"+e);
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
