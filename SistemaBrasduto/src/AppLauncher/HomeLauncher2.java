/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppLauncher;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class HomeLauncher2 extends Application{
    // Creating a static root to pass to the controller
    private static BorderPane root = new BorderPane();

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start( Stage primaryStage) {
        try {
            URL anchorMenu = getClass().getResource("/view/MenuUser.fxml");
            AnchorPane menu = FXMLLoader.load(anchorMenu);

            URL paneOneUrl = getClass().getResource("/view/Home.fxml");
            AnchorPane paneOne = FXMLLoader.load(paneOneUrl);
            
            root.setTop(menu);
            root.setCenter(paneOne);
            Scene scene = new Scene(root, 1280, 720);
            scene.getStylesheets().add(getClass().getResource("/css/home.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("BRASP - Brasduto Project");
            primaryStage.show();
            primaryStage.getIcons().addAll(new Image(HomeLauncher2.class.getResourceAsStream("/icon/loglogo.png")));
        } catch (IOException ex) {
            Logger.getLogger(HomeLauncher2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    public static void main(String[] args) {
        launch(args);
    }
}