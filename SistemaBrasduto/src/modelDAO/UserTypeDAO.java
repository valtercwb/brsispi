package modelDAO;

import database.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import model.UserType;

public class UserTypeDAO extends DAO {

    public UserTypeDAO() {
        super();
    }

    public static void FillUserTypeInfo(Connection conector, ObservableList<UserType> listaUserType) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT tipo_usu_codigo, "
                    + "tipo_usu_nome "
                    + "FROM tipo_usuario"
            );
            while (resultado.next()) {
                listaUserType.add(
                        new UserType(
                                resultado.getInt("tipo_usu_codigo"),
                                resultado.getString("tipo_usu_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
