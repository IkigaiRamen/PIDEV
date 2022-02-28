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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev.entities.User;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class LoginController implements Initializable {

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
    private TextField txtPassword;
    
    @FXML 
    private Button btn;
    
    @FXML 
    private void login(ActionEvent event){
        
        String username= txtUserName.getText();
        
        String password =txtPassword.getText();
        
        UserService us= new UserService();
        
        User u= us.getUserByUserName(username);
        System.out.println("***");
        if(u.getPassword().equals(password)){
            FXMLLoader loder = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                try {
                    Parent root = loder.load();
                    AcceuilController ac = loder.getController();
                    ac.setText(u.toString());
                    txtUserName.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
        }
        else{
            System.out.println("please verify your password");
        }
        
        
    }
    
}
