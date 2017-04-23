package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author valter.franco
 */
public class DbConnection {
    
     private static DbConnection instancia = new DbConnection();
     private Connection connection;
 
     private static final String URL = "jdbc:mysql://localhost/SistemaBrasduto";
     private static final String DRIVER = "com.mysql.jdbc.Driver";
     private static final String USERNAME = "root";
     private static final String PASSWORD = "2429";
 
     private DbConnection() {
         try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
             Alert msg = new Alert(Alert.AlertType.ERROR);
             msg.setTitle("Deu ruim!");
             msg.setContentText("Aconteceu um erro ao conectarse com a base de dados!");
             msg.setHeaderText("Resultado:");
             msg.show();
         }
         System.out.println("Connected");
     }
 
     /**
      * Sigleton para conexão com a base de dados
      */
     public static DbConnection instancia() {
         if (instancia == null) {
             instancia = new DbConnection();
         }
         return instancia;
     }
 
     /**
      * Obter a conexão com a base de dados
      */
     public Connection getConnection() {
         return connection;
     }
 }
