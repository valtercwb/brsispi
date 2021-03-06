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
import model.Cat;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CatDAO {

    public CatDAO() {
        super();
    }

    public static void FillCatInfo(Connection conector, ObservableList<Cat> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT cat_codigo, "
                    + "cat_nome "
                    + "FROM categoria"
            );
            while (resultado.next()) {
                lista.add(
                        new Cat(
                                resultado.getInt("cat_codigo"),
                                resultado.getString("cat_nome")
                        )
                );
            }
        } catch (SQLException e) {
        }
    }
}
