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
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author carlos toto
 */
@WebServlet(name = "AgendarCita", urlPatterns = {"/AgendarCita"})
public class AgendarCita1 extends HttpServlet {

    ResultSet cdr = null;
    ResultSet cdr2 = null;
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
         out.println("<title>Servlet AgendarCita</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet AgendarCita at " + request.getContextPath() + "</h1>");
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
        String nombre, correo = null, apellidos, empresa, asunto, fecha, hora;
        String codigo = UUID.randomUUID().toString().toUpperCase().substring(0, 6);
        nombre = request.getParameter("nombre");
        apellidos = request.getParameter("apellidos");
        empresa = request.getParameter("empresa");
        asunto = request.getParameter("asunto");
        fecha = request.getParameter("fecha");
        hora = request.getParameter("hora");
        String mensaje = request.getParameter("me");
        String mues = null;
        boolean con = false;
        if (mensaje.equalsIgnoreCase("si")) {
            con = true;
        } else {
            con = false;
        }
        if (nombre.isEmpty() || apellidos.isEmpty() || asunto.isEmpty() || fecha.isEmpty() || hora.isEmpty()
                || nombre == null || apellidos == null || asunto == null || fecha == null || hora == null
                || nombre == " " || apellidos == " " || asunto == " " || fecha == " " || hora == " ") {
            out.println("Ningun campo puede quedar vacio");

        } else {
             
                 
             
            if (con == true) {
                Date date = new Date();
             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             if(fecha.compareTo(dateFormat.format(date))<=0){
                   out.println("La fecha No puede ser Anterior o igual a la fecha actual\n para brindar un mejor servicio.");
             }else{
                  String comando1 = "select correo_electronico from usuario where nombre='" + nombre + "' and apellidos='" + apellidos + "';";
                String nombrec = nombre + " " + apellidos;
                String comando = "insert into agenda values(null,'" + nombrec + "','" + empresa + "','" + asunto + "','" + fecha + "','" + hora + "','pendiente','" + codigo + "');";
                String comando2 ="select * from agenda where nombre_completo='"+nombrec+"';";
                try {
                    out.println("Agendando cita espere...");
                    System.out.println(comando);
                    cdr = sentenciaSQL.executeQuery(comando1);
                    while (cdr.next()) {
                        correo = cdr.getString(1);
                    }
                    cdr2 = sentenciaSQL.executeQuery(comando2);
                    while (cdr2.next()) {
                        mues = cdr.getString(1);
                    }
                    if(mues !=null){
                         out.println("Existen valores Duplicados");
                         
                    }else{
                        if (sentenciaSQL.executeUpdate(comando) == 1) {
                        Correo c = new Correo();
                        c.setContrasena("zakisnvlcjukapwi");
                        c.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
                        c.setDestino(correo);
                        c.setAsunto("Datos de la cita agendada con INNOV&WARE");
                        c.setMensaje("cliente:" + nombrec + "\n" + "asunto de la cita: " + asunto + "\n" + "el dia:" + fecha + " a la hora:" + hora + " \neste es tu folio de la cita" + "\n" + codigo + "\n");
                        Controlador co = new Controlador();
                        co.enviarcorreo(c);
                        Correo ce = new Correo();
                        ce.setContrasena("zakisnvlcjukapwi");
                        ce.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
                        ce.setDestino("yelito12344321@gmail.com");
                        ce.setAsunto("INNOV&WARE tiene una cita nueva!!");
                        ce.setMensaje("cliente:" + nombrec + "\n" + "asunto de la cita: " + asunto + "\n" + "el dia:" + fecha + " a la hora:" + hora + "\n");
                        Controlador cos = new Controlador();
                        if (cos.enviarcorreo(ce)) {
                            out.println("El correo se envio exitosamente<br>");
                        } else {
                            out.println("falla al enviar el correo<br>");
                        }
                        out.println("La cita se agendo Exitosamente<br>");

                    } else {
                        out.println("Ocurrio un error al agendar la cita<br>");
                    }

                    }
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("Error esta fecha o Hora ya estan ocupadas");

                }
             }
               
            } else {
                out.println("Se cancelo la operación");
            }
             
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
