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
import javafx.scene.control.ScrollPane;
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

    @FXML
    void btnHomeOnClicked(ActionEvent event) {
      
        try {
            URL homeUrl = getClass().getResource("/view/Home.fxml");
            AnchorPane home = FXMLLoader.load(homeUrl);
            border.setCenter(home);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnProOnclicked(ActionEvent event) {

        try {
            URL manProUrl = getClass().getResource("/view/Product.fxml");
            AnchorPane manPro = FXMLLoader.load(manProUrl);
            border.setCenter(manPro);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            URL manSupTable = getClass().getResource("/view/Supplier.fxml");
            AnchorPane manSup = FXMLLoader.load(manSupTable);
            border.setCenter(manSup);

        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnFunOnClicked(ActionEvent event) {
        try {
            URL employeeListUrl = getClass().getResource("/view/EmployeeList.fxml");
            ScrollPane employeeTable = FXMLLoader.load(employeeListUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnIncOnClicked(ActionEvent event) {

    }

    @FXML
    void btnMsgOnClicked(ActionEvent event) {
        try {
            //        WebView whats = new WebView();
            URL msgUrl = getClass().getResource("/view/Message.fxml");
            WebView whats = FXMLLoader.load(msgUrl);
            WebEngine engine = whats.getEngine();
            engine.load("https://web.whatsapp.com/");
//        Scene scene = new Scene(root,1280,680);
           border.setCenter(whats);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnSupOnClicked(ActionEvent event) {
try {
            //        WebView whats = new WebView();
            URL suporteUrl = getClass().getResource("/view/Support.fxml");
            WebView suporte = FXMLLoader.load(suporteUrl);
            WebEngine engine = suporte.getEngine();
            engine.load("https://valtercwb.github.io/");
//        Scene scene = new Scene(root,1280,680);
           border.setCenter(suporte);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
@FXML
    void btnCosOnClicked(ActionEvent event) {

    }
}
