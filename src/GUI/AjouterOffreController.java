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
    private TextField txt_post;
    @FXML
    private TextField txt_description;
    @FXML
    private TextField txt_condition;
    @FXML
    private TextField txt_salaire;
    @FXML
    private Button submit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     private void ajouterOffre(ActionEvent event) {
        
        String position = txt_post.getText();
        String description=txt_description.getText();
        String condition = txt_condition.getText();
       // float  salaire = Float.parseFloat(txt_salaire.getText());
        
        Offre o = new Offre(position,description,condition);
        OffreServices of = new OffreServices();
        of.AjouterOffre(o);
    
}
}
