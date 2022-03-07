/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.entities.Offre;
import pidev.services.OffreServices;

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
    @FXML
    private TextField Titre ;
    @FXML
    private Button retour;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Education.getItems().addAll(edu);
     
       
       
      
        ListeOffreController lo = new ListeOffreController();
        o= lo.getO();
      Titre.setText(o.getTitre());
      poste.setText(o.getPosition());
      Description.setText(o.getDescription()); 
      Education.setValue(o.getEducation());
      Adresse.setText(o.getAdresse());
      Mission.setText(o.getMission());
      Salaire.setText(String.valueOf(o.getSalaire()));
    // Datefin.setDate(d);
    retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
    });   
      
      
    }    
    
    
    @FXML
    private void modifier(ActionEvent event) throws SQLException{
        ListeOffreController item= new ListeOffreController();
               item.getO();
    String titre =  Titre.getText();
    String position=poste.getText();
    String description=Description.getText();
    String education=Education.getSelectionModel().getSelectedItem();
    String adresse=Adresse.getText();
    Float salaire=Float.valueOf(Salaire.getText());
    String mission= Mission.getText();
    //Date DateFin= Datefin.getDate ();
    
    
    Offre dmock= new Offre(item.getO().getId(),titre,position,description,education,adresse,mission,salaire,"true");
        OffreServices ds=new OffreServices();
        
    ds.modifierOffre(dmock);
     try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
              Scene ex_section_scene = new Scene(exercices_parent);
              Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
              
              second_stage.setScene(ex_section_scene);
              second_stage.show();
          } catch (IOException ex) {
              
          } 
    }

  @FXML
    public void handleClicks(ActionEvent actionEvent) {
        
    }

  
  
  
  

    
}
