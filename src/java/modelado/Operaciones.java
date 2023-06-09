package modelado;

import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brandon
 */
public class Operaciones {
    String driver;
    String url;
    String uss;
    String contra;
    
    public Operaciones(){
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3308/innovware";
        uss="root";
        contra="";
    }
    
    public int loguear(String usuario, String password){
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        int nivel=0;
        
        String sql="SELECT nivel FROM usuario WHERE usuario='"+usuario+"' and contrasena='"+password+"'";
        try {
            Class.forName(this.driver);
            con=DriverManager.getConnection(
                    this.url,
                    this.uss,
                    this.contra
            );
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
             nivel=rs.getInt("nivel");
            }
           // con.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nivel;
    }
}
