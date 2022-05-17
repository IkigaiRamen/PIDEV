/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entities.User;
import pidev.entities.UserSession;
import pidev.services.UserService;
/**
 * FXML Controller class
 *
 * @author eya
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Hyperlink forgotpw;
    @FXML
    private Button inscription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws SQLException {
        UserService us = new UserService();
        String email= this.email.getText();
        String password = this.password.getText();
        if(email.isEmpty() || password.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ Vide");
            alert.setHeaderText("Remplissez votre email et mot de passe");
            alert.showAndWait();
            
        }
        else {
            User u = us.Login(email, us.md5(password));
            UserSession.id= u.getId();
            UserSession.roles=u.getRoles();
            UserSession.email= u.getUsername();
            UserSession.userName=u.getUsername();
            System.out.println("connected");

            switch(u.getRoles()){
                case "[\"ROLE_ADMIN\"]":{
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/GUI/GetionDeveloppeurs.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
            
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case "[\"ROLE_TRAVAILLEUR\"]":{
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ProfileDeveloppeur.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
            
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case "[\"ROLE_EMPLOYEUR\"]":{
                   try {
                        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ProfileEmployeur.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
            
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
            
        }
       /* else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Incorrect");
            alert.setHeaderText("Verifiez votre email et mot de passe");
            alert.showAndWait();
        }*/
    
    }

    @FXML
    private void forgotpw(ActionEvent event) {
    }

    @FXML
    private void inscription(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Inscription.fxml"));
            Scene scene = new Scene(root);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            
              } 
         catch (IOException ex) {
              Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
              }
    }

    
}
