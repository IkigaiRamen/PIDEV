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
import pidev.entities.Developpeur;
import pidev.services.DeveloppeurService;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class InscriptionDeveloppeurController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    
    @FXML
    private TextField txtedu;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private TextField txtBio;
    
    @FXML
    private TextField txtSpecialite;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirm;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private TextField txtProfession;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    
    private void CreateDeveloppeur(ActionEvent event) {
        UserService us= new UserService();
        String nom= txtNom.getText();
        String prenom= txtPrenom.getText();
        String edu= txtedu.getText();
        String exp= txtExp.getText();
        String bio= txtBio.getText();
        String specialite= txtSpecialite.getText();
        String email= txtEmail.getText();
        String username= txtUsername.getText();
        String password= txtPassword.getText();
        String confirm=txtConfirm.getText();
        if(username.isEmpty() || password.isEmpty()|| bio.isEmpty()|| confirm.isEmpty()|| edu.isEmpty()|| email.isEmpty()|| exp.isEmpty()|| nom.isEmpty()|| prenom.isEmpty()|| specialite.isEmpty()){
            btnEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Champ vide");
                    alert.setHeaderText("Remplissez tout les champs s'il vous plait");
                    alert.showAndWait();
                }
            });
           
        }
        else{ 
            if(!(password.equals(confirm))){
                 btnEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Mot de passe de confirmation");
                    alert.setHeaderText("Verifier que le mot de passe est confirme a celui de confirmation s'il vous plait");
                    alert.showAndWait();
                }
            });
           
        }
            else {
                Developpeur d= new Developpeur(edu, exp, bio, specialite, username, email, us.md5(password), nom, prenom);
                 DeveloppeurService ds= new DeveloppeurService();
                 ds.ajouterDeveloppeur(d);
                 btnEnregistrer.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Compte Creer");
                        alert.setHeaderText("Votre compte est creer");
                        alert.showAndWait();
                    }
                });
                 try{
                    Parent root = FXMLLoader.load(getClass().getResource("SeConneceter.fxml"));
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

    
    
}
