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
import model.Income;
import model.Monthfat;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class IncomeDAO extends DAO {

    public IncomeDAO() {
        super();
    }

    public static void FillIncInfo(Connection conector, ObservableList<Income> listaInc) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.inc_cod,A.inc_mes,B.mes_nome,A.inc_fat,A.inc_fatplan,A.inc_qtdven,A.inc_qtdvenplan FROM income A INNER JOIN meses B ON(A.inc_mes = B.mes_cod)");
            while (resultado.next()) {
                listaInc.add(
                        new Income(
                                resultado.getInt("inc_cod"),
                                new Monthfat(resultado.getInt("inc_mes"),
                                        resultado.getString("mes_nome")),
                                resultado.getDouble("inc_fat"),
                                resultado.getDouble("inc_fatplan"),
                                resultado.getInt("inc_qtdven"),
                                resultado.getInt("inc_qtdvenplan")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SaveIncInput(Connection connection, Income inc) {

        try {
            pst = conector.prepareStatement("INSERT INTO income (inc_mes,inc_fat ,inc_fatplan,inc_qtdven,inc_qtdvenplan)"
                    + "VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, inc.getMonthfat().getMonId());
            pst.setDouble(2, inc.getIncAmount());
            pst.setDouble(3, inc.getIncAmountGoal());
            pst.setInt(4, inc.getIncSaleQtt());
            pst.setInt(5, inc.getIncSaleQttGoal());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int DeleteInc(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM income "
                    + "WHERE inc_cod = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int UpdateInc(Connection conector, Income inc, int resultado) {

        try {
            pst = conector.prepareStatement(
                    "UPDATE income "
                    + " SET inc_mes = ?,  "
                    + " inc_fat= ?, "
                    + " inc_fatplan = ?,  "
                    + " inc_qtdven = ?,  "
                    + " inc_qtdvenplan = ?  "
                    + " WHERE inc_cod = ?"
            );
            pst.setInt(1, inc.getMonthfat().getMonId());
            pst.setDouble(2, inc.getIncAmount());
            pst.setDouble(3, inc.getIncAmountGoal());
            pst.setInt(4, inc.getIncSaleQtt());
            pst.setInt(5, inc.getIncSaleQttGoal());
            pst.setInt(6, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IncomeDAO.class.getName()).log(Level.SEVERE, null, ex);
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao atualizar os dados no banco, contacte o suporte Técnico :)");
            msg.setHeaderText("Resultado:");
            msg.show();
        }
        return 0;
    }
}
