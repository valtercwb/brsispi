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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author elenice.carvalho
 */
public class HomeLauncher extends Application {

    public static Stage stage;
    private static Scene scene;
    private static AnchorPane anchorPane;

    private Screen screen = Screen.getPrimary();
    private Rectangle2D windows = screen.getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception {
        anchorPane = FXMLLoader.load(HomeLauncher.class.getResource("../view/Home.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(windows.getMinX());
        stage.setY(windows.getMinY());
        stage.setWidth(windows.getWidth());
        stage.setHeight(windows.getHeight());

        stage.getIcons().addAll(new Image(HomeLauncher.class.getResourceAsStream("icone.png")));
    }

    /**
     * Initializes the controller class.
     */
     public static void main(String[] args) {
        Application.launch(HomeLauncher.class, (java.lang.String[]) null);
    }
}

