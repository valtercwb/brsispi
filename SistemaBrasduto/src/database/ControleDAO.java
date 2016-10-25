package database;

import modelDAO.LoginDAO;
import modelDAO.UsuarioDAO;

/**
 * Classe responsável por realizar o controle dos objetos DAO que contém os CRUDs e diversas operações na base de dados, filtrando a criação desses objetos.
 *
 * @autor valter.franco
 */
public class ControleDAO {

    private static ControleDAO banco = new ControleDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private LoginDAO loginDAO = new LoginDAO();

    public static ControleDAO getBanco() {
        return banco;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

}
