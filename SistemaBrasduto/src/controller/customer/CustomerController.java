/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer;

import database.ConexaoBanco;
import database.ControleDAO;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CusStatus;
import model.Customer;
import modelDAO.CusStaDAO;
import modelDAO.CustomerDAO;
import static modelDAO.CustomerDAO.isUniqStatus;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class CustomerController implements Initializable {

    @FXML
    private TableView<Customer> tblViewCustomer;
    @FXML
    private TableColumn<CusStatus, String> clmncusName;
    @FXML
    private TableColumn<CusStatus, String> clmncusCnpj;
    @FXML
    private TableColumn<CusStatus, String> clmncusPhone;
    @FXML
    private TableColumn<CusStatus, String> clmncusEmail;
    @FXML
    private TableColumn<CusStatus, Number> clmncusStatus;
    @FXML
    private TableColumn<CusStatus, String> clmncusAdress;
    @FXML
    private TableColumn<CusStatus, String> clmncusZipCode;
    @FXML
    private TableColumn<CusStatus, String> clmncusCity;
    @FXML
    private TableColumn<CusStatus, String> clmncusState;
    @FXML
    private TableColumn<CusStatus, String> clmncusCountry;
    @FXML
    private TableColumn<CusStatus, Date> clmncusDate;

    @FXML
    private ComboBox<CusStatus> cusStaCombo;

    private ObservableList<Customer> listaCus;
    private ObservableList<CusStatus> listaCusStatus;

    @FXML
    private TextField txtName;
    @FXML
    private TextField filterField;

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
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private void btnDeleteOnClicked(ActionEvent event) {

        int resultado = tblViewCustomer.getSelectionModel().getSelectedItem().getCusId();
        database.ControleDAO.getBanco().getCustomerDAO().DeleteItem(resultado);

        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle("Aviso");
        dialog.setContentText("Você deseja realmente excluir o item selecionado?");
        dialog.showAndWait();
        listaCus.remove(tblViewCustomer.getSelectionModel().getSelectedIndex());

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro eliminado");
        msg.setContentText("O item foi excluido com sucesso!");
        msg.setHeaderText("Resultado:");
        msg.show();

    }

    @FXML
    private void btnNewOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    private void btnSaveOnClicked(ActionEvent event) {
        Customer customer = new Customer();
        customer.setCusName(txtName.getText());
        customer.setCusCnpj(txtCnpj.getText());
        customer.setCusPhone(txtPhone.getText());
        customer.setCusEmail(txtEmail.getText());
        customer.setCusStatus(cusStaCombo.getSelectionModel().getSelectedItem());
        customer.setCusAdress(txtAdress.getText());
        customer.setCusZipCode(txtZipCode.getText());
        customer.setCusCity(txtCity.getText());
        customer.setCusState(txtState.getText());
        customer.setCusCountry(txtCountry.getText());
        customer.setCusDate(Date.valueOf(datePic.getValue()));

        ControleDAO.getBanco().getCustomerDAO().SaveCustomer(ConexaoBanco.instancia().getConnection(), customer);
        if (isUniqStatus == true) {
            listaCus.add(customer);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Tabela de Itens");
            msg.setContentText("O Insumo foi adicionado com sucesso!");
            msg.setHeaderText("Resultado:");
            msg.show();
            CleanFields();
        } else {
            Campo.fieldError(txtCnpj);
        }
    }

    @FXML
    private void btnUpdateOnClicked(ActionEvent event) {
        Customer customer = new Customer();
        customer.setCusName(txtName.getText());
        customer.setCusCnpj(txtCnpj.getText());
        customer.setCusPhone(txtPhone.getText());
        customer.setCusEmail(txtEmail.getText());
        customer.setCusStatus(cusStaCombo.getSelectionModel().getSelectedItem());
        customer.setCusAdress(txtAdress.getText());
        customer.setCusZipCode(txtZipCode.getText());
        customer.setCusCity(txtCity.getText());
        customer.setCusState(txtState.getText());
        customer.setCusCountry(txtCountry.getText());
        customer.setCusDate(Date.valueOf(datePic.getValue()));

        int resultado = tblViewCustomer.getSelectionModel().getSelectedItem().getCusId();
        if (database.ControleDAO.getBanco().getCustomerDAO().UpdateCustomer(database.ConexaoBanco.instancia().getConnection(), customer, resultado) != 0) {
            listaCus.set(tblViewCustomer.getSelectionModel().getSelectedIndex(), customer);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Registro atualizado");
            msg.setContentText("O Cliente foi atualizado com sucesso");
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
        ConexaoBanco.instancia();
        listaCus = FXCollections.observableArrayList();
        CustomerDAO.FillCustomerInfo(ConexaoBanco.instancia().getConnection(), listaCus);
        tblViewCustomer.setItems(listaCus);

        clmncusName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        clmncusCnpj.setCellValueFactory(new PropertyValueFactory<>("cusCnpj"));
        clmncusPhone.setCellValueFactory(new PropertyValueFactory<>("cusPhone"));
        clmncusEmail.setCellValueFactory(new PropertyValueFactory<>("cusEmail"));
        clmncusStatus.setCellValueFactory(new PropertyValueFactory<>("cusStatus"));
        clmncusAdress.setCellValueFactory(new PropertyValueFactory<>("cusAdress"));
        clmncusZipCode.setCellValueFactory(new PropertyValueFactory<>("cusZipCode"));
        clmncusCity.setCellValueFactory(new PropertyValueFactory<>("cusCity"));
        clmncusState.setCellValueFactory(new PropertyValueFactory<>("cusState"));
        clmncusCountry.setCellValueFactory(new PropertyValueFactory<>("cusCountry"));
        clmncusDate.setCellValueFactory(new PropertyValueFactory<>("cusDate"));

        listaCusStatus = FXCollections.observableArrayList();
        CusStaDAO.FillCusStaInfo(ConexaoBanco.instancia().getConnection(), listaCusStatus);
        cusStaCombo.setItems(listaCusStatus);

        ManEvents();

        FilteredList<Customer> filteredData = new FilteredList<>(listaCus, i -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
              
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
              
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getCusName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                } else if (customer.getCusStatus().getCusStaName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                } else if (customer.getCusCity().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                }
                return false;
            });
        });

        SortedList<Customer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblViewCustomer.comparatorProperty());
        tblViewCustomer.setItems(sortedData);

    }

    private void CleanFields() {
        txtName.setText("");
        txtCnpj.setText("");
        txtPhone.setText("");
        txtCity.setText("");
        txtCountry.setText("");
        txtState.setText("");
        txtZipCode.setText("");
        datePic.setValue(null);
        cusStaCombo.setValue(null);
        txtAdress.setText("");
        txtEmail.setText("");
    }

    private void ManEvents() {

        tblViewCustomer.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Customer> arg0, Customer valorAnterior, Customer valorSelecionado) -> {
            if (valorSelecionado != null) {
                txtName.setText(valorSelecionado.getCusName());
                txtCnpj.setText(valorSelecionado.getCusCnpj());
                txtPhone.setText(valorSelecionado.getCusPhone());
                txtEmail.setText(valorSelecionado.getCusEmail());
                cusStaCombo.setValue(valorSelecionado.getCusStatus());
                txtAdress.setText(valorSelecionado.getCusAdress());
                txtZipCode.setText(valorSelecionado.getCusZipCode());
                txtCity.setText(valorSelecionado.getCusCity());
                txtState.setText(valorSelecionado.getCusState());
                txtCountry.setText(valorSelecionado.getCusCountry());
                datePic.setValue(valorSelecionado.getCusDate().toLocalDate());

                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
                btnUpdate.setDisable(false);
            }
        });
    }
}
