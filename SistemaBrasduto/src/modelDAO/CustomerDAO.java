/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import database.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.CusStatus;
import model.Customer;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CustomerDAO extends DAO {

    public static boolean isUniqStatus = false;

    public CustomerDAO() {
        super();
    }

    public static void FillCustomerInfo(Connection conector, ObservableList<Customer> listaC) {
        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.cli_codigo,"
                    + "A.cli_nome, "
                    + "A.cli_cnpj, "
                    + "A.cli_telefone, "
                    + "A.cli_email, "
                    + "A.cli_status, "
                    + "B.sit_cli_nome, "
                    + "A.cli_endereco, "
                    + "A.cli_cep, "
                    + "A.cli_cidade, "
                    + "A.cli_estado, "
                    + "A.cli_pais, "
                    + "A.cli_data "
                    + "FROM cliente A "
                    + "INNER JOIN situacaocli B "
                    + "ON (A.cli_status = B.sit_cli_codigo) "
            );
            while (resultado.next()) {
                listaC.add(
                        new Customer(
                                resultado.getInt("cli_codigo"),
                                resultado.getString("cli_nome"),
                                resultado.getString("cli_cnpj"),
                                resultado.getString("cli_telefone"),
                                resultado.getString("cli_email"),
                                new CusStatus(resultado.getInt("cli_status"),
                                        resultado.getString("sit_cli_nome")),
                                resultado.getString("cli_endereco"),
                                resultado.getString("cli_cep"),
                                resultado.getString("cli_cidade"),
                                resultado.getString("cli_estado"),
                                resultado.getString("cli_pais"),
                                resultado.getDate("cli_data"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int DeleteItem(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM cliente "
                    + "WHERE cli_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int UpdateCustomer(Connection conector, Customer customer, int resultado) {
        if (isUniqCnpj(customer)) {
        try {
            pst = conector.prepareStatement(
                    "UPDATE cliente "
                    + " SET cli_nome = ?,  "
                    + " cli_cnpj= ?, "
                    + " cli_telefone = ?,  "
                    + " cli_email = ?,  "
                    + " cli_status = ?,  "
                    + " cli_endereco = ?,  "
                    + " cli_cep = ?,  "
                    + " cli_cidade = ?,  "
                    + " cli_estado = ?,  "
                    + " cli_pais= ?, "
                    + " cli_data = ?  "
                    + " WHERE cli_codigo = ?"
            );
            pst.setString(1, customer.getCusName());
            pst.setString(2, customer.getCusCnpj());
            pst.setString(3, customer.getCusPhone());
            pst.setString(4, customer.getCusEmail());
            pst.setInt(5, customer.getCusStatus().getCusStaId());
            pst.setString(6, customer.getCusAdress());
            pst.setString(7, customer.getCusZipCode());
            pst.setString(8, customer.getCusCity());
            pst.setString(9, customer.getCusState());
            pst.setString(10, customer.getCusCountry());
            pst.setDate(11, customer.getCusDate());
            pst.setInt(12, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }else{return 0;}
    }

    public void SaveCustomer(Connection conector, Customer customer) {

        if (isUniqCnpj(customer)) {

            try {
                pst = conector.prepareStatement("INSERT INTO cliente (cli_nome,cli_cnpj ,cli_telefone,cli_email,"
                        + "cli_status,cli_endereco,cli_cep, cli_cidade,cli_estado,cli_pais,cli_data) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,?)");
                pst.setString(1, customer.getCusName());
                pst.setString(2, customer.getCusCnpj());
                pst.setString(3, customer.getCusPhone());
                pst.setString(4, customer.getCusEmail());
                pst.setInt(5, customer.getCusStatus().getCusStaId());
                pst.setString(6, customer.getCusAdress());
                pst.setString(7, customer.getCusZipCode());
                pst.setString(8, customer.getCusCity());
                pst.setString(9, customer.getCusState());
                pst.setString(10, customer.getCusCountry());
                pst.setDate(11, customer.getCusDate());
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isUniqCnpj(Customer customer) {
        
        boolean isUniqCnpj = false;
        isUniqStatus = isUniqCnpj;
        try {
            pst = conector.prepareStatement("select * from cliente where cli_cnpj = ?");
            pst.setString(1,customer.getCusCnpj());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um Cliente cadastrado com esse Cnpj");
                msg.setTitle("Opa cuidado!");
                msg.show();
                return isUniqCnpj;
            }
            rs.close();
            pst.close();
            isUniqCnpj = true;
            isUniqStatus = isUniqCnpj;
        } catch (SQLException e) {
        }
        return isUniqCnpj;
    }
}
