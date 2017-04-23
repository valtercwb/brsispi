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
import model.Dep;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class DepDAO extends DAO {

    public DepDAO() {
        super();
    }

    public static void FillDepInfo(Connection conector, ObservableList<Dep> lista) {
    
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT dep_codigo, "
                            + "dep_nome "
                            + "FROM departamento"
            );
            while (resultado.next()) {
                lista.add(
                        new Dep(
                                resultado.getInt("dep_codigo"),
                                resultado.getString("dep_nome")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
