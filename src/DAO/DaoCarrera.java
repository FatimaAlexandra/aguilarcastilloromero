/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import Identidades.Carrera;
import java.sql.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge Alberto
 */
public class DaoCarrera extends Conexion implements CrudCarrera{
PreparedStatement ps;       //para sentencias sql
    ResultSet rs;               //para resultados que va a devolver
    Carrera c;                 //para crear productos
    int res;
    
    @Override
    public ArrayList<Carrera> mostrar() throws ClassNotFoundException, SQLException {
         ArrayList<Carrera> ar=new ArrayList<Carrera>();
        try {
            ps=super.con().prepareStatement("select c.codigoCarrera, c.nombre, c.cantidadMaterias, f.nombre "
                    + "FROM carrera c INNER JOIN facultad f ON c.codigoFacultad = f.codigoFacultad where c.estado=1");
            rs=ps.executeQuery();
            while(rs.next()){
                c=new Carrera(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                ar.add(c);
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
      
        }finally{
            super.con().close();
        }
        return ar;
    }

    @Override
    public int agrgarCarrera(Carrera c) throws ClassNotFoundException, SQLException {
        try {
            ps=super.con().prepareStatement("insert into carrera(nombre, cantidadMaterias, codigoFacultad, estado)"
                    + "values(?,?,(select codigoFacultad from facultad where nombre=?),1)");
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCantidadMaterias());
            ps.setString(3, c.getCodigoFacultad());
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    }

    @Override
    public int modificarCarrera(Carrera c) throws ClassNotFoundException, SQLException {
        try {
            ps=super.con().prepareStatement ("update carrera set nombre=?,cantidadMaterias=?,"
                    + "codigoFacultad=(select codigoFacultad from facultad where nombre=?) where codigoCarrera=?");
            
            ps.setString(1, c.getNombre());
            ps.setDouble(2, c.getCantidadMaterias());
            ps.setString(3, c.getCodigoFacultad());
            ps.setInt(4, c.getCodigoCarrera());
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    }

    @Override
    public int eliminarCarrera(Carrera c) throws ClassNotFoundException, SQLException {
        try {
            ps=super.con().prepareStatement("update carrera  set estado=0 "
                    + "where codigoCarrera=?");
            
            ps.setInt(1, c.getCodigoCarrera());
            res=ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            super.con().close();
        }
        return res;
    
    }
  
    
}
