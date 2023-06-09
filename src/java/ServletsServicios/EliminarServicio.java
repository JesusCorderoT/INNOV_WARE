/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexionIW.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lab-CB08
 */
@WebServlet(urlPatterns = {"/EliminarServicio"})
public class EliminarServicio extends HttpServlet {
ResultSet cdr=null;
    Statement sentenciaSQL=null;
    Conexion conecta = new Conexion();
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
            out.println("<title>Servlet EliminarServicio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarServicio at " + request.getContextPath() + "</h1>");
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
        String confirmacion=request.getParameter("confirmacion");
       String id=request.getParameter("id");
         String consulta="Delete from servicios where id_servicio="+id;
           try{
               if(confirmacion.equalsIgnoreCase("si")){
                    if (sentenciaSQL.executeUpdate(consulta)==1) {
                       out.println("Eliminación correcta");
                   }else{
                        out.println("Eliminación cancelada");
                    }
               }
               /* 
                int c=sentenciaSQL.executeUpdate(consulta); 
                if(c==1){
                    out.print("Eliminación correcta");
                }else{
                    out.print("Error en la eliminación");
                }
                }
               else{
           out.print("Eliminación cancelada");
       } */
               
                  
               
           }catch(SQLException e){
               out.print("Error en la eliminación");
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
