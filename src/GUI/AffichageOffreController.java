/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.entities.Offre;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class AffichageOffreController implements Initializable {
Offre o;
  @FXML
    private TextField poste;
    @FXML
    private TextArea Description;
    @FXML
    private TextField Education;
    
    @FXML
    private TextField Salaire;
    @FXML
    private TextArea Adresse;
    @FXML
    private TextField Datefin;
    @FXML
    private TextArea Mission;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListeOffreController lo = new ListeOffreController();
        o= lo.getO();
       poste.setText(o.getPosition());
      Description.setText(o.getDescription()); 
      Education.setText(o.getEducation());
      Adresse.setText(o.getAdresse());
      Mission.setText(o.getMission());
      Salaire.setText(String.valueOf(o.getSalaire()));
    //  Datefin.setText(o.getDateFin());
    }    
    
}
