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
import model.Cat;
import model.Product;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ProductDAO extends DAO {

    public ProductDAO() {
        super();
    }

    public void SaveProduct(Connection conector, Product pro) {
        try {
            pst = conector.prepareStatement("INSERT INTO produto (pro_mat, pro_nome,pro_categoria ,pro_acabamento,pro_quantidade,"
                    + "pro_dimensao,pro_peso, pro_preco_custo,pro_preco_venda,pro_data,pro_image) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? ,? , ?)");
            pst.setInt(1, pro.getProMat());
            pst.setString(2, pro.getProName());
            pst.setInt(3, pro.getCategory().getCatCode());
            pst.setString(4, pro.getProFin());
            pst.setInt(5, pro.getProQtt());
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

    public void UpdateProduct(Connection conector, Product pro, int resultado) {
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
                    + "A.pro_acabamento, "
                    + "A.pro_quantidade, "
                    + "A.pro_dimensao, "
                    + "A.pro_peso, "
                    + "A.pro_preco_custo, "
                    + "A.pro_preco_venda, "
                    + "A.pro_data, "
                    + "A.pro_image, "
                    + "B.cat_nome "
                    + "FROM produto A "
                    + "INNER JOIN categoria B "
                    + "ON (A.pro_categoria = B.cat_code) "
            );
            while (resultado.next()) {
                lista.add(
                        new Product(
                                resultado.getInt("pro_codigo"),
                                resultado.getInt("pro_mat"),
                                resultado.getString("pro_nome"),
                                new Cat(resultado.getInt("cat_code"),
                                        resultado.getString("cat_nome")),
                                resultado.getString("pro_acabamento"),
                                resultado.getInt("pro_quantidade"),
                                resultado.getString("pro_dimensao"),
                                resultado.getString("pro_peso"),
                                resultado.getString("pro_preco_custo"),
                                resultado.getString("pro_preco_venda"),
                                resultado.getDate("ins_data"),
                                resultado.getBlob("ins_image"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
