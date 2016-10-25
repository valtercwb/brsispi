/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AppLauncher.HomeLauncher;
import AppLauncher.SistemaBrasduto;
import database.ControleDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;
import service.Campo;

/**
 *
 * @author valter.franco
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;
    @FXML
    private Label lbErroLogin;
    @FXML
    private PasswordField txtSenha;

    public static Usuario usuarioLogado = null;

    @FXML
    void handleBtnLoginAction(ActionEvent event) {
        String login = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (ControleDAO.getBanco().getLoginDAO().autenticarUsername(login)) {
            if (ControleDAO.getBanco().getLoginDAO().autenticarSenha(login, senha)) {
                try {
                    // usuarioLogado = ControleDAO.getBanco().getLoginDAO().usuarioLogado(login);

                    new HomeLauncher().start(new Stage());
                    SistemaBrasduto.entrar.close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                lbErroLogin.setText("Senha incorreta, verifique os valores!");
                Campo.erroLogin(txtSenha);
            }
        } else {
            lbErroLogin.setText("Usuário não existe ou inativo!");
            Campo.erroLogin(txtUsuario);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
