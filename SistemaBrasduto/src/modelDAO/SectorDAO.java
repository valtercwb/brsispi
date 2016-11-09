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
import model.Sector;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SectorDAO extends DAO {

    public SectorDAO() {
        super();
    }

    public static void FillSecInfo(Connection conector, ObservableList<Sector> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT set_codigo, "
                    + "set_nome "
                    + "FROM setor"
            );
            while (resultado.next()) {
                lista.add(
                        new Sector(
                                resultado.getInt("set_codigo"),
                                resultado.getString("set_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SectorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
