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
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pidev.Connexion;
import pidev.entities.Role;
import pidev.entities.User;
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
    public void login(ActionEvent event){
        
        String username= txtUserName.getText();
        
        String password =txtPassword.getText();
        
        if(username.isEmpty() || password.isEmpty()){
            btnLogin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Champ vide");
                    alert.setHeaderText("Remplissez votre username et mot de passe s'il vous plait");
                    alert.showAndWait();
                }
            });
        }
        else{
        String sql= "select * from user where username = ? and password = ? ";
        try{
            ps=mc.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            User u= new User();
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("userName"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setRole(Role.valueOf(rs.getString("role")));
                System.out.println(u);
                btnLogin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.showAndWait();
                }
            });
            }
            else{
                
                btnLogin.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur de connection");
                    alert.setHeaderText("Vérifier votre mot de passe s'il vous plait");
                    alert.showAndWait();
                }
            });
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
