package PRODUCTOSJCT;

import java.io.IOException;
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
@WebServlet(name = "AddCart2", urlPatterns = {"/agregarproducto2"})
public class AddCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));
        int idproducto2 = Integer.parseInt(request.getParameter("idproducto2"));
        
    

        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo2> articulos2 = sesion.getAttribute("carrito2") == null ? new ArrayList<>() : (ArrayList) sesion.getAttribute("carrito2");

        boolean flag = false;
        if (articulos2.size() > 0) {
            for (Articulo2 a2 : articulos2) {
                if (idproducto2 == a2.getIdProducto2()) {
                    a2.setCantidad2(a2.getCantidad2() + cantidad2);
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            articulos2.add(new Articulo2(idproducto2, cantidad2));
        }

        sesion.setAttribute("carrito2", articulos2);

        response.sendRedirect("cartP.jsp");

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
