///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import AppLauncher.SistemaBrasduto;
//import database.ControleDAO;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//import model.User;
//
///**
// * FXML Controller class
// *
// * @author valter.franco
// */
//public class CriarUsuarioController implements Initializable {
//
//    @FXML
//    private PasswordField txtSenha;
//    @FXML
//    private TextField txtUsuario;
//    @FXML
//    private TextField txtNome;
//    @FXML
//    public Hyperlink linkPossuiConta;
//    @FXML
//    private Button btnCriarUsuario;
//    @FXML
//    private AnchorPane mainAnchor;
//    @FXML
//    private TextField txtReSenha;
//
//    @FXML
//    void btnCriarUsuarioOnClicked(ActionEvent event) {
//
//        String nome = txtNome.getText();
//        String login = txtUsuario.getText();
//        String senha = txtSenha.getText();
//
//        User user = new User();
//        user.setUserName(nome);
//        user.setUserLogin(login);
//        user.setUserSenha(senha);
//        try {
//            ControleDAO.getBanco().getUserDAO().inserir(user);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CriarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        alert.setTitle("Sistema Brasduto");
//        alert.setHeaderText("Usuario Cadastrado com sucesso");
//        alert.setContentText("Voltar a tela de Login?");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            new SistemaBrasduto().start(new Stage());
//            Stage hlLoginStage = (Stage) linkPossuiConta.getScene().getWindow();
//            hlLoginStage.close();
//        } else {
//            txtNome.setText(null);
//            txtUsuario.setText(null);
//            txtSenha.setText(null);
//        }
//    }
//    
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//    }
//  
//}
