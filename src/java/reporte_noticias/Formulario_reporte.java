/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte_noticias;

import conexion.Conexion;
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
 * @author brandon
 */
@WebServlet(name = "Formulario_reporte", urlPatterns = {"/Formulario_reporte"})
public class Formulario_reporte extends HttpServlet {
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
       PrintWriter out = response.getWriter();
       
        try {
            
            String strcomando="SELECT titulo_noticia from boletin";
           cdr=sentenciaSQL.executeQuery(strcomando);
           
            out.println("<h1>Formulario de reporte</h1>"); 
            out.println("<br><br>"); 
           out.println("<input id='usuario' type=text placeholder='usuario' value=''>"); 
           out.println("<br><br>"); 
           out.println("<input id='descripccion_reporte' type=text placeholder='descripccion' value=''>"); 
           out.println("<br><br>"); 
           while(cdr.next()){
               out.println("<select id='select'>");
               out.println("<option>Selecciona noticia</option>");
               out.println("<option value='"+cdr.getString("titulo_noticia")+"'>"+cdr.getString("titulo_noticia")+"</option>");
               out.println("</select>");
           }
           out.println("<br><br>"); 
           out.println("<input id='boton' type=button value='enviar reporte' onclick='registrar_report();'>"); 
           
           
           
           
           
           
           
           
        } catch (Exception e) {
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
