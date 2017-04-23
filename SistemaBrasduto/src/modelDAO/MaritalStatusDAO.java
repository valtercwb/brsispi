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
import model.MaritalStatus;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class MaritalStatusDAO extends DAO {

    public MaritalStatusDAO() {
        super();
    }
public static void FillMarStatusInfo(Connection conector, ObservableList<MaritalStatus> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT est_civil_codigo, "
                    + "est_civil_nome "
                    + "FROM estado_civil"
            );
            while (resultado.next()) {
                lista.add(
                        new MaritalStatus(
                                resultado.getInt("est_civil_codigo"),
                                resultado.getString("est_civil_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
}
