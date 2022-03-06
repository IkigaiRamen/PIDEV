/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class OublierPasswordCodeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtCode;
    
    @FXML
    private Button btnVerifier;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void verifier(ActionEvent event){
        if(txtCode.getText().isEmpty()){
            btnVerifier.setOnAction( new EventHandler<ActionEvent>(){
                @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Champ vide");
                        alert.setHeaderText("Placer le code s'il vous plait");
                        alert.showAndWait();
                    }
            });
        }
        int code=Integer.parseInt(txtCode.getText());
        if(code==OublierPasswordController.numeroVelidation){
            try{
                Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show(); 
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            btnVerifier.setOnAction( new EventHandler<ActionEvent>(){
                @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Code invalide");
                        alert.setHeaderText("Verifier le code s'il vous plait");
                        alert.showAndWait();
                    }
            });
        }
        
    }
}
