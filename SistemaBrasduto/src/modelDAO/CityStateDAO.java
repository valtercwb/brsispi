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
import model.CityState;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CityStateDAO extends DAO {

    public CityStateDAO() {
        super();
    }

    public static void FillCtStateInfo(Connection conector, ObservableList<CityState> listaCtState) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT est_codigo, "
                    + "est_nome "
                    + "FROM estado"
            );
            while (resultado.next()) {
                listaCtState.add(
                        new CityState(
                                resultado.getInt("est_codigo"),
                                resultado.getString("est_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
