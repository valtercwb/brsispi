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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author valter
 */
public class EmployeeController {

    @FXML
    private MenuItem listarFunDep;

    @FXML
    private MenuItem addFun;

    @FXML
    private MenuItem editFun;

    @FXML
    private MenuItem deleteFun;

    @FXML
    void handelAddFun(ActionEvent event) {
        try {
            URL addEmp = getClass().getResource("/view/employee/AddEmployee.fxml");
            GridPane employeeAdd = FXMLLoader.load(addEmp);
            URL employeeActionUrl = getClass().getResource("/view/employee/MenuEmployeeAction.fxml");
            AnchorPane employeeAction = FXMLLoader.load(employeeActionUrl);
//            URL employeeUrl = getClass().getResource("/view/employee/Employee.fxml");
//            AnchorPane employeeTable = FXMLLoader.load(employeeUrl);

            pane.setCenter(employeeAdd);
//            pane.setTop(employeeMenu);
            pane.setBottom(employeeAction);

        } catch (IOException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleDeleteFun(ActionEvent event) {

    }

    @FXML
    void handleEditFun(ActionEvent event) {

    }

    @FXML
    void handleListarFunDep(ActionEvent event) {

    }
}
