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
import model.Monthfat;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class MonthDAO extends DAO {

    public MonthDAO() {
        super();
    }

    public static void FillMonInfo(Connection conector, ObservableList<Monthfat> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT mes_cod, "
                    + "mes_nome "
                    + "FROM meses"
            );
            while (resultado.next()) {
                lista.add(
                        new Monthfat(
                                resultado.getInt("mes_cod"),
                                resultado.getString("mes_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonthDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
