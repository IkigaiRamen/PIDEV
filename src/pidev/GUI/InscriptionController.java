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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private Button insDev;
    
    @FXML
    private Button insEmp;
    
    @FXML
    private void inscriDeveloppeur(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("InscriptionDeveloppeur.fxml"));
            Scene scene = new Scene(root);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        
    }
    @FXML
    private void inscriEmployeur(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("InscriptionEmployeur.fxml"));
            Scene scene = new Scene(root);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
            
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
    
}
