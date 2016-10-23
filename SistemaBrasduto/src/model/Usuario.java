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


    public static boolean logon(String login, String senha) {
        return UsuarioDAO.autenticar(login, senha);
    }
}
