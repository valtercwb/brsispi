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
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author valter.franco
 */
public class SistemaBrasduto extends Application {

    public static Stage loginStage;
    private Scene scene;
    private AnchorPane anchorPane;

    @Override
    public void start(final Stage stage) {
        try {
            loginStage = stage;
            anchorPane = FXMLLoader.load(SistemaBrasduto.class.getResource("/view/LoginAdm.fxml"));
            scene = new Scene(anchorPane, 1280, 720);
            stage.initStyle(StageStyle.DECORATED);
            stage.centerOnScreen();

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
        launch(args);
    }

}
