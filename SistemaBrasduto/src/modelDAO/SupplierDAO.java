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
import model.Supplier;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SupplierDAO extends DAO {

    public SupplierDAO() {
        super();
    }

//    public static void FillSupInfo(Connection conector, ObservableList<Supplier> listaSup) {
//        try {
//            Statement stm = conector.createStatement();
//            ResultSet resultado = stm.executeQuery(
//                    "SELECT A.for_codigo,"
//                            + "A.for_nome, "
//                            + "A.for_cnpj, "
//                            + "A.for_telefone, "
//                            + "A.for_email, "
//                            + "A.for_contato, "
//                            + "A.for_tipo_material, "
//                            + "A.for_endereco, "
//                            + "A.for_cep, "
//                            + "A.for_bairro, "
//                            + "A.for_cidade, "                     
//                            + "A.for_estado, "                     
//                            + "A.for_pais "                     
//                            + " FROM fornecedor A"
//            );
//            while (resultado.next()) {
//                listaSup.add(
//                        new Supplier(
//                                resultado.getInt("for_codigo"),
//                                resultado.getString("for_nome"),
//                                resultado.getString("for_cnpj"),
//                                resultado.getString("for_telefone"),
//                                resultado.getString("for_email"),
//                                resultado.getString("for_contato"),
//                                resultado.getString("for_tipo_material"),
//                                resultado.getString("for_endereco"),
//                                resultado.getString("for_cep"),
//                                resultado.getString("for_bairro"),
//                                resultado.getString("for_cidade"),
//                                resultado.getString("for_estado"),
//                                resultado.getString("for_pais"),                                                              
//                                resultado.getDate("for_data"))
//                );
//                        }
//        } catch (SQLException ex) {
//            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    public static void FillBoxSupInfo(Connection conector, ObservableList<Supplier> listaSup) {
      
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT for_codigo,"
                            + "for_nome "
                            + " FROM fornecedor "
            );
            while (resultado.next()) {
                listaSup.add(
                        new Supplier(
                                resultado.getInt("for_codigo"),
                                resultado.getString("for_nome"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
