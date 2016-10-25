/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author elenice.carvalho
 */
public class HomeController implements Initializable {
    private static HomeController instance;
 public static HomeController getInstance() {
        return instance;
    }
 
 public VBox boxNotas() {
        VBox boxNotas = null;
        return boxNotas;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
