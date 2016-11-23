/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppLauncher;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author valterFranco<unicuritibaAds>
 */
public class MyMenusControl {
    
    public static BorderPane border = HomeLauncher.getRoot();
    AnchorPane manPro;
    AnchorPane home;
    AnchorPane manSup;
    WebView suporte;
    WebView whats;
    BorderPane employee;
    
    @FXML
    private Button btnCos;
    
    @FXML
    private Button btnInc;
    
    @FXML
    private Button btnSet;
    
    @FXML
    private Button btnSup;
    
    @FXML
    private Button btnMsg;
    @FXML
    private AnchorPane menuBotoes;
    @FXML
    private ImageView btnLogoBras;
    
    @FXML
    private Button btnHome;
    
    @FXML
    private Button btnPro;
    
    @FXML
    private Button btnIns;
    
    @FXML
    private Button btnCli;
    
    @FXML
    private Button btnFor;
    
    @FXML
    public Button btnFun;
    
    private boolean itLoadedHome = false;
    private boolean itLoadedPro = false;
    boolean itLoadedIns = false;
    boolean itLoadedCus = false;
    private boolean itLoadedSup = false;
    private boolean itLoadedMsg = false;
    private boolean itLoadedSupp = false;
    private boolean itLoadedEmp = false;
    private boolean itLoadedCos = false;
    private boolean itLoadedInc = false;
    
    @FXML
    void btnHomeOnClicked(ActionEvent event) {
        if (isItLoadedHome() == false) {
            try {
                URL homeUrl = getClass().getResource("/view/Home.fxml");
                home = FXMLLoader.load(homeUrl);
                border.setCenter(home);
                setItLoadedHome(true);
            } catch (IOException ex) {
                Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            border.setCenter(home);
        }
    }
    
    @FXML
    void btnProOnclicked(ActionEvent event) {
        if (isItLoadedPro() == false) {
            try {
                URL manProUrl = getClass().getResource("/view/Product.fxml");
                manPro = FXMLLoader.load(manProUrl);
                border.setCenter(manPro);
                setItLoadedPro(true);
            } catch (IOException ex) {
                Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            border.setCenter(manPro);
        }
    }
    
    @FXML
    void btnInsOnClicked(ActionEvent event) {
        
        try {
            URL addListItemTable = getClass().getResource("/view/Item.fxml");
            AnchorPane itemListAddTable = FXMLLoader.load(addListItemTable);
            border.setCenter(itemListAddTable);
            
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void btnCliOnClicked(ActionEvent event) {
        try {
            URL manCusTable = getClass().getResource("/view/Customer.fxml");
            AnchorPane manCus = FXMLLoader.load(manCusTable);
            border.setCenter(manCus);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void btnForOnClicked(ActionEvent event) {
        if (isItLoadedSupp() == false) {
            try {
                URL manSupTable = getClass().getResource("/view/Supplier.fxml");
                manSup = FXMLLoader.load(manSupTable);
                border.setCenter(manSup);
                setItLoadedSupp(true);
            } catch (IOException ex) {
                Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            border.setCenter(manSup);
        }
    }
    
    @FXML
    void btnFunOnClicked(ActionEvent event) {
        if (isItLoadedEmp() == false) {
            try {
                URL employeeListUrl = getClass().getResource("/view/Employee.fxml");
                employee = FXMLLoader.load(employeeListUrl);
                border.setCenter(employee);
                setItLoadedEmp(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { border.setCenter(employee);
        }
    }
    
    @FXML
    void btnIncOnClicked(ActionEvent event) {
        if (itLoadedInc == false) {
            setItLoadedInc(true);
        } else {
        }
    }
    
    @FXML
    void btnMsgOnClicked(ActionEvent event) {
        if (itLoadedMsg == false) {
            try {
                //        WebView whats = new WebView();
                URL msgUrl = getClass().getResource("/view/Message.fxml");
                whats = FXMLLoader.load(msgUrl);
                WebEngine engine = whats.getEngine();
                engine.load("https://web.whatsapp.com/");
//        Scene scene = new Scene(root,1280,680);
                border.setCenter(whats);
                setItLoadedMsg(true);
            } catch (IOException ex) {
                Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            border.setCenter(whats);
        }
    }
    
    @FXML
    void btnSupOnClicked(ActionEvent event) {
        if (isItLoadedSup() == false) {
            try {
                //        WebView whats = new WebView();
                URL suporteUrl = getClass().getResource("/view/Support.fxml");
                suporte = FXMLLoader.load(suporteUrl);
                WebEngine engine = suporte.getEngine();
                engine.load("https://valtercwb.github.io/");
//        Scene scene = new Scene(root,1280,680);
                border.setCenter(suporte);
                setItLoadedSup(true);
            } catch (IOException ex) {
                Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            border.setCenter(suporte);
        }
    }
    
    @FXML
    void btnCosOnClicked(ActionEvent event) {
        if (isItLoadedCos() == false) {
            
            setItLoadedCos(true);
        } else {
        }
    }

    /**
     * @return the isLoadedHome
     */
    public boolean isItLoadedHome() {
        return itLoadedHome;
    }

    /**
     * @param isLoadedHome the isLoadedHome to set
     */
    public void setItLoadedHome(boolean isLoadedHome) {
        this.itLoadedHome = isLoadedHome;
    }

    /**
     * @return the isLoadedPro
     */
    public boolean isItLoadedPro() {
        return itLoadedPro;
    }

    /**
     * @param isLoadedPro the isLoadedPro to set
     */
    public void setItLoadedPro(boolean isLoadedPro) {
        this.itLoadedPro = isLoadedPro;
    }

    /**
     * @return the isLoadedEmp
     */
    public boolean isItLoadedEmp() {
        return itLoadedEmp;
    }

    /**
     * @param isLoadedEmp the isLoadedEmp to set
     */
    public void setItLoadedEmp(boolean isLoadedEmp) {
        this.itLoadedEmp = isLoadedEmp;
    }

    /**
     * @return the isLoadedInc
     */
    public boolean isItLoadedCos() {
        return itLoadedInc;
    }

    /**
     * @param isLoadedInc the isLoadedInc to set
     */
    public void setItLoadedInc(boolean isLoadedInc) {
        this.itLoadedInc = isLoadedInc;
    }

    /**
     * @return the isLoadedSupp
     */
    public boolean isItLoadedSupp() {
        return itLoadedSupp;
    }

    /**
     * @param isLoadedSupp the isLoadedSupp to set
     */
    public void setItLoadedSupp(boolean isLoadedSupp) {
        this.itLoadedSupp = isLoadedSupp;
    }

    /**
     * @return the itLoadedSup
     */
    public boolean isItLoadedSup() {
        return itLoadedSup;
    }

    /**
     * @param itLoadedSup the itLoadedSup to set
     */
    public void setItLoadedSup(boolean itLoadedSup) {
        this.itLoadedSup = itLoadedSup;
    }

    /**
     * @param itLoadedCos the itLoadedCos to set
     */
    public void setItLoadedCos(boolean itLoadedCos) {
        this.itLoadedCos = itLoadedCos;
    }
    
    public boolean isItLoadedMsg() {
        return itLoadedMsg;
    }
    
    public void setItLoadedMsg(boolean itLoadedMsg) {
        this.itLoadedMsg = itLoadedMsg;
    }
    
}
