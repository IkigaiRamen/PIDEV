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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pidev.entities.User;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class SeConnceterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      
    @FXML
    
    private TextField txtUserName;
    
   
    @FXML
    
    private PasswordField txtPassword;
    
    @FXML 
    private Button btn;
    
    @FXML
    public void login(ActionEvent event){
        
        String username= txtUserName.getText();
        
        String password =txtPassword.getText();
        
        UserService us= new UserService();
        
        User u= us.getUserByUserName(username);
        
        
        if(u.getPassword().equals(password)){
            
        }
        else{

        }
        
        
    
    }
    @FXML 
        public void inscription(ActionEvent event){
        FXMLLoader loder = new FXMLLoader(getClass().getResource("Inscription.fxml"));
        try {
            Parent root = loder.load();
            InscriptionController ic = loder.getController();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
