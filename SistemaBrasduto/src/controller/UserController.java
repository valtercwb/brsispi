/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ConexaoBanco;
import database.ControleDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import model.UserStatus;
import model.UserType;
import modelDAO.UserDAO;
import modelDAO.UserStatusDAO;
import modelDAO.UserTypeDAO;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class UserController implements Initializable {

    private final BooleanProperty okToAdd = new SimpleBooleanProperty(true);
    private ObservableList<User> listaUser;
    private ObservableList<UserType> listaUserType;
    private ObservableList<UserStatus> listaUserSta;

    @FXML
    private TableView<User> tblViewUser;
    @FXML
    private TableColumn<User, Number> clmnuserId;
    @FXML
    private TableColumn<User, String> clmnuserName;

    @FXML
    private CheckBox checkPassword;

    @FXML
    private Button delUserbtn;

    @FXML
    private Button newUserBtn;

    @FXML
    private Button editUserBtn;

    @FXML
    private Button saveUserBtn;
    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<UserType> userTypeCombo;
    @FXML
    private ComboBox<UserStatus> userStaCombo;
    @FXML
    private TextField userFilter;

    @FXML
    void DeleteUserOnClicked(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sistema Brasduto");
        alert.setHeaderText("Você deseja realmente excluir o usuario selecionado?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            listaUser.remove(tblViewUser.getSelectionModel().getSelectedIndex());
            int resultado = tblViewUser.getSelectionModel().getSelectedItem().getUserId();

            if (database.ControleDAO.getBanco().getUserDAO().DeleteUser(resultado) != 0) {
                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Registro eliminado");
                msg.setContentText("O Usuario foi excluido com sucesso!");
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
    void EditUserOnClicked(ActionEvent event) {
        User user = new User();
        user.setUserName(txtName.getText());
        user.setUserLogin(txtLogin.getText());
        user.setUserSenha(txtPass.getText());
        user.setUserStatus(userStaCombo.getSelectionModel().getSelectedItem());
        user.setUserType(userTypeCombo.getSelectionModel().getSelectedItem());

        int resultado = tblViewUser.getSelectionModel().getSelectedItem().getUserId();

        if (database.ControleDAO.getBanco().getUserDAO().editUser(database.ConexaoBanco.instancia().getConnection(), user, resultado) != 0) {
            listaUser.set(tblViewUser.getSelectionModel().getSelectedIndex(), user);

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

    @FXML
    void NewUserOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    void SaveUserOnClicked(ActionEvent event) {

        try {
            User user = new User();
            user.setUserName(txtName.getText());
            user.setUserLogin(txtLogin.getText());
            user.setUserSenha(txtPass.getText());
            user.setUserStatus(userStaCombo.getSelectionModel().getSelectedItem());
            user.setUserType(userTypeCombo.getSelectionModel().getSelectedItem());
            ControleDAO.getBanco().getUserDAO().SaveUser(ConexaoBanco.instancia().getConnection(), user);

            if (UserDAO.isUniqUserLogin == true) {
                listaUser.add(user);

                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Usuarios");
                msg.setContentText("O Usuario foi adicionado com sucesso!");
                msg.setHeaderText("Resultado:");
                msg.show();
                CleanFields();
            } else {
                Campo.fieldError(txtLogin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void checkOnClicked(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConexaoBanco.instancia();
        listaUser = FXCollections.observableArrayList();
        UserDAO.FillUserInfo(ConexaoBanco.instancia().getConnection(), listaUser);
        tblViewUser.setItems(listaUser);

        clmnuserName.setCellValueFactory(new PropertyValueFactory<>("userName"));

        listaUserType = FXCollections.observableArrayList();
        UserTypeDAO.FillUserTypeInfo(ConexaoBanco.instancia().getConnection(), listaUserType);
        userTypeCombo.setItems(listaUserType);

        listaUserSta = FXCollections.observableArrayList();
        UserStatusDAO.FillUserStaInfo(ConexaoBanco.instancia().getConnection(), listaUserSta);
        userStaCombo.setItems(listaUserSta);

        ManEvents();

       
        editUserBtn.setDisable(true);

        FilteredList<User> filteredData = new FilteredList<>(listaUser, i -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        userFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getUserName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (user.getUserType().getUserTypName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (user.getUserStatus().getUserStatusName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tblViewUser.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tblViewUser.setItems(sortedData);

        saveUserBtn.disableProperty().bind(
                txtLogin.textProperty().isEmpty().or(txtName.textProperty().isEmpty()).or(txtPass.textProperty().isEmpty()).or(userStaCombo.valueProperty().isNull()).or(userTypeCombo.valueProperty().isNull()).or(okToAdd.not()));

        InvalidationListener listener = observable -> {
            if (!delUserbtn.isDisabled()) {
                editUserBtn.setDisable(false);
            }
        };

        userStaCombo.valueProperty().addListener(listener);
        userTypeCombo.valueProperty().addListener(listener);
        txtLogin.textProperty().addListener(listener);
        txtName.textProperty().addListener(listener);
        txtPass.textProperty().addListener(listener);

    }

    private void ManEvents() {
        tblViewUser.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends User> arg0, User valorAnterior, User valorSelecionado) -> {
            if (valorSelecionado != null) {

                txtName.setText(valorSelecionado.getUserName());
                txtLogin.setText(valorSelecionado.getUserLogin());
                txtPass.setText(valorSelecionado.getUserSenha());
                userStaCombo.setValue(valorSelecionado.getUserStatus());
                userTypeCombo.setValue(valorSelecionado.getUserType());
            }
        });
    }

    private void CleanFields() {
        txtName.setText("");
        txtLogin.setText("");
        txtPass.setText("");
        userTypeCombo.setValue(null);
        userStaCombo.setValue(null);

        tblViewUser.getSelectionModel().clearSelection();
        editUserBtn.setDisable(true);
        delUserbtn.setDisable(true);
        okToAdd.set(true);
    }
}
