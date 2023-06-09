package SERVICIOSJCT;

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
borraritem4
 */
@WebServlet(name = "DeleteItem4", urlPatterns = {"/borraritem4"})
public class DeleteItem4 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   int idproducto = Integer.parseInt(request.getParameter("idproducto"));
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
        
        if(articulos != null){
            for(Articulo a : articulos){                
                if(a.getIdProducto() == idproducto){
                    articulos.remove(a);
                    break;
                }
            }
        }
        
        double total = 0;
        ControladorProducto cp = new ControladorProducto();
        for(Articulo a : articulos){                
            Producto producto = cp.getProducto(a.getIdProducto());
            total += a.getCantidad() * producto.getPrecio();            
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
