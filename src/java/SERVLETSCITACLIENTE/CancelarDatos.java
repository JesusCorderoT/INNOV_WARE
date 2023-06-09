/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETSCITACLIENTE;

import java.sql.*;
import conexionCarlos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author carlos toto
 */
@WebServlet(name = "CancelarDatos", urlPatterns = {"/CancelarDatos"})
public class CancelarDatos extends HttpServlet {
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
       /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CancelarDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelarDatos at " + request.getContextPath() + "</h1>");
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
        String folio=request.getParameter("folio");
        try {
            String comando="SELECT * FROM agenda where folio='"+folio+"' and estado='pendiente'";
            cdr=sentenciaSQL.executeQuery(comando);
            if(cdr.next()){
              cdr.beforeFirst();
              while(cdr.next()){
                out.println("Nombre:<input type=\"text\" id=\"nombre\" name=\"nombre\" readonly value='"+cdr.getString(2)+"'><br>");
                out.println("Nombre empresa:<input type=\"text\" id=\"empresa\" name=\"empresa\" readonly value="+cdr.getString(3)+"><br>");
                out.println("Asunto:<textarea id=\"asunto\" name=\"asunto\" rows=\"5\" cols=\"40\" >"+cdr.getString(4)+"</textarea><br>");
                out.println(" Fecha:<input type=\"date\" id=\"fecha\" name=\"fecha\" readonly  value="+cdr.getString(5)+"><br>");
                out.println("Hora:<input type=\"time\" id=\"hora\" name=\"hora\" readonly value="+cdr.getString(6)+"><br>");
                
            }
              out.println("<input type=\"submit\" value=\"Cancelar\" onclick=\"cancelarSQL()\"><br>");
              out.println("<p id=rescandatos></p>");
            }else{
                out.println("El folio no existe");
            }
                
            
            
        } catch (SQLException e) {
            out.println("El folio no existe");
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
