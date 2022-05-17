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
import java.util.function.UnaryOperator;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import pidev.entities.User;
import pidev.entities.UserSession;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class InscriptionController implements Initializable {

    @FXML
    private CheckBox checkDev;
    @FXML
    private CheckBox checkEmp;
    @FXML
    private Button inscrire;
    @FXML
    private Hyperlink login;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private PasswordField pw;
    @FXML
    private TextField telephone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) { 
                return change;
            }
            return null;
           };
           UnaryOperator<TextFormatter.Change> letterFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([a-zA-Z]+)?")) { 
                return change;
            }
            return null;
           };
           
           UnaryOperator<TextFormatter.Change> passwordFilter = change -> {
            String newText = change.getControlNewText();
                if (newText.matches("[a-zA-Z_0-9]+")) { 
                    return change;
                }
            return null;
           };
           UnaryOperator<TextFormatter.Change> emailFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
"        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")) { 
                return change;
            }
            return null;
           };
           nom.setTextFormatter(
            new TextFormatter<>(letterFilter));
           
           prenom.setTextFormatter(
            new TextFormatter<>(letterFilter));
           
           telephone.setTextFormatter(
            new TextFormatter<>(new IntegerStringConverter(),0,integerFilter));
           
                   
    }

    @FXML
    private void inscrire(ActionEvent event) {
        if(!(checkDev.isSelected() || checkEmp.isSelected()) || nom.getText().isEmpty()||prenom.getText().isEmpty()|| email.getText().isEmpty()|| username.getText().isEmpty() || telephone.getText().isEmpty() ||pw.getText().isEmpty()){
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Champ Vide");
             alert.setHeaderText("Remplissez votre formulaire d'inscription");
             alert.showAndWait();
        }
        if(checkDev.isSelected()&& checkEmp.isSelected()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selection Invalide");
            alert.setHeaderText("Selectionnez un seul role s'il vous plait");
            alert.showAndWait();
        }
        if(!(email.getText().contains("@")||(email.getText().contains(".com")))){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Email invalide ");
            alert.setHeaderText("Verifiez votre email ");
            alert.showAndWait();
        }
                UserService us= new UserService();

        User u = new User(email.getText(), username.getText(), nom.getText(), prenom.getText(), us.md5(pw.getText()),Integer.parseInt(telephone.getText()));
        
        if(checkDev.isSelected()){
            u.setRoles("[\"ROLE_TRAVAILLEUR\"]");
            
        }
        else{
            u.setRoles("[\"ROLE_EMPLOYEUR\"]");
        }
        
        UserSession.id=u.getId();
        UserSession.email=u.getEmail();
        UserSession.roles= u.getRoles();
        System.out.println(u.getRoles());
        try{
        us.ajouterUser(u);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

    @FXML
    private void login(ActionEvent event) {
        try {
              Parent root = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));
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
