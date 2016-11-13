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

/**
 *
 * @author valterFranco<unicuritibaAds>
 */
public class MyMenusControl {

    public static BorderPane pane = new BorderPane();
    public static BorderPane border = HomeLauncher.getRoot();

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
            pane.setTop(null);
            border.setCenter(home);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnProOnclicked(ActionEvent event) {

        try {
            URL manProUrl = getClass().getResource("/view/product/Product.fxml");
            AnchorPane manPro = FXMLLoader.load(manProUrl);
            pane.setTop(null);
            pane.setCenter(manPro);
            border.setCenter(pane);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnInsOnClicked(ActionEvent event) {

        try {
            URL addListItemTable = getClass().getResource("/view/item/Item.fxml");
            AnchorPane itemListAddTable = FXMLLoader.load(addListItemTable);
            pane.setTop(null);
            pane.setLeft(null);
            pane.setCenter(itemListAddTable);
            border.setCenter(pane);

        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnCliOnClicked(ActionEvent event) {
        try {
            URL manCusTable = getClass().getResource("/view/customer/Customer.fxml");
            AnchorPane manCus = FXMLLoader.load(manCusTable);
            pane.setTop(null);
            pane.setLeft(null);
            pane.setCenter(manCus);
            border.setCenter(pane);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnForOnClicked(ActionEvent event) {
        try {
            URL manSupTable = getClass().getResource("/view/supplier/Supplier.fxml");
            AnchorPane manSup = FXMLLoader.load(manSupTable);
            pane.setTop(null);
            pane.setLeft(null);
            pane.setCenter(manSup);
            border.setCenter(pane);

        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void btnFunOnClicked(ActionEvent event) {
        try {

            URL empMenuUrl = getClass().getResource("/view/employee/MenuEmployee.fxml");
            AnchorPane empMenu = FXMLLoader.load(empMenuUrl);

            URL employeeUrl = getClass().getResource("/view/employee/EmployeeFilter.fxml");
            AnchorPane employeeFilter = FXMLLoader.load(employeeUrl);

            URL employeeListUrl = getClass().getResource("/view/employee/EmployeeList.fxml");
            ScrollPane employeeTable = FXMLLoader.load(employeeListUrl);

            pane.setLeft(employeeFilter);
            pane.setTop(empMenu);
            pane.setCenter(employeeTable);
            border.setCenter(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
