package DataBase;

import java.sql.*;

public class Db {

    private Connection conexao;
    private Statement statement;
    public PreparedStatement preStatement;

    //--------------------------------------------------------------------------
    public void open() throws ClassNotFoundException, SQLException {
        String driver;
        String url;
        String usuario;
        String senha;

        driver = "com.mysql.fabric.jdbc.FabricMySQLDriver";
        url = "jdbc:mysql://172.17.22.65:3306/VALTER";
        usuario = "unicuritiba";
        senha = "unicuritiba";

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        this.conexao = DriverManager.getConnection(url, usuario, senha);
        this.statement = conexao.createStatement();
    }

    //--------------------------------------------------------------------------
    private void close() {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        } catch (Exception error) {
            String mensagem;
            mensagem = "Erro ao fechar a conexão.\n";
            System.out.println(mensagem + error.getMessage());
        }
    }

    //--------------------------------------------------------------------------
    public ResultSet query(String sql, int tipo) throws ClassNotFoundException, SQLException {

        if (this.conexao == null || this.statement == null) {
            open();
        }

        ResultSet result;
        result = null;

        if (tipo == 1) {
            result = this.statement.executeQuery(sql);
        } else {
            statement.executeUpdate(sql);
        }

        return result;
    }
    //--------------------------------------------------------------------------

    public void setQuerySql(String sql) throws ClassNotFoundException, SQLException {
        if (this.conexao == null || this.statement == null) {
            open();
        }

        this.preStatement = this.conexao.prepareStatement(sql);

    }

    //--------------------------------------------------------------------------
    public PreparedStatement setQueryParameter() {

        return this.preStatement;

    }

}
