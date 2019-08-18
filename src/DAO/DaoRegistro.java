
package DAO;

import Identidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoRegistro
 * Fecha: 17-08-2019
 * Version: 1.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class DaoRegistro extends Conexion{
    
    PreparedStatement ps;   //Para sentencias SQL
    ResultSet rs;           //para los resultados que recibe
    Registro r;            //para crear facultades
    int res;             
    
    
    //Para agregar registros
    public int agregarRegistro(Registro r)throws ClassNotFoundException, SQLException{
    
        try {
            ps = super.con().prepareStatement("insert into usuario(nombre,"
                    + "usuario, contraseña, tipoUsuario) values(?,?,?,?)");
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getUsuario());
            ps.setString(3, r.getContraseña());
            ps.setString(4, r.getTipoUsuario());
            res = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            super.con().close();
        }
        return res;
    }
       
    //usuario ya existe
    public int existeUsuario(String usuario){    
        
        PreparedStatement ps = null;
        ResultSet rs = null;
          
        try {
             ps = super.con().prepareStatement("select count(idUsuario) from usuario where usuario=?");
             ps.setString(1, usuario);
             rs = ps.executeQuery();
             
             if(rs.next()){
                 return rs.getInt(1);
             }
             
             return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 1;
        }
    
    }
    
    //Login
    public boolean login(Registro usr){    
        
        PreparedStatement ps = null;
        ResultSet rs = null;
          
        try {
             ps = super.con().prepareStatement("select idUsuario, usuario, nombre"
                     + ", contraseña, tipoUsuario from usuario where usuario=?");
             ps.setString(1, usr.getUsuario());
             rs = ps.executeQuery();
             
             if(rs.next()){
                if(usr.getContraseña().equals(rs.getString(4))){
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNombre(rs.getString(3));
                    usr.setTipoUsuario(rs.getString(5));
                    return true;
                }else{
                    return false;
                }
             }
             
             return false;
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    
    }
    
    
}
