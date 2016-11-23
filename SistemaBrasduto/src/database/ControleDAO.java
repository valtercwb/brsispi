package database;

import modelDAO.CatDAO;
import modelDAO.CusStaDAO;
import modelDAO.CustomerDAO;
import modelDAO.EmpDAO;
import modelDAO.EmpStatusDAO;
import modelDAO.GenDAO;
import modelDAO.ItemDAO;
import modelDAO.LoginDAO;
import modelDAO.MaritalStatusDAO;
import modelDAO.ProductDAO;
import modelDAO.SchLevelDAO;
import modelDAO.SupplierDAO;
import modelDAO.UsuarioDAO;

/**
 * Classe responsável por realizar o controle dos objetos DAO que contém os CRUDs e diversas operações na base de dados, filtrando a criação desses objetos.
 *
 * @autor valterFranco<unciritibaAds>
 */
public class ControleDAO {

    private static ControleDAO banco = new ControleDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private LoginDAO loginDAO = new LoginDAO();
    private ItemDAO itemDAO = new ItemDAO();
    private ProductDAO productDAO = new ProductDAO();
    private CatDAO catDAO = new CatDAO();
    private SupplierDAO SupplierDAO = new SupplierDAO();
    private EmpDAO empDAO = new EmpDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private CusStaDAO cusStaDAO = new CusStaDAO();
    private GenDAO genDAO = new GenDAO();
    private MaritalStatusDAO maritalStatusDAO = new MaritalStatusDAO();
    private EmpStatusDAO empStatusDAO = new EmpStatusDAO();
    private SchLevelDAO schLevelDAO = new SchLevelDAO();

    public GenDAO getGenDAO() {
        return genDAO;
    }

    public MaritalStatusDAO getMaritalStatusDAO() {
        return maritalStatusDAO;
    }

    public EmpStatusDAO getEmpStatusDAO() {
        return empStatusDAO;
    }

    public SchLevelDAO getSchLevelDAO() {
        return schLevelDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public CusStaDAO getCusStaDAO() {
        return cusStaDAO;
    }

    public CatDAO getCatDAO() {
        return catDAO;
    }

    public SupplierDAO getSupplierDAO() {
        return SupplierDAO;
    }

    public EmpDAO getEmpDAO() {
        return empDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

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

}
