/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import database.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import model.CusStatus;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CusStaDAO extends DAO {

    public CusStaDAO() {
        super();
    }

    public static void FillCusStaInfo(Connection conector, ObservableList<CusStatus> listaCusStatus) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT sit_cli_codigo, "
                    + "sit_cli_nome "
                    + "FROM situacaocli"
            );
            while (resultado.next()) {
                listaCusStatus.add(
                        new CusStatus(
                                resultado.getInt("sit_cli_codigo"),
                                resultado.getString("sit_cli_nome")
                        )
                );
            }
        } catch (SQLException e) {
        }
    }
}
