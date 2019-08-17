
package DAO;

import Identidades.Facultad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Nombre de la clase: CrudFacultad
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public interface CrudFacultad {
    
    public ArrayList<Facultad> mostrar() throws ClassNotFoundException, SQLException;
    public int agregarFacultad(Facultad f) throws ClassNotFoundException, SQLException;
    public int modificarFacultad(Facultad f) throws ClassNotFoundException, SQLException;
    public int eliminarFacultad(Facultad f) throws ClassNotFoundException, SQLException;    
    
}
