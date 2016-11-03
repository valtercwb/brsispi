/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import static AppLauncher.MyMenusControl.pane;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class EmployeeMenuController {


    @FXML
    private Button listEmp;

    @FXML
    private Button listAddEmp;

    @FXML
    private Button addEmpForm;

    @FXML
    void addEmpForm(ActionEvent event) {
        try {
            URL addEmp = getClass().getResource("/view/employee/AddEmployee.fxml");
            AnchorPane employeeAdd = FXMLLoader.load(addEmp);
            pane.setLeft(null);
            pane.setCenter(employeeAdd);

        } catch (IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void listAddEmp(ActionEvent event) {
        try {
            URL addEmpTable = getClass().getResource("/view/employee/ManEmp.fxml");
            AnchorPane employeeAddTable = FXMLLoader.load(addEmpTable);
            pane.setLeft(null);
            pane.setCenter(null);
            pane.setCenter(employeeAddTable);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void listEmpOnClicked(ActionEvent event) {
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
        } catch (IOException ex) {
            Logger.getLogger(EmployeeMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
