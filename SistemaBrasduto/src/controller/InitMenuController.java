/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AppLauncher.FirstPage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class InitMenuController {

    public static BorderPane bo = FirstPage.menuRoot;

    @FXML
    private Button btnAdm;

    @FXML
    private Button btnUser;

    @FXML
    private Button btnAco;

    @FXML
    void btnAcoOnClicked(ActionEvent event) {

    }

    @FXML
    void btnAdmOnClicked(ActionEvent event) {
        try {
            URL logAdmUrl = getClass().getResource("/view/LoginAdm.fxml");
            AnchorPane logAdm = FXMLLoader.load(logAdmUrl);
            FirstPage.menuRoot.setCenter(logAdm);

        } catch (IOException ex) {
            Logger.getLogger(InitMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void btnUserOnClicked(ActionEvent event) {
        try {
            URL logAdmUrl = getClass().getResource("/view/LoginUser.fxml");
            AnchorPane logAdm = FXMLLoader.load(logAdmUrl);
            FirstPage.menuRoot.setCenter(logAdm);

        } catch (IOException ex) {
            Logger.getLogger(InitMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
