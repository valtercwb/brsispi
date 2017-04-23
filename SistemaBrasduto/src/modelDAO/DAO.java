package modelDAO;

import database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//  Possui objetos necessários para implementar os CRUDs a partir da base de
// dados, através do conector que indicará de qual classe serão chamadas as
//  consultas.
// 
//  @author valter.franco 
    public class DAO{

    protected Connection conector = DbConnection.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement pst;
    protected Statement stm;

    public DAO() {
    }
}
