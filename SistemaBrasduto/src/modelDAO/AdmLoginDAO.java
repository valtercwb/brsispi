/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import java.sql.SQLException;
import javafx.scene.control.Alert;
import service.Criptografia;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class AdmLoginDAO extends DAO {

    public AdmLoginDAO() {
        super();
    }

    public boolean autenticarUsername(String login) {
        //AND usu_status = 1
        try {
            String sql = "SELECT usu_login FROM usuario WHERE usu_login = ? and usu_status= 1 and usu_tipo = 2 ";

            pst = conector.prepareStatement(sql);
            pst.setString(1, login);
            rs = pst.executeQuery();

            if (rs.next()) {
                return login.equals(rs.getString(1));
            }

            pst.close();
            rs.close();

        } catch (SQLException ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao autenticar nome administrador na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
        }

        return false;
    }

    public boolean autenticarSenha(String login, String senha) {
        System.out.println(senha);
        String chave = Criptografia.converter(senha);
        System.out.println(chave);
        try {
            String sql = "SELECT usu_login, usu_senha FROM usuario WHERE usu_login=? AND usu_senha=? and usu_tipo = 2";

            pst = conector.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, chave);
            rs = pst.executeQuery();

            while (rs.next()) {
                return rs.getString(1).equals(login) && rs.getString(2).equals(chave);
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao autenticar a senha do administrador na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
        }
        return false;
    }

//    public void inserir(User user) throws SQLException {
//
//        try {
//           msg.show();
//       }
//            String sql = "INSERT INTO usuario (usu_nome, usu_login, usu_senha) VALUES (?, ?,MD5(?),?,?)";
//
//            pst = conector.prepareStatement(sql);
//            // set parameters, then execute insertNewPerson
//            pst.setString(1, user.getAdmName());
//            pst.setString(2, user.getAdmLogin());
//            pst.setString(3, adm.getAdmSenha());
//            pst.executeUpdate();
//            pst.close();
//        } catch (SQLException ex) {
//            Alert msg = new Alert(Alert.AlertType.ERROR);
//            msg.setTitle("Deu ruim!");
//            msg.setContentText("Aconteceu um erro ao inserir administrador na base de dados! \n");
//            msg.setHeaderText("Resultado:");
//            msg.show();
//        }
//        System.out.println("Administrador inserido com sucesso");
//
//    }

//    public void editar(Adm adm) {
//        try {
//            String sql = "UPDATE adm SET nome =?, login =?, senha =?  WHERE adm =?";
//
//            pst = conector.prepareStatement(sql);
//
//            pst.setString(1, adm.getAdmName());
//            pst.setString(2, adm.getAdmLogin());
//            pst.setString(3, adm.getAdmSenha());
//            pst.executeUpdate();
//            pst.close();
//
//        } catch (SQLException ex) {
//            Alert msg = new Alert(Alert.AlertType.ERROR);
//            msg.setTitle("Deu ruim!");
//            msg.setContentText("Aconteceu um erro ao atualizar administrador na base de dados! \n");
//            msg.setHeaderText("Resultado:");
//            msg.show();
//        }
//    }
}
