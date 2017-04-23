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
import model.Gen;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class GenDAO extends DAO {

    public GenDAO() {
        super();
    }

    public static void FillGenInfo(Connection conector, ObservableList<Gen> lista) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT gen_codigo, "
                    + "gen_nome "
                    + "FROM genero"
            );
            while (resultado.next()) {
                lista.add(
                        new Gen(
                                resultado.getInt("gen_codigo"),
                                resultado.getString("gen_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
