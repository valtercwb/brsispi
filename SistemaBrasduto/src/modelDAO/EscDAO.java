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
import model.Esc;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class EscDAO extends DAO {

    public EscDAO() {
        super();
    }

    public static void FillInfo(Connection conector, ObservableList<Esc> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT esc_codigo, "
                    + "esc_nome "
                    + "FROM escolaridade"
            );
            while (resultado.next()) {
                lista.add(
                        new Esc(
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