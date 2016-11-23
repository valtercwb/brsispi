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
import model.Country;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CountryDAO extends DAO {

    public CountryDAO() {
        super();
    }

    public static void FillCouInfo(Connection conector, ObservableList<Country> listaCountry) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT pais_codigo, "
                    + "pais_nome "
                    + "FROM pais"
            );
            while (resultado.next()) {
                listaCountry.add(
                        new Country(
                                resultado.getInt("pais_codigo"),
                                resultado.getString("pais_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
