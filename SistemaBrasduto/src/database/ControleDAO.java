package database;

import modelDAO.EscDAO;
import modelDAO.ItemDAO;
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
    private EscDAO escDAO = new EscDAO();
    private ItemDAO itemDAO = new ItemDAO();

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public static ControleDAO getBanco() {
        return banco;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public EscDAO getEscDAO() {
        return escDAO;
    }

}
