/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import service.Mensagem;

/**
 *
 * @author Expression valter is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class EmployeeController extends AnchorPane {

    @FXML
    public BorderPane bpEmp;

    @FXML
    private Button btnEmployee;

    @FXML
    void btnEmployeeOnClicked(ActionEvent event) {

    }

    public EmployeeController() {
        try {
            FXMLLoader fxml = new FXMLLoader();
            fxml.load(getClass().getResource("/view/employee/Employee.fxml"));
            fxml.setRoot(this);
            fxml.setController(this);
            fxml.load();

        } catch (IOException ex) {
            Mensagem.erro("Erro ao carregar tela do usuário! \n" + ex);
        }
    }
    
}
