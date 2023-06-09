/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICIOSJCT;

import SERVICIOSJCT.Articulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 agregarproducto
 */
@WebServlet(name = "AddCart", urlPatterns = {"/agregarproducto"})
public class AddCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
    

        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito");

        boolean flag = false;
        if (articulos.size() > 0) {
            for (Articulo a : articulos) {
                if (idproducto == a.getIdProducto()) {
                    a.setCantidad(a.getCantidad() + cantidad);
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            articulos.add(new Articulo(idproducto, cantidad));
        }

        sesion.setAttribute("carrito", articulos);

        response.sendRedirect("cart.jsp");

    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
