/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsServicios;

import conexionIW.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */
@WebServlet(name = "FormularioReporte", urlPatterns = {"/FormularioReporte"})
public class FormularioReporte extends HttpServlet {
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta=new Conexion();
    
    public void init(ServletConfig config)throws ServletException{
        super.init(config);
        conecta.Conectar();
        sentenciaSQL=conecta.getSentenciaSQL();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormularioReporte at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.print("<p>Reportar Servicios</p>");
        out.println("ID del servicio: <input type='text' id='id'><br><br>");
        out.println("ID cliente: <input type='text' id='idCliente'><br><br>");
        
        out.println("Ingresa la calificación(1-10): <select id='cal'>");
        out.println( "<option>Selecciona..</option>"
                + "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select><br><br>");
        
        out.println("Reporte: <input type='text' id='comen'><br><br>");
        out.println("<button id='b1' onclick='ReportarServicio()'>Reporte</button>");
          out.println("<p id=nuevaconsulta></p>");
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
