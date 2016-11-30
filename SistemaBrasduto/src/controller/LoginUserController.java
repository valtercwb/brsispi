/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AppLauncher.HomeLauncher2;
import AppLauncher.SistemaBrasduto;
import com.jfoenix.controls.JFXButton;
import database.ControleDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class LoginUserController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label labErroLogin;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    ImageView logo;

    public static User usuarioLogado = null;

    @FXML
    void btnLoginOnClicked(ActionEvent event) {
        String login = txtUser.getText();
        String senha = txtSenha.getText();

        if (ControleDAO.getBanco().getLoginDAO().autenticarUsername(login)) {
            if (ControleDAO.getBanco().getLoginDAO().autenticarSenha(login, senha)) {
                try {
                    //usuarioLogado = ControleDAO.getBanco().getLoginDAO().usuarioLogado(login);
                    new HomeLauncher2().start(new Stage());
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();

                } catch (Exception ex) {
                    Logger.getLogger(LoginAdmController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Throwable ex) {
                    Logger.getLogger(LoginAdmController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                labErroLogin.setText("Senha incorreta, verifique os valores!");
                Campo.fieldError(txtSenha);
            }
        } else {
            labErroLogin.setText("Usuário não existe ou inativo!");
            Campo.fieldError(txtUser);
        }
    }

    @FXML
    void minimizar(ActionEvent event) {
        SistemaBrasduto.loginStage.setIconified(true);
    }
    // Função para chamar procedimento de login ao clicar ENTER no campo de senha

    private void acessar(PasswordField txtSenhaAdm) {
        txtSenhaAdm.setOnKeyReleased((KeyEvent key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                btnLoginOnClicked(null);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acessar(txtSenha);
    }
}
