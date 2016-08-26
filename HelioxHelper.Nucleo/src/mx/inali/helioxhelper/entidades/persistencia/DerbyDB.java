/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.inali.helioxhelper.entidades.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adolfo
 */
public class DerbyDB {
    
    private static Connection conn = null;
    
    public static Connection getConexion() throws SQLException{
        System.out.println("Derby Conection ready...");
        String url = "jdbc:derby://localhost:1527/";
        String dbName = "helioxasistente";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String userName = "root";
        String password = "1234";
        if(conn == null){
            try{
                Class.forName(driver);
                conn = DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("Conectado a la base de datos");
            }catch(SQLException ex){
                throw new SQLException (ex);
            }catch(ClassNotFoundException ex){
                throw new ClassCastException(ex.getMessage());
            }
        }
        return conn;
    }
    
    public static void cerrar() throws SQLException{
        if(conn !=  null){
            conn.close();
        }
    }
}
