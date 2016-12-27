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
 * @author valter.franco
 */
public class LoginAdmController implements Initializable {

    @FXML
    private TextField txtAdm;
    @FXML
    private PasswordField txtSenhaAdm;
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
        String login = txtAdm.getText();
        String senha = txtSenhaAdm.getText();

        if (ControleDAO.getBanco().getAdmLoginDAO().autenticarUsername(login)) {
            if (ControleDAO.getBanco().getAdmLoginDAO().autenticarSenha(login, senha)) {
                try {
                    //usuarioLogado = ControleDAO.getBanco().getLoginDAO().usuarioLogado(login);
                   
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();
                       new HomeLauncher().start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginAdmController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Throwable ex) {
                    Logger.getLogger(LoginAdmController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                labErroLogin.setText("Senha incorreta, verifique os valores!");
                Campo.fieldError(txtSenhaAdm);
            }
        } else {
            labErroLogin.setText("Usuário não existe ou inativo!");
            Campo.fieldError(txtAdm);
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

    @FXML
    public void linkCriarConta(ActionEvent event) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource("/view/CriarUsuario.fxml"));
//        Scene scene = new Scene(root);
//        Stage criarUsuarioStage = new Stage();
//        criarUsuarioStage.setScene(scene);
//        criarUsuarioStage.setMaximized(true);
//        criarUsuarioStage.setResizable(true);
//        criarUsuarioStage.setTitle("Sistema Brasduto - Criar Usuario");
//        criarUsuarioStage.show();
//        SistemaBrasduto.loginStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acessar(txtSenhaAdm);
    }
}
