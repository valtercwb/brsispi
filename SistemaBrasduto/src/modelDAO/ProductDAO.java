/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import database.DAO;
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
import model.Cat;
import model.Product;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ProductDAO extends DAO {

    public static Boolean isUniqCodProStatus = false;

    public ProductDAO() {
        super();
    }

    public void SaveProduct(Connection conector, Product pro) {
        if (isUniqCode(pro)) {
            try {
                pst = conector.prepareStatement("INSERT INTO produto (pro_mat, pro_nome,pro_categoria ,pro_acabamento,pro_quantidade,"
                        + "pro_dimensao,pro_peso, pro_preco_custo,pro_preco_venda,pro_data,pro_foto) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,? )");
                pst.setString(1, pro.getProMat());
                pst.setString(2, pro.getProName());
                pst.setInt(3, pro.getCategory().getCatCode());
                pst.setString(4, pro.getProFin());
                pst.setString(5, pro.getProQtt());
                pst.setString(6, pro.getProDim());
                pst.setString(7, pro.getProWei());
                pst.setString(8, pro.getProCostPrice());
                pst.setString(9, pro.getProSellPrice());
                pst.setDate(10, pro.getProData());
                //pst.setString(13, "1");
                if (pro.imagePath != null) {
                    InputStream is;
                    is = new FileInputStream(new File(pro.imagePath));
                    pst.setBlob(11, is);
                } else {
                    pst.setBlob(11, (Blob) null);
                }
                pst.executeUpdate();
                pst.close();
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int UpdateProduct(Connection conector, Product pro, int resultado) {
        try {
            pst = conector.prepareStatement(
                    "UPDATE produto "
                    + " SET pro_mat = ?,  "
                    + " pro_nome = ?,  "
                    + " pro_categoria= ?, "
                    + " pro_acabamento = ?,  "
                    + " pro_quantidade = ?,  "
                    + " pro_dimensao = ?,  "
                    + " pro_peso = ?,  "
                    + " pro_preco_custo = ?,"
                    + " pro_preco_venda = ?,"
                    + " pro_data = ?,  "
                    + " pro_foto = ?  "
                    + " WHERE pro_codigo = ?"
            );
            pst.setString(1, pro.getProMat());
            pst.setString(2, pro.getProName());
            pst.setInt(3, pro.getCategory().getCatCode());
            pst.setString(4, pro.getProFin());
            pst.setString(5, pro.getProQtt());
            pst.setString(6, pro.getProDim());
            pst.setString(7, pro.getProWei());
            pst.setString(8, pro.getProCostPrice());
            pst.setString(9, pro.getProSellPrice());
            pst.setDate(10, pro.getProData());
            if (pro.imagePath != null) {
                InputStream is;
                is = new FileInputStream(new File(pro.imagePath));
                pst.setBlob(11, is);
            } else if (pro.imagePath == null) {
                pst.setBlob(11, (Blob) null);
            }
            pst.setInt(12, resultado);
            return pst.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int DeleteItem(int resultado) {

        try {
            pst = conector.prepareStatement(
                    "DELETE FROM produto "
                    + "WHERE pro_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void FillProInfo(Connection conector, ObservableList<Product> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.pro_codigo,"
                    + "A.pro_mat, "
                    + "A.pro_nome, "
                    + "A.pro_categoria, "
                    + "B.cat_nome, "
                    + "A.pro_acabamento, "
                    + "A.pro_quantidade, "
                    + "A.pro_dimensao, "
                    + "A.pro_peso, "
                    + "A.pro_preco_custo, "
                    + "A.pro_preco_venda, "
                    + "A.pro_data, "
                    + "A.pro_foto "
                    + "FROM produto A "
                    + "INNER JOIN categoria B "
                    + "ON (A.pro_categoria = B.cat_codigo) "
            );
            while (resultado.next()) {
                lista.add(
                        new Product(
                                resultado.getInt("pro_codigo"),
                                resultado.getString("pro_mat"),
                                resultado.getString("pro_nome"),
                                new Cat(resultado.getInt("pro_categoria"),
                                        resultado.getString("cat_nome")),
                                resultado.getString("pro_acabamento"),
                                resultado.getString("pro_quantidade"),
                                resultado.getString("pro_dimensao"),
                                resultado.getString("pro_peso"),
                                resultado.getString("pro_preco_custo"),
                                resultado.getString("pro_preco_venda"),
                                resultado.getDate("pro_data"),
                                resultado.getBlob("pro_foto"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUniqCode(Product pro) {

        boolean isUniqCode = false;
        isUniqCodProStatus = isUniqCode;
        try {
            pst = conector.prepareStatement("select * from produto where pro_mat = ?");
            pst.setString(1, pro.getProMat());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um produto cadastrado com esse codigo");
                msg.show();
                return isUniqCode;
            }
            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqCodProStatus = isUniqCode;
        } catch (SQLException e) {
        }
        return isUniqCode;
    }
}
