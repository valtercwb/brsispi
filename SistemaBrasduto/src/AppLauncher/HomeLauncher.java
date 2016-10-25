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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author valter.franco
 */
public class HomeLauncher extends Application {

    public static Stage home;
    private static Scene scene;
    private static AnchorPane anchorPane;

    private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();

    @Override
    public void start(final Stage stage) {
        try {
            home = stage;
            anchorPane = FXMLLoader.load(HomeLauncher.class.getResource("/view/Home.fxml"));
            scene = new Scene(anchorPane);
            stage.initStyle(StageStyle.DECORATED);
            stage.setX(windows.getMinX());
            stage.setY(windows.getMinY());
            stage.setWidth(windows.getWidth());
            stage.setHeight(windows.getHeight());

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
