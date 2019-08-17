
package DAO;

import Identidades.Facultad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoFacultad
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class DaoFacultad extends Conexion implements CrudFacultad{
    
    PreparedStatement ps;   //Para sentencias SQL
    ResultSet rs;           //para los resultados que recibe
    Facultad f;             //para crear facultades
    int res;                
    
    //Mostrar todas las facultades
    @Override
    public ArrayList<Facultad> mostrar() throws ClassNotFoundException, SQLException{
    
        ArrayList<Facultad> fa = new ArrayList<Facultad>();
        
        try {
            ps = super.con().prepareStatement("select codigoFacultad, nombre, "
            +"telefono from facultad where estado = 1");
            rs = ps.executeQuery();
            
            while(rs.next()){
                f = new Facultad(rs.getInt(1), rs.getString(2), rs.getString(3));
                fa.add(f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            super.con().close();
        }
    
        return fa;
    }
    
    //Agregar Facultades
    @Override
    public int agregarFacultad(Facultad f) throws ClassNotFoundException, SQLException{
        
        try {
            ps = super.con().prepareStatement("insert into facultad(nombre, telefono, estado) "
            +"values (?,?,1)");
            ps.setString(1, f.getNombre());
            ps.setString(2, f.getTelefono());
            res = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            super.con().close();
        }    
    
        return res;
    }
    
    //Modificar facultades
    @Override
    public int modificarFacultad(Facultad f) throws ClassNotFoundException, SQLException{
    
        try {
            ps = super.con().prepareStatement("update facultad set nombre=? "
            + ", telefono=? where codigoFacultad=?");
            ps.setString(1, f.getNombre());
            ps.setString(2,f.getTelefono());
            ps.setInt(3, f.getCodigoFacultad());
            res = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            super.con().close();
        }
        
        return res;
    }
    
    //EliminarFacultad
    @Override
    public int eliminarFacultad(Facultad f) throws ClassNotFoundException, SQLException{
    
        try {
            ps = super.con().prepareStatement("update facultad set estado=0 "
            +"where codigoFacultad=?");
            ps.setInt(1, f.getCodigoFacultad());
            res = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            super.con().close();
        }
    
        return res;
    }
    
}
