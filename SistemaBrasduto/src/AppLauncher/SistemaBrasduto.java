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
 *
 * @author valter.franco
 */
public class SistemaBrasduto extends Application {

    public static Stage entrar;
    private Scene scene;
    private AnchorPane anchorPane;
    private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();

    @Override
    public void start(final Stage stage) {
        try {
            entrar = stage;
            anchorPane = FXMLLoader.load(SistemaBrasduto.class.getResource("/view/Login.fxml"));
            scene = new Scene(anchorPane);
            stage.initStyle(StageStyle.DECORATED);
            stage.setX(windows.getMinX());
            stage.setY(windows.getMinY());
            stage.setWidth(windows.getWidth());
            stage.setHeight(windows.getHeight());

//            stage.getIcons().addAll(new Image(Login.class.getResourceAsStream("icone.png")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaBrasduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(SistemaBrasduto.class, (java.lang.String[]) null);
    }

}
