/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.item;

import static AppLauncher.MyMenusControl.pane;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemMenuController {

    @FXML
    private Button listItem;

    @FXML
    private Button listAddItem;

    @FXML
    private Button addItemForm;

    @FXML
    void addItemFormOnClicked(ActionEvent event) {

        try {
            URL addItem = getClass().getResource("/view/item/AddItem.fxml");
            AnchorPane itemAdd = FXMLLoader.load(addItem);
            pane.setLeft(null);
            pane.setCenter(itemAdd);
        } catch (IOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void listAddItemOnClicked(ActionEvent event) {

        try {
            URL addListItemTable = getClass().getResource("/view/item/AddItem.fxml");
            AnchorPane itemListAddTable = FXMLLoader.load(addListItemTable);
            pane.setLeft(null);
            pane.setCenter(itemListAddTable);
        } catch (IOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void listItemOnClicked(ActionEvent event) {
//        URL employeeUrl = getClass().getResource("/view/employee/EmployeeFilter.fxml");
//        AnchorPane employeeFilter = FXMLLoader.load(employeeUrl);
//            URL employeeListUrl = getClass().getResource("/view/employee/EmployeeList.fxml");
//            ScrollPane employeeTable = FXMLLoader.load(employeeListUrl);
//            pane.setLeft(employeeFilter);
//            pane.setTop(inputMenu);
//            pane.setCenter(employeeTable);
//        } catch (IOException ex) {
//            Logger.getLogger(InputMenuController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
