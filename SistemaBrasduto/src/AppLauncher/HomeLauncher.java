/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppLauncher;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author valter.franco
 */
public class HomeLauncher extends Application {

    private Screen screen = Screen.getPrimary();

    private Rectangle2D windows = screen.getVisualBounds();

    @Override
    public void start(final Stage stage) {
        try {

            Parent root = FXMLLoader.load(HomeLauncher.class.getResource("/view/Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setX(windows.getMinX());
            stage.setY(windows.getMinY());
            stage.setWidth(windows.getWidth());
            stage.setHeight(windows.getHeight());
            stage.show();

            //stage.getIcons().addAll(new Image(HomeLauncher.class.getResourceAsStream("icone.png")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    public static void main(String[] args) {
        Application.launch(HomeLauncher.class, (java.lang.String[]) null);
    }
}
