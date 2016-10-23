package modelDao;

import DataBase.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    
    protected Connection conector = Db.instancia().getConnection();
    protected ResultSet rs;
    protected PreparedStatement pst;

    public DAO() {
    }
}
