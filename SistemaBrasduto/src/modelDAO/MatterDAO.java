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
import model.Matter;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class MatterDAO extends DAO {

    public MatterDAO() {
        super();
    }

    public static void FillMatInfo(Connection conector, ObservableList<Matter> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT mat_codigo, "
                    + "mat_nome "
                    + "FROM material"
            );
            while (resultado.next()) {
                lista.add(
                        new Matter(
                                resultado.getInt("mat_codigo"),
                                resultado.getString("mat_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
