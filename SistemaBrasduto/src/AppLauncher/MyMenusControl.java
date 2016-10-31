/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppLauncher;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
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
    private Button btnFun;

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

            URL paneTwoUrl = getClass().getResource("/view/produto/Produtos.fxml");
            AnchorPane paneTwo = FXMLLoader.load(paneTwoUrl);

            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(paneTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnInsOnClicked(ActionEvent event) {

    }

    @FXML
    void btnCliOnClicked(ActionEvent event) {

    }

    @FXML
    void btnForOnClicked(ActionEvent event) {

    }

    @FXML
    void btnFunOnClicked(ActionEvent event) {
        try {
//            BorderPane pane = new BorderPane();
            URL employeeMenuUrl = getClass().getResource("/view/employee/MenuEmployee.fxml");
            MenuBar employeeMenu = FXMLLoader.load(employeeMenuUrl);
            URL employeeActionUrl = getClass().getResource("/view/employee/MenuEmployeeAction.fxml");
            AnchorPane employeeAction = FXMLLoader.load(employeeActionUrl);
            URL employeeUrl = getClass().getResource("/view/employee/Employee.fxml");
            AnchorPane employeeTable = FXMLLoader.load(employeeUrl);
            pane.setCenter(employeeTable);
            pane.setTop(employeeMenu);
            pane.setBottom(employeeAction);
            BorderPane border = HomeLauncher.getRoot();
            border.setCenter(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
     
}
