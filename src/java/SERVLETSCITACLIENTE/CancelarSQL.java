/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETSCITACLIENTE;

import java.sql.*;
import conexionCarlos.Conexion;
import correo.Controlador;
import correo.Correo;
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
@WebServlet(name = "CancelarSQL", urlPatterns = {"/CancelarSQL"})
public class CancelarSQL extends HttpServlet {
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
            out.println("<title>Servlet CancelarSQL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelarSQL at " + request.getContextPath() + "</h1>");
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
       String asunto=request.getParameter("asunto");
       String nombre = null;
       String folio =request.getParameter("folio");
        try {
            String comando1 = "select nombre_completo from agenda where folio='" + folio + "';";
            String comando="UPDATE AGENDA set asunto='"+asunto+"', estado='cancelada' where folio='"+folio+"'";
             cdr = sentenciaSQL.executeQuery(comando1);
                    while (cdr.next()) {
                        nombre = cdr.getString(1);
                    }
            if(sentenciaSQL.executeUpdate(comando)==1){
                out.println("La cita se cancelo correctamente<br>");
                 Correo ce = new Correo();
                        ce.setContrasena("zakisnvlcjukapwi");
                        ce.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
                        ce.setDestino("yelito12344321@gmail.com");
                        ce.setAsunto("UN CLIENTE CANCELO UNA CITA!!");
                        ce.setMensaje("el cliente:" + nombre + "\n" + "cancelo su cita por los siguientes motivos:" + asunto + "\n");
                        Controlador cos = new Controlador();
                        if (cos.enviarcorreo(ce)) {
                            out.println("El correo se envio exitosamente<br>");
                        } else {
                            out.println("falla al enviar el correo<br>");
                        }
            }else{
                out.println("Error al cancelar la cita");
            }
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
