/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsUser;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "Form_Garantia", urlPatterns = {"/Form_Garantia"})
public class Form_Garantia extends HttpServlet {

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
       /* try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Form_Garantia</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Form_Garantia at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id_producto = request.getParameter("id_producto");
        PrintWriter out = response.getWriter();
        try {
            out.println("<p>ID cliente: <input type=\"text\" name=\"id_cliente\" id=\"id_cliente\" value=\"\" required=\"\"></p>");
            out.println("<p>ID del producto: <input type=\"text\" name=\"id_producto\" id=\"id_producto\" value=\""+id_producto+"\" readonly=\"\"></p>\n");
            out.println("<p>Motivo por el cual se solicita la garantía: <textarea name=\"motivo\" id=\"motivoGarantia\" required=\"\"></textarea></p>\n");
            out.println(" <input type=\"button\" name=\"SolicitarGarantia\" id=\"SolicitarGarantia\" value=\"Solicitar Garantía\" onclick=\"GenerarGarantia("+id_producto+");\">");
            out.println("<br>");
            out.println("<div id=\"AnswerFormGarantia\"> </div>");
            out.println("");
            out.println("");

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
