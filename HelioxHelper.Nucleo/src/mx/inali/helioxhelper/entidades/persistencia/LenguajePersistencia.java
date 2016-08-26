/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.inali.helioxhelper.entidades.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adolfo
 */
public class LenguajePersistencia {
    
    DerbyDB db = new DerbyDB();
    
    public void agregarLenguaje(String nombre) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("INSERT INTO Lenguaje (nombre) VALUES (?)");
            ps.setString(1, nombre);
            ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public void eliminarLenguaje(int id) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("DELETE from Lenguaje WHERE id = ?");
            ps.setInt(1, id);
            int res = ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public void editarLenguaje(String nombre, int id) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("UPDATE Lenguaje SET nombre = ? WHERE id = ?");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            int res = ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public ResultSet consultarLenguaje(int id) throws SQLException{
        ResultSet res;
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("SELECT * FROM LENGUAJE WHERE id = ?");
            ps.setInt(1, id);
            res = ps.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return res;
    }
     
    public ResultSet listadoLenguajes() throws SQLException{
        ResultSet res;
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("SELECT * FROM LENGUAJE");
            res = ps.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return res;
    } 
}
