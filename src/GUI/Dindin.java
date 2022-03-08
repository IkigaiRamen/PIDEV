/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Khammessi
 */
public class Dindin extends Application {
    
      @Override
    public void start(Stage primaryStage) {
       Parent root;
        try {
            
        
            
            root = FXMLLoader.load(getClass().getResource("/GUI/AddPost.fxml"));
           Scene scene = new Scene(root);
           primaryStage.setTitle("Ajouter personne");
           primaryStage.setScene(scene);
           primaryStage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}



