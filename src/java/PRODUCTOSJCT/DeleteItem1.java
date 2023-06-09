package PRODUCTOSJCT;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
borraritem1
 */
@WebServlet(name = "DeleteItem1", urlPatterns = {"/borraritem1"})
public class DeleteItem1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         int idproducto2 = Integer.parseInt(request.getParameter("idproducto2"));
        
        HttpSession sesion2 = request.getSession(true);
        ArrayList<Articulo2> articulos2 = sesion2.getAttribute("carrito2") == null ? null : (ArrayList) sesion2.getAttribute("carrito2");
        
        if(articulos2 != null){
            for(Articulo2 a2 : articulos2){                
                if(a2.getIdProducto2() == idproducto2){
                    articulos2.remove(a2);
                    break;
                }
            }
        }
     
        double total = 0;
        ControladorProducto2 cp = new ControladorProducto2();
        for(Articulo2 a2 : articulos2){                
            Producto2 producto2 = cp.getProducto2(a2.getIdProducto2());
            total += a2.getCantidad2() * producto2.getPrecio2();            
        }
        
        response.getWriter().print(Math.round(total * 100.0) /100.0); 
        
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
