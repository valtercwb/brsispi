/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.Item;
import model.Matter;
import model.Sector;
import model.Supplier;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemDAO extends DAO {

    public static Boolean isUniqItemCodStatus = false;

    public ItemDAO() {
        super();
    }

    public void SaveInput(Connection conector, Item item) {
        if (isUniqCode(item)) {
            try {
                pst = conector.prepareStatement("INSERT INTO insumo (ins_code, ins_nome,ins_local ,ins_material,ins_setor,"
                        + "ins_fornecedor,ins_dimensao, ins_quantidade, ins_qtd_uso_diario,ins_peso,ins_preco,ins_data,ins_image) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,? , ?,?)");
                pst.setString(1, item.getItemCode());
                pst.setString(2, item.getItemName());
                pst.setString(3, item.getItemLocal());
                pst.setInt(4, item.getMatter().getMatId());
                pst.setInt(5, item.getSector().getSecId());
                pst.setInt(6, item.getSupplier().getSupId());
                pst.setString(7, item.getItemDim());
                pst.setInt(8, item.getItemQtt());
                pst.setInt(9, item.getItemQttDay());
                pst.setString(10, item.getItemWei());
                pst.setString(11, item.getItemPrice());
                pst.setDate(12, item.getItemDate());
                //pst.setString(13, "1");
                if (item.imagePath != null) {
                    InputStream is;
                    is = new FileInputStream(new File(item.imagePath));
                    pst.setBlob(13, is);
                } else {
                    pst.setBlob(13, (Blob) null);
                }
                pst.executeUpdate();
                pst.close();
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int UpdateItem(Connection conector, Item item, int resultado) {
        if (isUniqCodeUp(item, resultado)) {
            try {
                pst = conector.prepareStatement(
                        "UPDATE insumo "
                        + " SET ins_code = ?,  "
                        + " ins_nome = ?,  "
                        + " ins_local= ?, "
                        + " ins_material = ?,  "
                        + " ins_setor = ?,  "
                        + " ins_fornecedor = ?,  "
                        + " ins_dimensao = ?,  "
                        + " ins_quantidade = ?,  "
                        + " ins_qtd_uso_diario = ?,  "
                        + " ins_peso = ?,  "
                        + " ins_preco = ?, "
                        + " ins_data = ?,  "
                        + " ins_image = ?  "
                        + " WHERE ins_codigo = ?"
                );
                pst.setString(1, item.getItemCode());
                pst.setString(2, item.getItemName());
                pst.setString(3, item.getItemLocal());
                pst.setInt(4, item.getMatter().getMatId());
                pst.setInt(5, item.getSector().getSecId());
                pst.setInt(6, item.getSupplier().getSupId());
                pst.setString(7, item.getItemDim());
                pst.setInt(8, item.getItemQtt());
                pst.setInt(9, item.getItemQttDay());
                pst.setString(10, item.getItemWei());
                pst.setString(11, item.getItemPrice());
                pst.setDate(12, item.getItemDate());
                if (item.imagePath != null) {
                    InputStream is;
                    is = new FileInputStream(new File(item.imagePath));
                    pst.setBlob(13, is);
                } else if (item.imagePath == null) {
                    pst.setBlob(13, (Blob) null);
                }
                pst.setInt(14, resultado);
                return pst.executeUpdate();
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("Deu ruim!");
                msg.setContentText("Aconteceu um erro ao atualizar os dados no banco, contacte o suporte Técnico :)");
                msg.setHeaderText("Resultado:");
                msg.show();
            }
           }
        return 0;
    }

    public int DeleteItem(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM insumo "
                    + "WHERE ins_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void FillItemInfo(Connection conector, ObservableList<Item> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.ins_codigo,"
                    + "A.ins_code, "
                    + "A.ins_nome, "
                    + "A.ins_local, "
                    + "A.ins_material, "
                    + "A.ins_setor, "
                    + "A.ins_fornecedor, "
                    + "A.ins_dimensao, "
                    + "A.ins_quantidade, "
                    + "A.ins_qtd_uso_diario, "
                    + "A.ins_peso, "
                    + "A.ins_preco, "
                    + "A.ins_data, "
                    + "A.ins_image, "
                    + "B.mat_nome, "
                    + "C.set_nome, "
                    + "D.for_nome "
                    + "FROM insumo A "
                    + "INNER JOIN material B "
                    + "ON (A.ins_material = B.mat_codigo) "
                    + "INNER JOIN setor C "
                    + "ON (A.ins_setor = C.set_codigo) "
                    + "INNER JOIN fornecedor D "
                    + "ON (A.ins_fornecedor = D.for_codigo) "
            );
            while (resultado.next()) {
                lista.add(
                        new Item(
                                resultado.getInt("ins_codigo"),
                                resultado.getString("ins_code"),
                                resultado.getString("ins_nome"),
                                resultado.getString("ins_local"),
                                new Matter(resultado.getInt("ins_material"),
                                        resultado.getString("mat_nome")),
                                new Sector(resultado.getInt("ins_setor"),
                                        resultado.getString("set_nome")),
                                new Supplier(resultado.getInt("ins_fornecedor"),
                                        resultado.getString("for_nome")),
                                resultado.getString("ins_dimensao"),
                                resultado.getInt("ins_quantidade"),
                                resultado.getInt("ins_qtd_uso_diario"),
                                resultado.getString("ins_peso"),
                                resultado.getString("ins_preco"),
                                resultado.getDate("ins_data"),
                                resultado.getBlob("ins_image"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUniqCode(Item item) {

        boolean isUniqCode = false;
        isUniqItemCodStatus = isUniqCode;
        try {
            pst = conector.prepareStatement("select * from insumo where ins_code = ?");
            pst.setString(1, item.getItemCode());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um item cadastrado com esse codigo");
                msg.show();
                return isUniqCode;
            }
            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqItemCodStatus = isUniqCode;
        } catch (SQLException e) {
        }
        return isUniqCode;
    }

    public boolean isUniqCodeUp(Item item, int resultado) {

        boolean isUniqCode = false;
        isUniqItemCodStatus = isUniqCode;
        try {
            pst = conector.prepareStatement("SELECT ins_codigo, ins_code FROM sistemabrasduto.insumo where ins_code ='?' and not ins_codigo =? ");
            pst.setString(1, item.getItemCode());
            pst.setInt(2, resultado);
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um item cadastrado com esse codigo");
                msg.show();
                return isUniqCode;
            }
            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqItemCodStatus = isUniqCode;
        } catch (SQLException e) {
        }
        return isUniqCode;
    }
}
