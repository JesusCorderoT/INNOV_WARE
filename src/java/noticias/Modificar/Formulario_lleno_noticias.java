/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.Modificar;

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
@WebServlet(name = "Formulario_lleno_noticias", urlPatterns = {"/Formulario_lleno_noticias"})
public class Formulario_lleno_noticias extends HttpServlet {
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
            String titulo_noticia=request.getParameter("titulo_noticia");
            
             String strComando = "SELECT * FROM boletin WHERE titulo_noticia='"+titulo_noticia+"';";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            out.println("<h1>Modificar Noticia</h1>");
            while(cdr.next()){
                out.print("<br><br>");
                out.print("<input type=\"text\" id=\"id_boletin\" placeholder=\"id_boletin\" readonly value='"+cdr.getString("id_boletin")+"' >");
            out.print("<br><br>");
            out.print("<input type=\"text\" id=\"titulo_noticia\" placeholder=\"titulo_noticia\" required maxlength=\"30\" value='"+cdr.getString("titulo_noticia")+"' >");
            out.print("<br><br>");
            out.print("<textarea id=\"descripcion_noticia\" placeholder=\"descripcion\" required maxlength=\"300\" value='' >"+cdr.getString("descripcion_noticia")+"</textarea>");
            out.print("<br><br>");
            out.print("<input type=\"text\" id=\"autor\" placeholder=\"autor\" required maxlength=\"20\" value='"+cdr.getString("autor")+"' >");
            out.print("<br><br>");
            out.print("<input type=\"date\" id=\"fecha\"  required maxlength=\"20\" value='"+cdr.getString("fecha")+"' >");
            out.print("<br><br>");
            out.print("<input type=button value='modificar' id=boton onclick='mostrar_actualizada_noticia();' >");
            }
        } catch (SQLException e) {
            out.println("error sql:"+e);
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
