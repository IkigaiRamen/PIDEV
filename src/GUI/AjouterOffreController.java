/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pidev.entities.Offre;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class AjouterOffreController implements Initializable {

    @FXML
    private TextField poste;
    @FXML
    private TextField Description;
    @FXML
    private TextField Adresse ;
    @FXML
    private TextField Education ;
    @FXML
    private TextField Condition ;
    @FXML
    private TextField Salaire ;
    @FXML
    private TextField Mission ;
    @FXML
    private TextField Datefin ;
    @FXML
    private Button btn ;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void ajouteroffre(ActionEvent event) {
    String position = poste.getText();
    String description = Description.getText();
    String adresse = Adresse.getText();
    String education = Education.getText();
    String condition = Condition.getText();
    String salaire = Salaire.getText();
    String mission = Mission.getText();
    String dateFin = Datefin.getText();
    
    
    
    Offre o = new Offre ();
    OffreServices os = new OffreServices();
    os.ajoutOffre(o);
    
   
    }
    
}
