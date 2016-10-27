/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AppLauncher.HomeLauncher;
import AppLauncher.SistemaBrasduto;
import com.jfoenix.controls.JFXButton;
import database.ControleDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Usuario;
import service.Campo;

/**
 *
 * @author valter.franco
 */
public class LoginController implements Initializable {

    @FXML
    private Hyperlink linkCriar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label labErroLogin;
    @FXML
    private JFXButton btnLogin;

    public static Usuario usuarioLogado = null;

    @FXML
    void btnLoginOnClicked(ActionEvent event) {
        String login = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (ControleDAO.getBanco().getLoginDAO().autenticarUsername(login)) {
            if (ControleDAO.getBanco().getLoginDAO().autenticarSenha(login, senha)) {
                try {
                    // usuarioLogado = ControleDAO.getBanco().getLoginDAO().usuarioLogado(login);

                    new HomeLauncher().start(new Stage());
                    SistemaBrasduto.loginStage.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                labErroLogin.setText("Senha incorreta, verifique os valores!");
                Campo.erroLogin(txtSenha);
            }
        } else {
            labErroLogin.setText("Usuário não existe ou inativo!");
            Campo.erroLogin(txtUsuario);
        }
    }

    @FXML
    void minimizar(ActionEvent event) {
        SistemaBrasduto.loginStage.setIconified(true);
    }
    // Função para chamar procedimento de login ao clicar ENTER no campo de senha

    private void acessar(PasswordField txtSenha) {
        txtSenha.setOnKeyReleased((KeyEvent key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                btnLoginOnClicked(null);
            }
        });
    }

    @FXML
    public void linkCriarConta(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/CriarUsuario.fxml"));
        Scene scene = new Scene(root);
        Stage criarUsuarioStage = new Stage();
        criarUsuarioStage.setScene(scene);
        criarUsuarioStage.setMaximized(true);
        criarUsuarioStage.setTitle("Sistema Brasduto - Criar Usuario");
        criarUsuarioStage.show();
        SistemaBrasduto.loginStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acessar(txtSenha);
    }
}
