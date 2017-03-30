/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class DbConnection {

    private static DbConnection instancia = new DbConnection();
    private Connection connection;

    private DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/valter", "root", "2429");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            
        }
    }

    public static DbConnection instancia() {
        if (instancia == null) {
            instancia = new DbConnection();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }
}
