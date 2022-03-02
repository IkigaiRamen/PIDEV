/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
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
    private ChoiceBox <String> Education ;
    private final String[] edu ={"liscence","master","ingénierie","doctorat"};
    @FXML
    private TextField Salaire ;
    @FXML
    private TextField Mission ;
    @FXML
    private DatePicker Datefin ;
    @FXML
    private Button submit ;
    //@FXML
    //private Button lisetoffre;
    
    /*UnaryOperator<TextFormatter.Change> numberValidationFormatter = Salaire -> {
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
};*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Education.getItems().addAll(edu);
        // TODO
    }    
    
 public void getEducation (ActionEvent event){
      
    }
    
    public void ajouteroffre(ActionEvent event) {
    String position = poste.getText();
    String description = Description.getText();
    String adresse = Adresse.getText();
    String education = Education.getValue();
    String salaire = Salaire.getText();
    float f = Float.valueOf(salaire);
    String mission = Mission.getText();
    String dateFin = Datefin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    
   
  
                    
    Offre o = new Offre (position,description,education,adresse,mission,f,"true","ckjd",dateFin);
    OffreServices os = new OffreServices();
    os.ajoutOffre(o);
    
   
    }
    public void profile(ActionEvent event){
    
    }
    @FXML
    private void listeOffre(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
    }
    
}
