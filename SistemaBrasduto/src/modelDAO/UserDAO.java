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
import model.User;
import model.UserStatus;
import model.UserType;

public class UserDAO extends DAO {

    public static boolean isUniqUserLogin = false;

    public UserDAO() {
        super();
    }

    public void SaveUser(Connection conector, User user) throws SQLException {
        if (isUniqUser(user)) {
            try {
                String sql = "INSERT INTO Usuario (usu_nome, usu_login, usu_senha,usu_status,usu_tipo) VALUES (?, ?,MD5(?),?,?)";

                pst = conector.prepareStatement(sql);
                // set parameters, then execute insertNewPerson
                pst.setString(1, user.getUserName());
                pst.setString(2, user.getUserLogin());
                pst.setString(3, user.getUserSenha());
                pst.setInt(4, user.getUserStatus().getUserStatusId());
                pst.setInt(5, user.getUserType().getUserTypId());
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("Deu ruim!");
                msg.setContentText("Aconteceu um erro ao inserir usuário na base de dados!");
                msg.setHeaderText("Resultado:");
                msg.show();
            }
        }
    }

    public int editUser(Connection conector, User user, int resultado) {
        try {
            String sql = "UPDATE usuario SET usu_nome =?, usu_login =?, usu_senha =MD5(?), usu_status =?, usu_tipo =? WHERE usu_codigo =?";

            pst = conector.prepareStatement(sql);

            pst.setString(1, user.getUserName());
            pst.setString(2, user.getUserLogin());
            pst.setString(3, user.getUserSenha());
            pst.setInt(4, user.getUserStatus().getUserStatusId());
            pst.setInt(5, user.getUserType().getUserTypId());
            pst.setInt(6, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao atualizar usuário na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
            return 0;
        }
    }

    /**
     * Delete user
     */
    public int DeleteUser(int resultado) {
        try {
            pst = conector.prepareStatement(
                    "DELETE FROM usuario "
                    + "WHERE usu_codigo = ?"
            );
            pst.setInt(1, resultado);
            return pst.executeUpdate();

        } catch (SQLException ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao excluir usuário na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
            return 0;
        }
    }

    //  Verificar se usuário já está registrado na base de dados atravês do login
    public boolean isUniqUser(User user) {

        boolean isUniqCode = false;
        isUniqUserLogin = isUniqCode;
        try {
            pst = conector.prepareStatement("select * from usuario where usu_login = ?");
            pst.setString(1, user.getUserLogin());
            rs = pst.executeQuery();
            while (rs.next()) {
                Alert msg = new Alert(Alert.AlertType.WARNING);
                msg.setHeaderText("Aviso");
                msg.setContentText("Já existe um usuario cadastrado com esse login");
                msg.show();
                return isUniqCode;
            }
            rs.close();
            pst.close();
            isUniqCode = true;
            isUniqUserLogin = isUniqCode;
        } catch (SQLException e) {
        }
        return isUniqCode;

    }

    public static void FillUserInfo(Connection conector, ObservableList<User> lista) {

        try {
            Statement stm = conector.createStatement();
            ResultSet resultado = stm.executeQuery(
                    "SELECT A.usu_codigo,"
                    + "A.usu_nome, "
                    + "A.usu_login, "
                    + "A.usu_senha, "
                    + "A.usu_status, "
                    + "B.usu_sta_nome, "
                    + "A.usu_tipo, "
                    + "C.tipo_usu_nome "
                    + "FROM sistemabrasduto.usuario A "
                    + "INNER JOIN usuario_status B "
                    + "ON (A.usu_status = B.usu_sta_codigo) "
                    + "INNER JOIN tipo_usuario C "
                    + "ON (A.usu_tipo = C.tipo_usu_codigo) "
            );
            while (resultado.next()) {
                lista.add(
                        new User(
                                resultado.getInt("usu_codigo"),
                                resultado.getString("usu_nome"),
                                resultado.getString("usu_login"),
                                resultado.getString("usu_senha"),
                                new UserStatus(resultado.getInt("usu_status"),
                                        resultado.getString("usu_sta_nome")),
                                new UserType(resultado.getInt("usu_tipo"),
                                        resultado.getString("tipo_usu_nome")))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
