package modelDao;

import DataBase.Db;
import java.sql.ResultSet;

public class UsuarioDAO {

    public static boolean autenticar(String login, String senha) {
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

