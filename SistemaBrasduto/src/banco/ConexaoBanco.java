package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import service.Mensagem;

/**
 * Informações dos dados para conexão com a base de dados
 *
 * @author Angelica Leite
 */
public class ConexaoBanco {

    private static ConexaoBanco instancia = new ConexaoBanco();
    private Connection connection;

    private ConexaoBanco() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/valter_banco", "root", "2429");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Mensagem.alerta("Erro ao conectar-se com a base de dados! \n" + ex);
        }
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
