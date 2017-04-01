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
 public class FirstPage extends Application {
 
     public static BorderPane menuRoot = new BorderPane();
 
     public static BorderPane getMenuRoot() {
         return menuRoot;
     }
 
     @Override
     public void start(Stage primaryStage) {
         try {
             URL chooseMenu = getClass().getResource("/view/InitMenu.fxml");
             AnchorPane choose = FXMLLoader.load(chooseMenu);
 
             menuRoot.setCenter(choose);
             Scene scene = new Scene(menuRoot, 1280, 720);
             scene.getStylesheets().add(getClass().getResource("/css/home.css").toExternalForm());
             primaryStage.setScene(scene);
             primaryStage.setResizable(true);
             primaryStage.centerOnScreen();
             primaryStage.show();
             primaryStage.getIcons().addAll(new Image(HomeLauncher.class.getResourceAsStream("/icon/loglogo.png")));
             primaryStage.setTitle("BRASP  Brasduto Project");
         } catch (IOException ex) {
             Logger.getLogger(FirstPage.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
 
     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
         launch(args);
     }
 
 }
