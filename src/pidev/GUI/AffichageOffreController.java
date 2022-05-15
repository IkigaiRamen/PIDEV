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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import pidev.GUI.ListeOffreController;
import pidev.entities.Offre;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class AffichageOffreController implements Initializable {
Offre o;
@FXML
    private Label Titre;
  @FXML
    private Label poste;
    @FXML
    private Label Description;
    @FXML
    private Label Education;
    
    @FXML
    private Label Salaire;
    @FXML
    private Label Adresse;
    @FXML
    private Label Datefin;
    @FXML
    private Label Mission;
    @FXML
    private Button retour;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Button btnAjouter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ListeOffreController lo = new ListeOffreController();
        
        
        o= lo.getO();
        
      Titre.setText(o.getTitre());
      poste.setText(o.getPosition());
      Description.setText(o.getDescription()); 
      Education.setText(o.getEducation());
      Adresse.setText(o.getAdresse());
      Mission.setText(o.getMission());
      Salaire.setText(String.valueOf(o.getSalaire()));
      Datefin.setText(o.getDateFin().toString());
    
     retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
     btn_listOffre.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
             btn_listOffre.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }); 
      
    
    
}
}
