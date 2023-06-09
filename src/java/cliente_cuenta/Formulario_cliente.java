/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author brandon
 */
@WebServlet(name = "Formulario_cliente", urlPatterns = {"/Formulario_cliente"})
public class Formulario_cliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println(" <script type=\"text/javascript\" src=\"cuenta_administrador.js\"> </script>");
            
            out.println("<h3>Crea cuenta Cliente<h3>");
            out.println("<br>");
            out.println("<input autofocus placeholder=\"Nombre\" name=\"nombre\" id=\"nombre_usuario\" type=\"text\" required maxlength=\"30\"> ");
            out.println("<br><br>");
            out.println(" <input autofocus placeholder=\"Apellidos\" name=\"apellidos\" id=\"apellidos\" type=\"text\" required maxlength=\"30\">");
            out.println("<br><br>");
            out.println("<input autofocus placeholder=\"Telefono\" name=\"telefono\" id=\"telefono\" type=\"text\" required maxlength=\"10\">");
            out.println("<br><br>");
            out.println("<input autofocus placeholder=\"Usuario\"   id='usuario_c' type=\"text\" required maxlength=\"15\">");
            out.println("<br><br>");
            out.println("<input autofocus placeholder=\"Contraseña\" name=\"contrasena\" id=\"password_user\" type=\"password\" required maxlength=\"20\">");
            out.println("<br><br>");
            out.println("<label>Genero</label><select name=\"sexo\" id=\"sexo\" required>");
            out.println("<option value=\"\">-seleccionar-</option>");
            out.println("<option value=\"masculino\">Masculino</option>");
            out.println("<option value=\"femenino\">Femenino</option>");
            out.println("</select>");
            
            out.println("<br><br>");
            out.println("<input autofocus placeholder=\"e-Mail\" name=\"correo_electronico\" id=\"correo_electronico\" type=\"text\" required maxlength=\"15\">");
            out.println("<select name=\"dominio\" id=\"dominio\" required>");
            out.println("<option value=\"\">-seleccionar Dominio-</option>");
            out.println("<option value=\"@gmail.com\">@gmail.com</option>");
            out.println("<option value=\"@Outlook.com\">@Outlook.com</option>");
            out.println("<option value=\"@yahoo.com\">@yahoo.com</option>");
            out.println("<option value=\"@uttecamac.edu.mx\">@uttecamac.edu.mx</option>");
            out.println("</select>");
            out.println("<br><br>");
            out.println("<input type=\"button\" value=\"Registrarse\" onclick='mostrarRegistroC();'>");
            
            
            
            
        } catch (Exception e) {
            out.println(e);
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
