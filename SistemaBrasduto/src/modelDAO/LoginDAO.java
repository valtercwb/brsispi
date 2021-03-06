package modelDAO;

import java.sql.SQLException;
import javafx.scene.control.Alert;
import service.Criptografia;

/**
 * DAO responsável pela ações realizadas na base de dados referentes as login do usuário
 */
public class LoginDAO extends DAO {

    public LoginDAO() {
        super();
    }

    /**
     * Autenticar e validar nome do usuário informado
     */
    public boolean autenticarUsername(String login) {
//AND usu_status = 1
        try {
            String sql = "SELECT usu_login,usu_status FROM usuario WHERE usu_login=? and usu_tipo = 1  ";

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
            msg.setContentText("Aconteceu um erro ao autenticar nome usuário na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();

        }

        return false;
    }

    /**
     * Autenticar e validar senha do usuário informada
     */
    public boolean autenticarSenha(String login, String senha) {
        System.out.println(senha);
        String chave = Criptografia.converter(senha);
        System.out.println(chave);
        try {
            String sql = "SELECT usu_login, usu_senha FROM usuario WHERE usu_login=? AND usu_senha=? ";

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
            msg.setContentText("Aconteceu um erro ao autenticar senha usuário na base de dados!");
            msg.setHeaderText("Resultado:");
            msg.show();
        }

        return false;
    }

    /**
     * Consultar informações do usuário logado na base de dados
     */
//    public Usuario usuarioLogado(String login) {
//
//        Usuario user = null;
//
//        try {
//            String sql = "SELECT usuario.id_usuario, usuario.nome, usuario.login, usuario.senha, usuario.email, usuario.status, usuario.data_criacao, usuario.descricao, tipo.id_tipo_usuario, tipo.nome "
//                    + "FROM tb_usuario AS usuario , tb_tipo_usuario AS tipo "
//                    + "WHERE usuario.login=? "
//                    + "AND tipo.id_tipo_usuario = usuario.fk_tipo_usuario";
//
//            stm = conector.prepareStatement(sql);
//            stm.setString(1, login);
//            rs = stm.executeQuery();
//
//            while (rs.next()) {
//                TipoUsuario tipo = new TipoUsuario(rs.getInt(9), rs.getString(10));
//                user = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6) == 1 ? true : false, null, rs.getString(8), tipo);
//                user.setDataCriacao(Tempo.toDate(rs.getTimestamp(7)));
//            }
//            stm.close();
//            rs.close();
//
//        } catch (SQLException ex) {
//            Mensagem.erro("Erro ao consultar usuário logado na base de dados! \n" + ex);
//        }
//
//        return user;
//    }
}
