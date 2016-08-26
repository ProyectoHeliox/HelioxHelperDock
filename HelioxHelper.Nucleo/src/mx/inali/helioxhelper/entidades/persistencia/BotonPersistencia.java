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
public class BotonPersistencia {
    
    public void agregarBoton(String rutaIcon, String descripcion, String rutaEjecutable, String rutaAudio, int idLenguaje) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("INSERT INTO BOTON (rutaIcon, descripcion, rutaEjecutable, rutaAudio, idLenguaje) VALUES (?,?,?,?,?)");
            ps.setString(1, rutaIcon);
            ps.setString(2, descripcion);
            ps.setString(3, rutaEjecutable);
            ps.setString(4, rutaAudio);
            ps.setInt(5, idLenguaje);
            int res = ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public void eliminarBoton(int id) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("DELETE from BOTON WHERE id = ?");
            ps.setInt(1, id);
            int res = ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public void editarBoton(String rutaIcon, String descripcion, String rutaEjecutable, String rutaAudio, int idLenguaje, int id) throws SQLException{
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("UPDATE BOTON SET rutaIcon = ?, descripcion = ?, rutaEjecutable = ?, rutaAudio = ?, idLenguaje = ? WHERE id = ?");
            ps.setString(1, rutaIcon);
            ps.setString(2, descripcion);
            ps.setString(3, rutaEjecutable);
            ps.setString(4, rutaAudio);
            ps.setInt(5, idLenguaje);
            ps.setInt(6, id);
            int res = ps.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public ResultSet consultarBoton(int id) throws SQLException{
        ResultSet res;
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("SELECT * FROM BOTON WHERE id = ?");
            ps.setInt(1, id);
            res = ps.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return res;
    }
     
    public ResultSet listadoBotones() throws SQLException{
        ResultSet res;
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("SELECT * FROM BOTON");
            res = ps.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return res;
    } 
    
      public ResultSet listadoBotonesLenguaje(int id) throws SQLException{
        ResultSet res;
        try{
            PreparedStatement ps = null;
            Connection conn = DerbyDB.getConexion();
            ps = conn.prepareStatement("SELECT * FROM BOTON where idLenguaje = ?");
            ps.setInt(1, id);
            res = ps.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return res;
    } 
}
