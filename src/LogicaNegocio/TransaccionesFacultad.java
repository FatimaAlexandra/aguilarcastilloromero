
package LogicaNegocio;

import DAO.DaoFacultad;
import Identidades.Facultad;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;


/**
 * Nombre de la clase: TransaccionesFacultad
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class TransaccionesFacultad {
    
    DaoFacultad ob = new DaoFacultad();     //instacciamos a DaoFacultad
    Facultad f;                             //Para crear facultades
    int res = 0;
    
    
    //Para Mostrar Todas las facultades
    public DefaultTableModel mostrar(){
    
        ArrayList<Facultad> ar = new ArrayList<Facultad>();
        
        String[] titulos = {"CodigoFacultad", "Nombre", "Telefono"};
        DefaultTableModel tm = new DefaultTableModel(titulos,0);
        
        try {
            ar.addAll(ob.mostrar());
            Object [] vec = new Object[3];
            for(Facultad v:ar){
                vec[0] = v.getCodigoFacultad();
                vec[1] = v.getNombre();
                vec[2] = v.getTelefono();
                tm.addRow(vec);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return tm;
    }
    
    //Para agregar Facultades
    public void agregar(String nombre, String telefono){
    
        try {
            f = new Facultad(nombre, telefono);
            res = ob.agregarFacultad(f);
            
            if(res >0){
                JOptionPane.showMessageDialog(null, "Facultad Agregada Correctamente.!!");
            } else{
                JOptionPane.showMessageDialog(null, "No se agrego la Facultad.!!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }
    
    //Para Modificar facultades
    public void modificar(String codigoFacultad, String nombre, String telefono){
        
        try {
            f = new Facultad(Integer.parseInt(codigoFacultad), nombre, telefono);
            res = ob.modificarFacultad(f);
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "Facultad Modificada Correctamente.!!");
            } else{
                JOptionPane.showMessageDialog(null, "No se Modifico la facultad.!!");
            }     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }
    
    public void eliminar(String codigoFacultad){
    
        try {
            f = new Facultad(Integer.parseInt(codigoFacultad));
            res = ob.eliminarFacultad(f);
            
            if(res > 0 ){
                JOptionPane.showMessageDialog(null, "Facultad Eliminada Correctamente.!!");
            } else{
                JOptionPane.showMessageDialog(null, "No se Elimino la Facultad.!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }
}
