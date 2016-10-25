package modelDAO;

import banco.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

///**
// * Possui objetos necessários para implementar os CRUDs a partir da base de
// * dados, através do conector que indicará de qual classe serão chamadas as
// * consultas.
// *
// * @author 
// */
public class DAO {

    protected Connection conector = ConexaoBanco.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement stm;

    public DAO() {
    }
}
