/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas_administrador;

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
@WebServlet(name = "VerificarCuenta", urlPatterns = {"/VerificarCuenta"})
public class VerificarCuenta extends HttpServlet {
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        

        try {
            String usuario=request.getParameter("usuario");
            String codigo=request.getParameter("codigo");
            
            
               
            String estado="activada";
            String correo="recibido";
        if(codigo.length()<6){
                out.println("el codigo debe ser de solo 6 digitos");
            }else{
            String strComando = "UPDATE usuario SET estado='"+estado+"',correo_enviado ='"+correo+"'  Where usuario='"+usuario+"' and codigo_verificacion='"+ codigo+"';";  
             
            int cdr = sentenciaSQL.executeUpdate(strComando);
            
        
if(cdr==1 ){
    out.println("<h1>la cuenta se ha activado</h1>");
  //  out.println("<a href=\"Login.jsp\"><h3>iniciar sesion</h3></a>");
}else{
    out.println("<h1>codigo o usuario incorrecto</h1>");

}
           
        }
            
             
        
            
        
        
        
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
    
     public void init(ServletConfig config)throws ServletException{
      super.init();
      conecta.Conectar();
      sentenciaSQL= conecta.getSenteciaSQL();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
       
        
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
