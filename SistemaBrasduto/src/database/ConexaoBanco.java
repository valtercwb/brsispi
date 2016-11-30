package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 * Informações dos dados para conexão com a base de dados
 *
 * @author valter.franco
 */
public class ConexaoBanco {

    private static ConexaoBanco instancia = new ConexaoBanco();
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost/SistemaBrasduto";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2429";

    private ConexaoBanco() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao conectar-se com a base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
        }
        System.out.println("Connected");
    }

    /**
     * Sigleton para conexão com a base de dados
     */
    public static ConexaoBanco instancia() {
        if (instancia == null) {
            instancia = new ConexaoBanco();
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
