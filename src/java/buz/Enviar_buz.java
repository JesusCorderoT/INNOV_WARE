/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buz;

import correo.Controlador;
import correo.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author jesus
 */
@WebServlet(name = "Enviar_buz", urlPatterns = {"/Enviar_buz"})
public class Enviar_buz extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try {
            String correo=request.getParameter("correo");
            String usuario=request.getParameter("nombre_usuario");
            String asunto=request.getParameter("asunto");
             Correo c = new Correo();
            c.setContrasena("zakisnvlcjukapwi");
            c.setUsuarioCorreo("nerv.sistemas.epi@gmail.com");
            c.setDestino("nerv.sistemas.epi@gmail.com");
            c.setAsunto("Buzon de sugerencias ");
            c.setMensaje("nombre de usuario:"+usuario+"\n" + "\n" +"correo:"+ correo + "\n"+asunto);
            Controlador co = new Controlador();
            if(co.enviarcorreo(c)){
            out.println("enviado");    
            }else{
                out.println("No enviado");
            }
            
        } catch (Exception e) {
            out.println("error al enviar");
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
