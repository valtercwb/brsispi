/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import model.UserStatus;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class UserStatusDAO extends DAO {

    public UserStatusDAO() {
        super();
    }
    
     public static void FillUserStaInfo(Connection conector, ObservableList<UserStatus> lista) {
    
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT usu_sta_codigo, "
                            + "usu_sta_nome "
                            + "FROM usuario_status"
            );
            while (resultado.next()) {
                lista.add(
                        new UserStatus(
                                resultado.getInt("usu_sta_codigo"),
                                resultado.getString("usu_sta_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
