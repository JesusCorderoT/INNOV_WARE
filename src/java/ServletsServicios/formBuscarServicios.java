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
 * @author LAB-CB09
 */
@WebServlet(urlPatterns = {"/formBuscarServicios"})
public class formBuscarServicios extends HttpServlet {
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
            out.println("<title>Servlet formBuscarServicios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet formBuscarServicios at " + request.getContextPath() + "</h1>");
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
        out.print("<h1>Consulta de servicios</h1><br><br>");
        out.print("<p>Busqueda de servicios por diferentes parametros</p><br><br>");
        out.print("Mostrar todos los servicios: <button id='buscar' onclick='mostrarServicios()'>Ver</button><br><br>");
        try{
            String consulta="select distinct nombre_servicio,categoria from servicios";
            
            cdr = sentenciaSQL.executeQuery(consulta);
        out.println("Selecciona el nombre: <select id='nombre'>");
        out.println( "<option>Selecciona..</option>");
                    while (cdr.next()) {
                out.println("<option value='" + cdr.getString("nombre_servicio") + "'>" + cdr.getString("nombre_servicio") + "</option>");
            }
        out.println("</select>");            
        out.println( "<button id=b1 onclick='buscarServicioNombre()'>Buscar</button><br><br>");
        try{
            String consulta2="select nombre from categoria";
            cdr = sentenciaSQL.executeQuery(consulta2);
        out.println("Selecciona la categoria: <select id='categoria'>");
        out.println( "<option>Selecciona..</option>");
                   while (cdr.next()) {
                out.println("<option value='"+ cdr.getString(1) + "'>" + cdr.getString(1) + "</option>");
            }
        out.println("</select>");            
        out.println("<button id=b2 onclick='busquedaServicioCategoria()'>Buscar</button><br><br>");
        }catch(SQLException ex){
            
        }
        out.println("Selecciona la calificación(1-10): <select id='calificacion'>");
        out.println( "<option>Selecciona..</option>"
                + "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select>");
        out.println("<button id=b3 onclick='busquedaServicioCalificacion()'>Buscar</button><br><br>");
        }catch(SQLException e){
            e.printStackTrace();
        }
        out.println("<p id=consultaS></p>");
        out.println("<p id=nuevaconsulta></p>");
        out.println("<p id=mensajeConfirmacion></p>");
        
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
