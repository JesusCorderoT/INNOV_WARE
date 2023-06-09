/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jesus
 */
@WebServlet(name = "Login_sesion", urlPatterns = {"/Login_sesion"})
public class Login_sesion extends HttpServlet {
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();

        try {

            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("password");
            int nivel=0;
            String estado;
            String encodedURL;
            String usuarios="";
            HttpSession session = request.getSession();
            String strComando = "select * from usuario where contrasena='" + contrasena + "' and usuario='" + usuario + "';";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                nivel = cdr.getInt("nivel");
                estado = cdr.getString("estado");
                usuarios = cdr.getString("usuario");
            }
            if (nivel == 1) {
                session.setAttribute("nom", usuarios);
                session.setAttribute("niv", nivel);
                //setting session to expiry in 30 mins
                //session.setMaxInactiveInterval(30 * 60);
                Cookie userName1 = new Cookie("nombre", usuarios);
                response.addCookie(userName1);
                //Get the encoded URL string
                encodedURL = response.encodeRedirectURL("Menu_Administrador.jsp");
                response.sendRedirect(encodedURL);

            } else {
                if (nivel == 2) {
                    session.setAttribute("nom", usuarios);
                    session.setAttribute("niv", nivel);
                    //setting session to expiry in 30 mins
                    // session.setMaxInactiveInterval(30 * 60);
                    Cookie userName2 = new Cookie("nom", usuarios);
                    response.addCookie(userName2);
                    //Get the encoded URL string
                    encodedURL = response.encodeRedirectURL("Menu_Cliente.jsp");
                    response.sendRedirect(encodedURL);
                } else {
                    request.setAttribute("error", true);
//                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                    rd.forward(request, response);
                    encodedURL = response.encodeRedirectURL("Login.jsp");
                    response.sendRedirect(encodedURL);

                }
            }

        } catch (SQLException e) {
            out.println("error sql");
        }
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
