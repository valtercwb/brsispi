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
import javafx.collections.ObservableList;
import model.SchLevel;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SchLevelDAO extends DAO {

    public SchLevelDAO() {
        super();
    }
public static void FillSchLevelInfo(Connection conector, ObservableList<SchLevel> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT esc_codigo, "
                    + "esc_nome "
                    + "FROM escolaridade"
            );
            while (resultado.next()) {
                lista.add(
                        new SchLevel(
                                resultado.getInt("esc_codigo"),
                                resultado.getString("esc_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}
