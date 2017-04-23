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
import model.EmpStatus;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class EmpStatusDAO extends DAO {

    public EmpStatusDAO() {
        super();
    }

    public static void FillEmpStatusInfo(Connection conector, ObservableList<EmpStatus> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT fun_status_codigo, "
                    + "fun_status_nome "
                    + "FROM fun_status"
            );
            while (resultado.next()) {
                lista.add(
                        new EmpStatus(
                                resultado.getInt("fun_status_codigo"),
                                resultado.getString("fun_status_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
