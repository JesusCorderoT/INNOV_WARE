/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas_administrador.modificar;

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
@WebServlet(name = "Form_recibe", urlPatterns = {"/Form_recibe"})
public class Form_recibe extends HttpServlet {
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
       PrintWriter out=response.getWriter();
        try {
            String usuario=request.getParameter("usuario");
            String contrasena=request.getParameter("contrasena");
            String strComando="select * from usuario where usuario='"+usuario+"' and contrasena='"+contrasena+"';";
            cdr=sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                out.println("<h1>Modifica su informacion</h1>");
                out.println("<br><br>");
                out.println("<input type=text id='nombre' readonly value='"+cdr.getString("nombre")+"'>");
                out.println("<br><br>");
                out.println("<input type=text id='apellidos' readonly value='"+cdr.getString("apellidos")+"'>");
                out.println("<br><br>");
                out.println("<input type=text id='telefono' value='"+cdr.getString("telefono")+"'>");
                out.println("<br><br>");
                out.println("<input type=text id='usuario' readonly value='"+cdr.getString("usuario")+"'>");
                out.println("<br><br>");
                out.println("<input type=text id='genero' readonly value='"+cdr.getString("genero")+"'>");
                out.println("<br><br>");
                out.println("<input type=text id='correo_electronico' value='"+cdr.getString("correo_electronico")+"'>");
                out.println("<input type=hidden id='contrasena' value='"+cdr.getString("contrasena")+"'>");
                out.println("<br><br>");
                out.println("<input type=button value='Guardar cambios' id='boton' onclick='modifica();'>");
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
