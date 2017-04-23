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
import model.City;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CityDAO extends DAO{

    public CityDAO() {
    super();
    }
    
    public static void FillCityInfo(Connection conector, ObservableList<City> listaCity) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT cid_codigo, "
                    + "cid_nome "
                    + "FROM cidade"
            );
            while (resultado.next()) {
                listaCity.add(
                        new City(
                                resultado.getInt("cid_codigo"),
                                resultado.getString("cid_nome")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
