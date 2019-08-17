
package Identidades;

/**
 * Nombre de la clase: Facultad
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class Facultad {
    
    private int codigoFacultad;
    private String nombre;
    private String telefono;

    public Facultad() {
    }

    //Constructor para Agregar
    public Facultad(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    //Constructor para Modificar
    public Facultad(int codigoFacultad, String nombre, String telefono) {
        this.codigoFacultad = codigoFacultad;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    //COnstructor para eliminar
    public Facultad(int codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }
    
    //Getters y setters
    public int getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(int codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
    
    
}
