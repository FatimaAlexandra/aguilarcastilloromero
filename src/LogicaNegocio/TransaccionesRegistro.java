
package LogicaNegocio;

import DAO.DaoRegistro;
import Identidades.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: TransaccionesRegistro
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class TransaccionesRegistro {
    
    DaoRegistro ob = new DaoRegistro();
    Registro r;
    int res = 0;
     
    //para agregar registros
    public void agregar(String nombre, String usuario, String contraseña, String tipoUsuario){
        
        try {
            r = new Registro(nombre, usuario, contraseña, tipoUsuario);
            res = ob.agregarRegistro(r);
            
            if(res>0){
                JOptionPane.showMessageDialog(null, "Usuario Agregado Correctamente.!!");
            }else{
                JOptionPane.showMessageDialog(null, "No se agrego el usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
    
    }    
      
}
