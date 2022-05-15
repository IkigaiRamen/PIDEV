/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.Connexion;
import pidev.entities.User;
import pidev.entities.UserSession;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class SeConnceterController implements Initializable {

    Connection mc;
    

    PreparedStatement ps;
    public SeConnceterController() {
         mc= Connexion.getInstance().getMyConnection();
    }

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
    private Button btnLogin;
    
    @FXML 
    private Button btnInscri;
    
    @FXML
    private Hyperlink hypForgotPassword;
    
    @FXML
    public void login(){
        UserService us= new UserService();
        String username= txtUserName.getText();
        
        String password =us.md5(txtPassword.getText());
         try {
            if(username.isEmpty() || password.isEmpty()){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Champ vide");
                    alert.setHeaderText("Remplissez votre username et mot de passe s'il vous plait");
                    alert.showAndWait();
                } else if (us.Login(username, password).equals("user valide")){
                User u = us.getUser(username, password);
                System.out.println(u.getId());
                System.out.println("this is the first test");
                UserSession users= new UserSession(u.getId(), u.getUserName(), u.getRole());
                switch(u.getRole().toString()){
                    case "Administrateur":{
                        try {
                            FXMLLoader loader2=new FXMLLoader(getClass().getResource("GestionDeveloppeurs.fxml"));
                            Parent root =loader2.load();
                            txtPassword.getScene().setRoot(root);
                            } 
                        catch (IOException ex) {
                            Logger.getLogger(SeConnceterController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
                    case "Employeur":{
                        try {
                            FXMLLoader loader2=new FXMLLoader(getClass().getResource("ProfileEmployeur.fxml"));
                            Parent root =loader2.load();
                                                        txtPassword.getScene().setRoot(root);
                            } 
                        catch (IOException ex) {
                            Logger.getLogger(SeConnceterController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    case "Developpeur":{
                        try {
                            System.out.println("this is the second test");
                            FXMLLoader loader2=new FXMLLoader(getClass().getResource("Home2.fxml"));

                            Parent root =loader2.load();
                                                        txtPassword.getScene().setRoot(root);

                            } 
                        catch (IOException ex) {
                            Logger.getLogger(SeConnceterController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
            }else{
             
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText("Verifier votre login et mot de passe s'il vous plait");
                    alert.showAndWait();
            }
            
            
        }
        catch(SQLException e){
            
        }
    }
    @FXML 
    public void inscription(ActionEvent event) {
            try{
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
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
    private void passwordForgotten(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("OublierPassword.fxml"));
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
        
        

