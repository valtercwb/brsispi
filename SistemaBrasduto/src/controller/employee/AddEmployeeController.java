/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import database.ConexaoBanco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.Dep;
import model.Esc;
import modelDAO.DepDAO;
import modelDAO.EscDAO;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class AddEmployeeController implements Initializable {

  


    @FXML
    private ComboBox<Esc> escCombo;
    @FXML
    private ComboBox<Dep> depCombo;

    private ObservableList<Esc> listaEsc;
    private ObservableList<Dep> listaDep;

    @FXML
    void handleEscCombo(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        database.ConexaoBanco.instancia();
        listaEsc = FXCollections.observableArrayList();
        EscDAO.FillInfo(ConexaoBanco.instancia().getConnection(), listaEsc);
        escCombo.setItems(listaEsc);

        listaDep = FXCollections.observableArrayList();
        DepDAO.FillInfo(ConexaoBanco.instancia().getConnection(), listaDep);
        depCombo.setItems(listaDep);

    }
}
