/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.supplier;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Supplier;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SupplierController implements Initializable {

    private ObservableList<Supplier> listaSup;
    @FXML
    private TableView<Supplier> tblViewSup;

@FXML private TableColumn<Supplier,Number> clmnsupId;
@FXML private TableColumn<Supplier,String> clmnsupName;
@FXML private TableColumn<Supplier,String> clmnsupCtr;
@FXML private TableColumn<Supplier,String> clmnsupPhone;
@FXML private TableColumn<Supplier,String> clmnsupEmail;
@FXML private TableColumn<Supplier,String> clmnsupContact;
@FXML private TableColumn<Supplier,String> clmnsupMatTyp;
@FXML private TableColumn<Supplier,String> clmnsupAdress;
@FXML private TableColumn<Supplier,String> clmnsupZipCode;
@FXML private TableColumn<Supplier,String> clmnsupSub;
@FXML private TableColumn<Supplier,String> clmnsupCity;
@FXML private TableColumn<Supplier,String> clmnsupState;
@FXML private TableColumn<Supplier,String> clmnsupCountry;
@FXML private TableColumn<Supplier,Date> clmnsupDate;
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        database.ConexaoBanco.instancia();
//        listaSup = FXCollections.observableArrayList();
//        SupplierDAO.FillSupInfo(ConexaoBanco.instancia().getConnection(), listaSup);
//        tblViewSup.setItems(listaSup);
//
//        clmnsupId.setCellValueFactory(new PropertyValueFactory<>("supId"));
//        clmnsupName.setCellValueFactory(new PropertyValueFactory<>("supName"));
//        clmnsupCtr.setCellValueFactory(new PropertyValueFactory<>("supCtr"));
//        clmnsupPhone.setCellValueFactory(new PropertyValueFactory<>("supPhone"));
//        clmnsupEmail.setCellValueFactory(new PropertyValueFactory<>("supEmail"));
//        clmnsupContact.setCellValueFactory(new PropertyValueFactory<>("supContact"));
//        clmnsupMatTyp.setCellValueFactory(new PropertyValueFactory<>("supMatTyp"));
//        clmnsupAdress.setCellValueFactory(new PropertyValueFactory<>("supAdress"));
//        clmnsupZipCode.setCellValueFactory(new PropertyValueFactory<>("supZipCode"));
//        clmnsupSub.setCellValueFactory(new PropertyValueFactory<>("supSub"));
//        clmnsupCity.setCellValueFactory(new PropertyValueFactory<>("supCity"));
//        clmnsupState.setCellValueFactory(new PropertyValueFactory<>("supState"));
//        clmnsupCountry.setCellValueFactory(new PropertyValueFactory<>("supCountry"));
//        clmnsupDate.setCellValueFactory(new PropertyValueFactory<>("supDate"));
        
    }
}
