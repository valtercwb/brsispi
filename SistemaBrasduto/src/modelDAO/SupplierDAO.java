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
import javafx.scene.control.Alert;
import model.Supplier;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SupplierDAO extends DAO {
   
    public static boolean isUniqSupStatus = false;

    public SupplierDAO() {
        super();
    }

    public static void FillSupInfo(Connection conector, ObservableList<Supplier> listaSup) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.for_codigo,"
                    + "A.for_nome, "
                    + "A.for_cnpj, "
                    + "A.for_telefone, "
                    + "A.for_email, "
                    + "A.for_contato, "
                    + "A.for_tipo_material, "
                    + "A.for_endereco, "
                    + "A.for_cep, "
                    + "A.for_bairro, "
                    + "A.for_cidade, "
                    + "A.for_estado, "
                    + "A.for_pais "
                    + " FROM fornecedor A"
            );
            while (resultado.next()) {
                listaSup.add(
                        new Supplier(
                                resultado.getInt("for_codigo"),
                                resultado.getString("for_nome"),
                                resultado.getString("for_cnpj"),
                                resultado.getString("for_telefone"),
                                resultado.getString("for_email"),
                                resultado.getString("for_contato"),
                                resultado.getString("for_tipo_material"),
                                resultado.getString("for_endereco"),
                                resultado.getString("for_cep"),
                                resultado.getString("for_bairro"),
                                resultado.getString("for_cidade"),
                                resultado.getString("for_estado"),
                                resultado.getString("for_pais"),
                                resultado.getDate("for_data"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public int DeleteSup(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM fornecedor "
                    + "WHERE for_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int UpdateSup(Connection conector, Supplier supplier, int resultado) {
        try {
            pst = conector.prepareStatement(
                    "UPDATE fornecedor "
                    + " SET for_nome = ?,  "
                    + " for_cnpj= ?, "
                    + " for_telefone = ?,  "
                    + " for_email = ?,  "
                    + " for_contato = ?,  "
                    + " for_tipo_material = ?,  "
                    + " for_endereco = ?,  "
                    + " for_cep = ?,  "
                    + " for_bairro = ?,  "
                    + " for_cidade = ?,  "
                    + " for_estado = ?,  "
                    + " for_pais= ?, "
                    + " for_data = ?  "
                    + " WHERE for_codigo = ?"
            );
            pst.setString(1, supplier.getSupName());
            pst.setString(2, supplier.getSupCtr());
            pst.setString(3, supplier.getSupPhone());
            pst.setString(4, supplier.getSupEmail());
            pst.setString(5, supplier.getSupContact());
            pst.setString(6, supplier.getSupMatTyp());
            pst.setString(7, supplier.getSupAdress());
            pst.setString(8, supplier.getSupZipCode());
            pst.setString(9, supplier.getSupSub());
            pst.setString(10, supplier.getSupCity());
            pst.setString(11, supplier.getSupState());
            pst.setString(12, supplier.getSupCountry());
            pst.setDate(13, supplier.getSupDate());
            pst.setInt(14, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void SaveSup(Connection conector, Supplier supplier) {
        if (isUniqCtr(supplier)) {

            try {
                pst = conector.prepareStatement("INSERT INTO fornecedor (for_nome,for_cnpj ,for_telefone,for_email,"
                        + "for_contato,for_tipo_material,for_endereco,for_cep,for_bairro, for_cidade,for_estado,for_pais,for_data) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,?)");
                pst.setString(1, supplier.getSupName());
                pst.setString(2, supplier.getSupCtr());
                pst.setString(3, supplier.getSupPhone());
                pst.setString(4, supplier.getSupEmail());
                pst.setString(5, supplier.getSupContact());
                pst.setString(6, supplier.getSupMatTyp());
                pst.setString(7, supplier.getSupAdress());
                pst.setString(8, supplier.getSupZipCode());
                pst.setString(9, supplier.getSupSub());
                pst.setString(10, supplier.getSupCity());
                pst.setString(11, supplier.getSupState());
                pst.setString(12, supplier.getSupCountry());
                pst.setDate(13, supplier.getSupDate());
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

public boolean isUniqCtr(Supplier supplier) {
        
        boolean isUniqCtr = false;
        isUniqSupStatus = isUniqCtr;
        try {
            pst = conector.prepareStatement("select * from fornecedor where for_cnpj = ?");
            pst.setString(1,supplier.getSupCtr());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um Fornecedor cadastrado com esse Cnpj");
                msg.setTitle("Opa cuidado!");
                msg.show();
                return isUniqCtr;
            }
            rs.close();
            pst.close();
            isUniqCtr = true;
            isUniqSupStatus = isUniqCtr;
        } catch (SQLException e) {
        }
        return isUniqCtr;
    }
}
