package modelDao;

import DataBase.Db;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

 public class UsuarioDAO extends DAO {

    public UsuarioDAO() {
        super();
    }
        
        public void inserir(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario (login, email, status, descricao, data_criacao, fk_tipo_usuario ) VALUES (?, ?, ?, ?, ?, ?, now(),?)";

            pst = conector.prepareStatement(sql);

            
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getStatus());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
           
        }
    }

    public static boolean autenticar(String login, String senha){ 
            
        boolean retorno = false;
        try {

            Db myDb = new Db();// conecta com o banco
            String sql = "SELECT usu_codigo AS codigo, usu_login AS login,\n"
                    + " usu_email AS email\n"
                    + "FROM usuario WHERE usu_login = ? AND usu_senha= MD5(?)\n"
                    + "AND usu_status = '1';";

            myDb.setQuerySql(sql);// pede um comando sql
            myDb.setQueryParameter().setString(1, login);
            myDb.setQueryParameter().setString(2, senha);

            ResultSet resultado = myDb.setQueryParameter().executeQuery();

            if (resultado.next()) {
                retorno = true;
            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return retorno;
    }
}

// sql injection

