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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entities.Employeur;
import pidev.services.EmployeurService;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class InscriptionEmployeurController implements Initializable {

    @FXML
    private Button btnCreate;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtProfession;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmez;
    
    public static Employeur e;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CreateEmployeur(ActionEvent event) {
        EmployeurService es= new EmployeurService();
        UserService us= new UserService();
        String nom= txtNom.getText();
        String prenom= txtPrenom.getText();
        String profession= txtProfession.getText();
        String email= txtEmail.getText();
        String username= txtUsername.getText();
        String password= txtPassword.getText();
        String confirm=txtConfirmez.getText();
        if(username.isEmpty() || password.isEmpty()|| profession.isEmpty()|| confirm.isEmpty()|| email.isEmpty()|| nom.isEmpty()|| prenom.isEmpty()){
            
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Champ vide");
                    alert.setHeaderText("Remplissez tout les champs s'il vous plait");
                    alert.showAndWait();
         }else{ 
            if(!(password.equals(confirm))){
                 
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Mot de passe de confirmation");
                    alert.setHeaderText("Verifier que le mot de passe est confirme a celui de confirmation s'il vous plait");
                    alert.showAndWait();
             }else {
                 Employeur ep= new Employeur(profession, username, email,us.md5(password) , nom, prenom);
                        es.ajouterEmployeur(ep);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Compte Creer");
                        alert.setHeaderText("Votre compte est creer");
                        alert.showAndWait();
                        e=es.getEmpByUserName(username);
                        System.out.println(e.getId());
                    
               
                 try{
                    
                    Parent root = FXMLLoader.load(getClass().getResource("CreateSociete.fxml"));
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
    }
    private Employeur getE(){
        return e;
    }
    
}
