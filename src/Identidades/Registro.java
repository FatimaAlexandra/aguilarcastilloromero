
package Identidades;

/**
 * Nombre de la clase: Registro
 * Fecha: 17-08-2019
 * Version: 2.0
 * CopyRight: Itca-Fepade
 * @author Alexis Aguilar
 */
public class Registro {
    
    private int idUsuario;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String tipoUsuario;

    public Registro() {
    }

    public Registro(String nombre, String usuario, String contraseña, String tipoUsuario) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Registro(String usuario) {
        this.usuario = usuario;
    }    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
    
}
