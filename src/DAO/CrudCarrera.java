/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Identidades.Carrera;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fatima alexandra
 */
public interface CrudCarrera {
    public ArrayList<Carrera>mostrar()throws ClassNotFoundException, SQLException;
    public int agrgarCarrera(Carrera c) throws ClassNotFoundException, SQLException;
    public int modificarCarrera(Carrera c) throws ClassNotFoundException, SQLException;
    public int eliminarCarrera(Carrera c) throws ClassNotFoundException, SQLException;
}
