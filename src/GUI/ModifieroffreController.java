/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.entities.Offre;

/**
 * FXML Controller class
 *
 * @author khale
 */

public class ModifieroffreController implements Initializable {
    Offre o;
  @FXML
    private TextField poste;
    @FXML
    private TextArea Description;
    @FXML
    private ChoiceBox<String> Education;
    private final String[] edu ={"Liscence","Master","Ingénierie","Doctorat"};
    @FXML
    private TextField Salaire;
    @FXML
    private TextArea Adresse;
    @FXML
    private DatePicker Datefin;
    @FXML
    private TextArea Mission;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Education.getItems().addAll(edu);
     
       
       
      
        ListeOffreController lo = new ListeOffreController();
        o= lo.getO();
       poste.setText(o.getPosition());
      Description.setText(o.getDescription()); 
      Education.setValue(o.getEducation());
      Adresse.setText(o.getAdresse());
      Mission.setText(o.getMission());
      Salaire.setText(String.valueOf(o.getSalaire()));
    // Datefin.setDate(d);
    
      
      
    }    
    

  @FXML
    public void handleClicks(ActionEvent actionEvent) {
        
    }

  
  
  
  

    
}
