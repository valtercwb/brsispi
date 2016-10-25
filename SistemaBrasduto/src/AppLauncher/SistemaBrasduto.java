/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppLauncher;

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
 * @author elenice.carvalho
 */
public class SistemaBrasduto extends Application {
    public static Stage stage;
    private Scene scene;
    private AnchorPane anchorPane;
     private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();
    
    @Override
    public void start(Stage stage) throws Exception {
        anchorPane = FXMLLoader.load(SistemaBrasduto.class.getResource("/view/Login.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.initStyle(StageStyle.DECORATED);
            stage.setX(windows.getMinX());
            stage.setY(windows.getMinY());
            stage.setWidth(windows.getWidth());
            stage.setHeight(windows.getHeight());
            
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Application.launch(SistemaBrasduto.class, (java.lang.String[]) null);
    }
    
}
