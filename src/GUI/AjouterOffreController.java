/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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
    
    UnaryOperator<TextFormatter.Change> numberValidationFormatter = Salaire -> {
    if(Salaire.getText().matches("\\d+")){
        return Salaire; //if change is a number
    } else {
        Salaire.setText(""); //else make no change
        Salaire.setRange(    //don't remove any selected text either.
                Salaire.getRangeStart(),
                Salaire.getRangeStart()
        );
        return Salaire;
    }
};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 
    
    public void ajouteroffre(ActionEvent event) {
    String position = poste.getText();
    String description = Description.getText();
    String adresse = Adresse.getText();
    String education = Education.getText();
    String condition = Condition.getText();
    String salaire = Salaire.getText();
    float f = Float.valueOf(salaire);
    String mission = Mission.getText();
    String dateFin = Datefin.getText();
    
    
    
    Offre o = new Offre (position,description,condition,education,adresse,mission,f,dateFin);
    OffreServices os = new OffreServices();
    os.ajoutOffre(o);
    
   
    }
    
}
