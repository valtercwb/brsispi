package database;

import modelDAO.AcLoginDAO;
import modelDAO.AdmLoginDAO;
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
import modelDAO.UserDAO;
import modelDAO.UserStatusDAO;
import modelDAO.UserTypeDAO;

/**
 *
 * Deal with taking care of the DAO objects and a lot of database operations filtering these operations.
 *
 * @autor valterFranco<unciritibaAds>
 */
public class ControleDAO {

    private static ControleDAO banco = new ControleDAO();
    private UserDAO userDAO = new UserDAO();
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
    private AdmLoginDAO admLoginDAO = new AdmLoginDAO();
    private AcLoginDAO acLoginDAO = new AcLoginDAO();
    private UserStatusDAO userStatusDAO = new UserStatusDAO();
    private UserTypeDAO userTypeDAO = new UserTypeDAO();

    public GenDAO getGenDAO() {
        return genDAO;
    }

    public AcLoginDAO getAcLoginDAO() {
        return acLoginDAO;
    }

    public AdmLoginDAO getAdmLoginDAO() {
        return admLoginDAO;
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

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public UserStatusDAO getUserStatusDAO() {
        return userStatusDAO;
    }

    public void setUserStatusDAO(UserStatusDAO userStatusDAO) {
        this.userStatusDAO = userStatusDAO;
    }

    public UserTypeDAO getUserTypeDAO() {
        return userTypeDAO;
    }

    public void setUserTypeDAO(UserTypeDAO userTypeDAO) {
        this.userTypeDAO = userTypeDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
}
