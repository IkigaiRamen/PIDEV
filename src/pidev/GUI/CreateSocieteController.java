/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entities.Employeur;
import static pidev.entities.Role.Employeur;
import pidev.entities.Societe;
import pidev.services.SocieteService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class CreateSocieteController implements Initializable {

    @FXML
    private TextArea txtDes;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private ChoiceBox<String> txtCategorie;
    private final String[] cat={"Developpement", "Finance et assurence", "Securite"} ;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelephone;
    @FXML
    private Button Addsociete;
    private InscriptionEmployeurController iec;
                        Employeur e = iec.e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtCategorie.getItems().addAll(cat);
    }   
    @FXML
    private void Addsociete(ActionEvent event){
        if(txtDes.getText().isEmpty()||txtAdresse.getText().isEmpty()||txtCategorie.getValue().isEmpty()||txtEmail.getText().isEmpty()||txtTelephone.getText().isEmpty()||txtNom.getText().isEmpty()){
            
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Champ vide");
                        alert.setHeaderText("Remplissez votre username et mot de passe s'il vous plait");
                        alert.showAndWait();
        }
            
            
        else{
        
                    System.out.println("*****");

                    System.out.println(e.getId());

                    Societe s= new Societe(0, txtNom.getText(), txtDes.getText(), txtAdresse.getText(), txtCategorie.getValue(), txtTelephone.getText(), txtEmail.getText(),e.getId());
                    SocieteService ss= new SocieteService();
                    ss.ajouterSociete(s);
                    try{
                    
                        Parent root = FXMLLoader.load(getClass().getResource("SeConnceter.fxml"));
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

