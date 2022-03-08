/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author khale
 */
public class NewFXnotMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        //Parent root = FXMLLoader.load(getClass().getResource("CertificationList.fxml")) ; 
                //Parent root = FXMLLoader.load(getClass().getResource("GestionCertification.fxml")) ; 
        Parent root = FXMLLoader.load(getClass().getResource("/pidev.GUI/ProfileDeveloppeur.fxml")) ; 
        ScrollPane sp = new ScrollPane();
        sp.setContent(root);
        Scene scene = new Scene(sp);
       //Scene scene = new Scene(sp, 300, 50);
        primaryStage.setTitle("Certification");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
