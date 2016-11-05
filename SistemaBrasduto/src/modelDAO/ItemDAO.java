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
import model.Item;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemDAO extends DAO {

    public ItemDAO() {
        super();
    }

    public void SaveInput(Item item) {
        try {
            pst = conector.prepareStatement("INSERT INTO insumo (ins_code, ins_nome,ins_local ,ins_material, "
                    + "ins_preco, ins_quantidade, ins_qtd_usu_diario,ins_peso,ins_dimensao,ins_data) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?)");
            pst.setInt(1, item.getItemCode());
            pst.setString(2, item.getItemName());
            pst.setString(3, item.getItemLocal());
            pst.setString(4, item.getItemMatter());
            pst.setString(5, item.getItemPrice());
            pst.setInt(6, item.getItemQtd());
            pst.setInt(7, item.getItemQtdDay());
            pst.setString(8, item.getItemWeight());
            pst.setString(9, item.getItemDim());
            pst.setDate(10, item.getItemDate());
//            if (item.imagePath != null) {
//                InputStream is;
//                is = new FileInputStream(new File(item.imagePath));
//                pst.setBlob(11, is);
//            } else {
//                pst.setBlob(11, (Blob) null);
//            }
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   public int UpdateItem(Item item,int resultado) {

        try {
            pst = conector.prepareStatement(
                    "UPDATE insumo "
                            + " SET ins_code = ?,  "
                            + " ins_nome = ?,  "
                            + " ins_local= ?, "
                            + " ins_material = ?,  "
                            + " ins_preco = ?, "
                            + " ins_quantidade = ?,  "
                            + " ins_qtd_usu_diario = ?,  "
                            + " ins_peso = ?,  "
                            + " ins_dimensao = ?,  "
                            + " ins_data = ?  "
                            + " WHERE ins_codigo = ?"
            );
            pst.setInt(1, item.getItemCode());
            pst.setString(2, item.getItemName());
            pst.setString(3, item.getItemLocal());
            pst.setString(4, item.getItemMatter());
            pst.setString(5, item.getItemPrice());
            pst.setInt(6, item.getItemQtd());
            pst.setInt(7, item.getItemQtdDay());
            pst.setString(8, item.getItemWeight());
            pst.setString(9, item.getItemDim());
            pst.setDate(10, item.getItemDate());
            pst.setInt(11, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
   }

    public int DeleteItem(int resultado) {
        try {
            pst= conector.prepareStatement(
                    "DELETE FROM insumo "+
                            "WHERE ins_codigo = ?"
            );
            pst.setInt(1,resultado);
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
                    "SELECT ins_codigo,"
                    + "ins_code, "
                    + "ins_nome, "
                    + "ins_local, "
                    + "ins_material, "
                    + "ins_preco, "
                    + "ins_quantidade, "
                    + "ins_qtd_usu_diario, "
                    + "ins_peso, "
                    + "ins_dimensao, "
                    + "ins_data "
                    + " FROM insumo"
            );
            while (resultado.next()) {
                lista.add(
                        new Item(
                                resultado.getInt("ins_codigo"),
                                resultado.getInt("ins_code"),
                                resultado.getString("ins_nome"),
                                resultado.getString("ins_local"),
                                resultado.getString("ins_material"),
                                resultado.getString("ins_preco"),
                                resultado.getInt("ins_quantidade"),
                                resultado.getInt("ins_qtd_usu_diario"),
                                resultado.getString("ins_peso"),
                                resultado.getString("ins_dimensao"),
                                resultado.getDate("ins_data"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
