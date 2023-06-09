/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETCITAADMI;

import conexionCarlos.Conexion;
import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author carlos toto
 */
@WebServlet(name = "FiltrarNombreEmpresa", urlPatterns = {"/FiltrarNombreEmpresa"})
public class FiltrarNombreEmpresa extends HttpServlet {
ResultSet cdr = null;
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
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FiltrarNombreEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FiltrarNombreEmpresa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
          String nombreE = request.getParameter("nombreE");
            String comando = "select folio,nombre_completo,asunto,fecha,estado from agenda where nombre_empresa like '%"+nombreE+"%' and estado='pendiente';";
            try {
                cdr = sentenciaSQL.executeQuery(comando);
                
                out.println("<table width=100% border=1 >");
                out.println("<tr>");
                out.println("<th>Folio</th><th>Nombre</th><th>Asunto</th><th>Fecha</th><th>Estado</th>");
                out.println("</tr>");
               
                while (cdr.next()) {
                      
                   
                    out.println("<tr>");
                    out.println("<td width=40%><input type=\"hidden\" id=\"folio\" name=\"folio\" value="+cdr.getString(1)+">" + cdr.getString(1) + "</td>");
                    out.println("<td width=40%><input type=\"hidden\" id=\"nombre\" name=\"nombre\" value="+ cdr.getString(2)+">" + cdr.getString(2) + "</td>");
                    out.println("<td width=10%>" + cdr.getString(3) + "</td>");
                    out.println("<td width=10%>"+ cdr.getString(4) + "</td>");
                    out.println("<td width=10%><select id=estado name=estado><option value="+cdr.getString(5)+">"+cdr.getString(5)+"</option>"
                            + "<option value=agendada>agendada</option><option value=realizada>realizada</option><option value=cancelar>cancelar</option></td>");
                    out.println("<td width=10%><input type=\"submit\" id=\"cancelar\" value=\"Actualizar\" onclick=\"ActualizarEstado()\"></td>");
                    out.println("<td width=10%><input type=\"submit\" id=\"cancelar\" value=\"Modificar\" onclick=\"modificarAD()\"></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br>");
            } catch (SQLException e) {
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
