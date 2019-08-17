/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;
import DAO.*;
import Identidades.Carrera;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author jorge Alberto
 */
public class TransaccionesCarrera {
    Carrera c;
    int res=0;
    DaoCarrera ob=new DaoCarrera();
    public DefaultTableModel mostrar(){
        ArrayList<Carrera> ar=new ArrayList<Carrera>();
        String[] title={"CODIGO", "NOMBRE", "MATERIAS", "FACULTAD"};
        DefaultTableModel tm=new DefaultTableModel(title,0);
        
        try {
            ar.addAll(ob.mostrar());
            Object[] vec=new Object[4];
            for(Carrera  v: ar){
                vec[0]=v.getCodigoCarrera();
                vec[1]=v.getNombre();
                vec[2]=v.getCantidadMaterias();
                vec[3]=v.getCodigoFacultad();
                tm.addRow(vec);
            }
        } catch (Exception e) {
            
        }
        return tm;
    }
    public void agregar(String nombre, String cantidadMaterias, String codigoFacultad){
        try {
            c=new Carrera(nombre, Integer.parseInt(cantidadMaterias), codigoFacultad);
            res=ob.agrgarCarrera(c);
            if(res>0)
                JOptionPane.showMessageDialog(null, "Registro ingresado correctamente");
            else
                JOptionPane.showMessageDialog(null, "Registro no se pudo ingresar");
            
        } catch (Exception e) {
        }
    }
    
    public void modificar(String codigoCarrera, String nombre, String cantidadMaterias, String codigoFacultad){
        try {
            c=new Carrera(codigoCarrera, Integer.parseInt(cantidadMaterias), codigoFacultad);
            res=ob.modificarCarrera(c);
            if(res>0)
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
            else
                JOptionPane.showMessageDialog(null, "Registro no se pudo modificar");
            
        } catch (Exception e) {
        }
    }
    
    public void eliminar(int codigoCarrera){
        try {
            c=new Carrera(codigoCarrera);
            res=ob.eliminarCarrera(c);
            if(res>0)
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            else
                JOptionPane.showMessageDialog(null, "Registro no eliminado");
            
        } catch (Exception e) {
        }
        
       
    }
}
