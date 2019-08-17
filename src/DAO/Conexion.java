/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jorge Alberto
 */
public class Conexion {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://127.0.0.1:3306/aguilarcastilloromero";
    private String user="root";
    private String password="";
    public Connection con() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public Conexion() {
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
