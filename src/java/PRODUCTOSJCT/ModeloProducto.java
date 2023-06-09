package PRODUCTOSJCT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloProducto extends Conexion{
     
    public ArrayList<Producto2> getAllProductos2(){
        ArrayList<Producto2> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "call selectProd()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                productos.add(new Producto2(rs.getInt("id_producto"), rs.getString("nombre_producto"), rs.getString("imagen_producto"), rs.getInt("calificacion"), rs.getDouble("costo"), rs.getInt("costo")));
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return productos;        
    }
    
    public Producto2 getProducto2(int id){
        Producto2 producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String sql = "call selectProdus(?)";
            pst = getConnection().prepareCall(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                producto = new Producto2(rs.getInt("id_producto"), rs.getString("nombre_producto"), rs.getString("imagen_producto"), rs.getInt("calificacion"), rs.getDouble("costo"), rs.getInt("costo"));
            }
        } catch (Exception e) {
            
        } finally{
            try {
                if(rs != null) rs.close();
                if(pst != null) pst.close();
                if(getConnection() != null) getConnection().close();
            } catch (Exception e) {
            }
        }       
        return producto;
        
    }

    
    
}
