/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Identidades;

/**
 *
 * @author jorge Alberto
 */
public class Carrera {
    private int codigoCarrera;
    private String nombre;
    private int cantidadMaterias;
    private String codigoFacultad;

    public Carrera() {
    }

    public Carrera(String nombre, int cantidadMaterias, String codigoFacultad) {
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.codigoFacultad = codigoFacultad;
    }

    public Carrera(int codigoCarrera, String nombre, int cantidadMaterias, String codigoFacultad) {
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.codigoFacultad = codigoFacultad;
    }
    
    public Carrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public String getCodigoFacultad() {
        return codigoFacultad;
    }

    public void setCodigoFacultad(String codigoFacultad) {
        this.codigoFacultad = codigoFacultad;
    }

    

  

}
