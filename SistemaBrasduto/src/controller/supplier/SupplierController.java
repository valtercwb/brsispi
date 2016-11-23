/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.supplier;

import database.ConexaoBanco;
import database.ControleDAO;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Supplier;
import modelDAO.SupplierDAO;
import static modelDAO.SupplierDAO.isUniqSupStatus;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class SupplierController implements Initializable {

    private ObservableList<Supplier> listaSup;
    @FXML
    private TableView<Supplier> tblViewSup;

    @FXML
    private TableColumn<Supplier, Number> clmnsupId;
    @FXML
    private TableColumn<Supplier, String> clmnsupName;
    @FXML
    private TableColumn<Supplier, String> clmnsupCtr;
    @FXML
    private TableColumn<Supplier, String> clmnsupPhone;
    @FXML
    private TableColumn<Supplier, String> clmnsupEmail;
    @FXML
    private TableColumn<Supplier, String> clmnsupContact;
    @FXML
    private TableColumn<Supplier, String> clmnsupMatTyp;
    @FXML
    private TableColumn<Supplier, String> clmnsupAdress;
    @FXML
    private TableColumn<Supplier, String> clmnsupZipCode;
    @FXML
    private TableColumn<Supplier, String> clmnsupSub;
    @FXML
    private TableColumn<Supplier, String> clmnsupCity;
    @FXML
    private TableColumn<Supplier, String> clmnsupState;
    @FXML
    private TableColumn<Supplier, String> clmnsupCountry;
    @FXML
    private TableColumn<Supplier, Date> clmnsupDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtZipCode;

    @FXML
    private TextField txtState;

    @FXML
    private DatePicker datePic;

    @FXML
    private TextField txtAdress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtSupply;

    @FXML
    private TextField txtSub;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private TextField filterField;

    @FXML
    private void btnDeleteOnClicked(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sistema Brasduto");
        alert.setHeaderText("Você deseja realmente excluir o fornecedor selecionado?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {

            int resultado = tblViewSup.getSelectionModel().getSelectedItem().getSupId();
            listaSup.remove(tblViewSup.getSelectionModel().getSelectedIndex());
            if (database.ControleDAO.getBanco().getSupplierDAO().DeleteSup(resultado) != 0) {
                Alert msg = new Alert(Alert.AlertType.INFORMATION);
                msg.setTitle("Registro eliminado");
                msg.setContentText("O fornecedor foi excluido com sucesso!");
                msg.setHeaderText("Resultado:");
                msg.show();
            } else {
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("Deu ruim");
                msg.setContentText("Não consegui estabelecer a conexao com o banco,contacte o técnico. :{");
                msg.setHeaderText("Resultado:");
                msg.show();
            }

        } else {
        }
    }

    @FXML
    private void btnNewOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    private void btnSaveOnClicked(ActionEvent event) {
        Supplier supplier = new Supplier();
        supplier.setSupName(txtName.getText());
        supplier.setSupCtr(txtCnpj.getText());
        supplier.setSupPhone(txtPhone.getText());
        supplier.setSupEmail(txtEmail.getText());
        supplier.setSupContact(txtContact.getText());
        supplier.setSupMatTyp(txtSupply.getText());
        supplier.setSupAdress(txtAdress.getText());
        supplier.setSupZipCode(txtZipCode.getText());
        supplier.setSupSub(txtSub.getText());
        supplier.setSupCity(txtCity.getText());
        supplier.setSupState(txtState.getText());
        supplier.setSupCountry(txtCountry.getText());
        supplier.setSupDate(Date.valueOf(datePic.getValue()));

        ControleDAO.getBanco().getSupplierDAO().SaveSup(ConexaoBanco.instancia().getConnection(), supplier);
        if (isUniqSupStatus == true) {
            listaSup.add(supplier);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Tabela de Itens");
            msg.setContentText("O Fornecedor foi adicionado com sucesso!");
            msg.setHeaderText("Resultado:");
            msg.show();
            CleanFields();
        } else {
            Campo.fieldError(txtCnpj);
        }
    }

    @FXML
    private void btnUpdateOnClicked(ActionEvent event) {
        Supplier supplier = new Supplier();
        supplier.setSupName(txtName.getText());
        supplier.setSupCtr(txtCnpj.getText());
        supplier.setSupPhone(txtPhone.getText());
        supplier.setSupEmail(txtEmail.getText());
        supplier.setSupContact(txtContact.getText());
        supplier.setSupMatTyp(txtSupply.getText());
        supplier.setSupAdress(txtAdress.getText());
        supplier.setSupZipCode(txtZipCode.getText());
        supplier.setSupSub(txtSub.getText());
        supplier.setSupCity(txtCity.getText());
        supplier.setSupState(txtState.getText());
        supplier.setSupCountry(txtCountry.getText());
        supplier.setSupDate(Date.valueOf(datePic.getValue()));

        int resultado = tblViewSup.getSelectionModel().getSelectedItem().getSupId();
        if (database.ControleDAO.getBanco().getSupplierDAO().UpdateSup(database.ConexaoBanco.instancia().getConnection(), supplier, resultado) != 0) {
            listaSup.set(tblViewSup.getSelectionModel().getSelectedIndex(), supplier);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Registro atualizado");
            msg.setContentText("O Fornecedor foi atualizado com sucesso");
            msg.setHeaderText("Resultado:");
            msg.show();
        } else {
            Alert msg = new Alert(AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao atualizar os dados no banco, contacte o suporte Técnico :)");
            msg.setHeaderText("Resultado:");
            msg.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        database.ConexaoBanco.instancia();
        listaSup = FXCollections.observableArrayList();
        SupplierDAO.FillSupInfo(ConexaoBanco.instancia().getConnection(), listaSup);
        tblViewSup.setItems(listaSup);

        clmnsupName.setCellValueFactory(new PropertyValueFactory<>("supName"));
        clmnsupCtr.setCellValueFactory(new PropertyValueFactory<>("supCtr"));
        clmnsupPhone.setCellValueFactory(new PropertyValueFactory<>("supPhone"));
        clmnsupEmail.setCellValueFactory(new PropertyValueFactory<>("supEmail"));
        clmnsupContact.setCellValueFactory(new PropertyValueFactory<>("supContact"));
        clmnsupMatTyp.setCellValueFactory(new PropertyValueFactory<>("supMatTyp"));
        clmnsupAdress.setCellValueFactory(new PropertyValueFactory<>("supAdress"));
        clmnsupZipCode.setCellValueFactory(new PropertyValueFactory<>("supZipCode"));
        clmnsupSub.setCellValueFactory(new PropertyValueFactory<>("supSub"));
        clmnsupCity.setCellValueFactory(new PropertyValueFactory<>("supCity"));
        clmnsupState.setCellValueFactory(new PropertyValueFactory<>("supState"));
        clmnsupCountry.setCellValueFactory(new PropertyValueFactory<>("supCountry"));
        clmnsupDate.setCellValueFactory(new PropertyValueFactory<>("supDate"));

        ManEvents();

        FilteredList<Supplier> filteredData = new FilteredList<>(listaSup, i -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(supplier -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (supplier.getSupName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (supplier.getSupMatTyp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (supplier.getSupContact().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Supplier> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblViewSup.comparatorProperty());
        tblViewSup.setItems(sortedData);

    }

    private void CleanFields() {
        txtName.setText("");
        txtCnpj.setText("");
        txtPhone.setText("");
        txtContact.setText("");
        txtSupply.setText("");
        txtCity.setText("");
        txtCountry.setText("");
        txtState.setText("");
        txtZipCode.setText("");
        datePic.setValue(null);
        txtAdress.setText("");
        txtEmail.setText("");
        txtSub.setText("");
    }

    private void ManEvents() {

        tblViewSup.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Supplier> arg0, Supplier valorAnterior, Supplier valorSelecionado) -> {
            if (valorSelecionado != null) {
                txtName.setText(valorSelecionado.getSupName());
                txtCnpj.setText(valorSelecionado.getSupCtr());
                txtPhone.setText(valorSelecionado.getSupPhone());
                txtEmail.setText(valorSelecionado.getSupEmail());
                txtContact.setText(valorSelecionado.getSupContact());
                txtSupply.setText(valorSelecionado.getSupMatTyp());
                txtAdress.setText(valorSelecionado.getSupAdress());
                txtZipCode.setText(valorSelecionado.getSupZipCode());
                txtSub.setText(valorSelecionado.getSupSub());
                txtCity.setText(valorSelecionado.getSupCity());
                txtState.setText(valorSelecionado.getSupState());
                txtCountry.setText(valorSelecionado.getSupCountry());
                datePic.setValue(valorSelecionado.getSupDate().toLocalDate());

                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
                btnUpdate.setDisable(false);
            }
        });
    }

}
