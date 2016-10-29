/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AppLauncher.SistemaBrasduto;
import database.ControleDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author valter.franco
 */
public class CriarUsuarioController implements Initializable {

    @FXML
    private PasswordField txtSenha;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNome;
    @FXML
    public Hyperlink linkPossuiConta;
    @FXML
    private Button btnCriarUsuario;
    @FXML
    private AnchorPane mainAnchor;

    @FXML
    void btnCriarUsuarioOnClicked(ActionEvent event){

        String nome = txtNome.getText();
        String login = txtUsuario.getText();
        String senha = txtSenha.getText();
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        try {
            ControleDAO.getBanco().getUsuarioDAO().inserir(usuario);
            
////        Action ad = Dialogs.create()
////                .title("Sucess ...")
////                .actions(Dialog.ACTION_OK)
////                .message("Registration Sucess.."
////                        + "You can login now by your User Name and Password \n \n"
////                        + "Click Ok to Login")
////                .styleClass(Dialog.STYLE_CLASS_UNDECORATED)
////                .showConfirm();
////        
////        if (ad == Dialog.ACTION_OK) {
////            try {
////                hlLogin(event);
////            } catch (IOException ex) {
////                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
////            }
//        }
//    }
//        else {
//            Action warning = Dialogs.create()
//                .title("Warning")
//                .actions(Dialog.ACTION_CLOSE)
//                .message("Someting goes wrong, Pasword May not Match \n or All Text Field may not filled")
//                .styleClass(Dialog.STYLE_CLASS_UNDECORATED)
//                .showWarning();
//    }
        } catch (SQLException ex) {
            Logger.getLogger(CriarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void linkPossuiConta(ActionEvent event) throws IOException {
        new SistemaBrasduto().start(new Stage());
        Stage hlLoginStage = (Stage) linkPossuiConta.getScene().getWindow();
        hlLoginStage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
