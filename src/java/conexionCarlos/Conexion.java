package conexionCarlos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
import java.sql.*;
public class Conexion {
   private Connection conexion=null;
   private Statement sentenciaSQL=null;
   public void Conectar(){
       try {
           String controlador="com.mysql.jdbc.Driver";
       Class.forName(controlador).newInstance();
       conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/innovware","root","");
       sentenciaSQL=getConexion().createStatement();
       } catch (ClassNotFoundException e) {
           System.out.println("No se pudo cargar el controlador: " + e.getMessage());
       }catch(SQLException e){
           System.out.println("Excepcion SQL:" + e.getMessage());
       }catch(InstantiationException e){
           System.out.println("Objeto no creado. " + e.getMessage());
       }catch(IllegalAccessException e){
           System.out.println("Acceso ilegal. " + e.getMessage());
       }
       
   }
   public void cerrar(){
       try {
           if(getSentenciaSQL()!=null)getSentenciaSQL().close();
           if(getConexion() !=null) getConexion().close();
       } catch (SQLException ignorada) {
       }
   }
   public Connection getConexion(){
       return conexion;
   }
   public Statement getSentenciaSQL(){
       return sentenciaSQL;
   }
}
