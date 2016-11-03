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
 * @author elenice.carvalho
 */
public class MyMenusControl {

    public static BorderPane pane = new BorderPane();

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

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(home);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnProOnclicked(ActionEvent event) {
        try {

            URL paneTwoUrl = getClass().getResource("/view/product/Product.fxml");
            AnchorPane paneTwo = FXMLLoader.load(paneTwoUrl);

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(paneTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnInsOnClicked(ActionEvent event) {

        try {
            URL itemMenuUrl = getClass().getResource("/view/item/MenuItem.fxml");
            AnchorPane itemMenu = FXMLLoader.load(itemMenuUrl);

//            URL employeeUrl = getClass().getResource("/view/employee/EmployeeFilter.fxml");
//            AnchorPane employeeFilter = FXMLLoader.load(employeeUrl);
//            URL employeeListUrl = getClass().getResource("/view/employee/EmployeeList.fxml");
//            ScrollPane employeeTable = FXMLLoader.load(employeeListUrl);
//            pane.setLeft(employeeFilter);
            pane.setTop(itemMenu);
//            pane.setCenter(employeeTable);

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(pane);
        } catch (IOException ex) {
            Logger.getLogger(MyMenusControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void btnCliOnClicked(ActionEvent event) {

    }

    @FXML
    void btnForOnClicked(ActionEvent event) {
        try {

            URL paneTwoUrl = getClass().getResource("/view/product/Product.fxml");
            AnchorPane paneTwo = FXMLLoader.load(paneTwoUrl);

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(paneTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnFunOnClicked(ActionEvent event) {
        try {

            URL employeeMenuUrl = getClass().getResource("/view/employee/MenuEmployee.fxml");
            AnchorPane employeeMenu = FXMLLoader.load(employeeMenuUrl);

            URL employeeUrl = getClass().getResource("/view/employee/EmployeeFilter.fxml");
            AnchorPane employeeFilter = FXMLLoader.load(employeeUrl);

            URL employeeListUrl = getClass().getResource("/view/employee/EmployeeList.fxml");
            ScrollPane employeeTable = FXMLLoader.load(employeeListUrl);

            pane.setLeft(employeeFilter);
            pane.setTop(employeeMenu);
            pane.setCenter(employeeTable);

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
