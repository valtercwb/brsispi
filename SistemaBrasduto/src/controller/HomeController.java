/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import service.Modulo;

/**
 * FXML Controller class
 *
 * @author valter.franco
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane boxContent;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnEmployee;

    @FXML
    void goEmployee(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        try {
//            fxmlLoader.load(getClass().getResource("/view/employee/Employee.fxml").openStream());
//        } catch (IOException e) {
//
//        }
//        AnchorPane anchorPane = fxmlLoader.getRoot();
//        
//        boxContent.getChildren().clear();
//        boxContent.getChildren().add(anchorPane);
        Modulo.getEmployee(boxContent);
    }

    public AnchorPane getBoxConteudo() {
        return boxContent;
    }

    @FXML
    public void btnHomeOnClicked(ActionEvent event) {
//        homeActive();
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        try {
//            fxmlLoader.load(getClass().getResource("/view/Home.fxml"));
//        } catch (IOException e) {
//
//        }
//        AnchorPane root = fxmlLoader.getRoot();
//        boxContent.getChildren().clear();
//        boxContent.getChildren().add(root);

//        System.out.println(lblUsrName.getText());
//        System.out.println(lblUserId.getText());
    }

//    @FXML
//    private void goEmployee(ActionEvent event) throws IOException {
////        //sotreActive();
////        EmployeeController empCon = new EmployeeController();
////        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/view.employee/Employee.fxml"));
//////        FXMLLoader fXMLLoader = new FXMLLoader();
//////        fXMLLoader.load(getClass().getResource("/view.employee/Employee.fxml").openStream());
////        EmployeeController employeeController = fXMLLoader.getController();
////        //employeeController.bpEmp.getStylesheets().add("/css/employee.css");
///////      EmployeeController.btnStockOnAction(event);
////        AnchorPane acPane = fXMLLoader.getRoot();
////        boxContent.getChildren().clear();
////        boxContent.getChildren().add(acPane);
//    }
    private void homeActive() {
//        imgHomeBtn.setImage(homeRed);
//        imgStoreBtn.setImage(stock);
//        imgSellBtn.setImage(sell);
//        imgEmployeBtn.setImage(employee);
//        imgSettingsBtn.setImage(setting);
//        imgAboutBtn.setImage(about);
//        btnHome.setStyle(activeStyle);
//        btnStore.setStyle(defultStyle);
//        btnSell.setStyle(defultStyle);
//        btnEmplopye.setStyle(defultStyle);
//        btnSettings.setStyle(defultStyle);
//        btnAbout.setStyle(defultStyle);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
