package conexion;

import java.sql.*;

public class Conexion {

    private Connection conexion = null;
    private Statement senteciaSQL = null;

    
    
    public void Conectar() {
        try {
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();

            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/innovware", "root", "");
            senteciaSQL = getConexion().createStatement();
            
            
        } catch (ClassNotFoundException e) {
            System.out.println("no se pudo cargar el controlador"+ e.getMessage());
        }catch(SQLException e){
            System.out.println("excepcionsql "+e.getMessage());
        }catch(InstantiationException e){
            System.out.println("objeto no creado0"+ e.getMessage());
        }catch(IllegalAccessException e){
            System.out.println("acceso ilegal"+ e.getMessage());
        }
    }

    public void cerrar() {
        try {
            if (getSenteciaSQL() != null) {
                getSenteciaSQL().close();
                if (getConexion() != null) {
                    getConexion().close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public Connection getConexion() {
        return conexion;
    }

    public Statement getSenteciaSQL() {
        return senteciaSQL;
    }

    
    
    

    
}
