package model;

import java.util.ArrayList;
import modelDao.UsuarioDAO;


public class Usuario {

    int codigo;
    String login;
    String nome;
    String email;
    String status;
    static ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();//aceita objetos do tipo Usuario

    public Usuario() {
    }

    public Usuario(int codigo, String login, String nome, String email, String status) {
        this.codigo = codigo;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public static boolean logon(String login, String password) {
//
//        boolean retorno = false;
//        try {
//            String sql = "SELECT * FROM usuario WHERE usu_login ='" + login + "' AND usu_senha = MD5('" + password + "')";
//            Db myDb = new Db();
//            ResultSet myResult = myDb.query(sql, 1);
//
//            if (myResult.next()) {
//                retorno = true;
//            }
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return retorno;
//    }

//    public static void getUsersDb(JTable tabela) {
//        DefaultTableModel myModel = (DefaultTableModel)tabela.getModel();
//
//        try {
//            String sql = "SELECT usu_codigo AS'ID', usu_nome AS 'NOME',usu_login AS 'LOGIN', usu_email AS 'E-MAIL', usu_status AS 'SITUAÇÃO' FROM usuario";
//            Db myDb = new Db();
//            ResultSet myResult = myDb.query(sql, 1);
//             //myResult.getFetchSize()//retorna quantas linha tem no resultado
//            ResultSetMetaData myMetadata = myResult.getMetaData();
//            
//            int totalColumns = myMetadata.getColumnCount();
//            
//            for (int i = 1; i <=totalColumns; i++) {
//                myModel.addColumn(myMetadata.getColumnLabel(i));
//            }
//            
//            while(myResult.next())//vai posicionar o cursor na primeira linha de dados e ele retorna um boolean(se a gride estiver vazia ele retorna falso,o ponto next vai para a proxima linha)
//            {
//            Usuario newUser = new Usuario();
//            newUser.setCodigo(myResult.getInt("ID"));
//            newUser.setNome(myResult.getString("NOME"));
//            newUser.setLogin(myResult.getString("LOGIN"));
//            newUser.setEmail(myResult.getString("E-MAIL"));
//            newUser.setStatus(myResult.getString("SITUAÇÃO"));
//            
//            Object[] object = new Object[totalColumns];    
//            
//            for (int i = 0; i < totalColumns; i++) {
//             object[i] = myResult.getObject(i+1);
//               
//            }
//            myModel.addRow(object);
//                       
//            ListaUsuarios.add(newUser);
//        }
//            
//            tabela.setModel(myModel);
//            
//        }  catch (ClassNotFoundException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

 public static boolean logon(String login, String senha) {
        return UsuarioDAO.autenticar(login, senha);
    }
}