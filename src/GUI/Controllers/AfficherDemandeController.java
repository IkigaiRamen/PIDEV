/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pidev.entities.Demande;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class AfficherDemandeController implements Initializable {

    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlOverview;
    private Demande d;
    @FXML
    private ImageView profilimg;
    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Label titre;
    @FXML
    private Label category;
    @FXML
    private Label salaire;
    @FXML
    private Label descs;
    @FXML
    private Label type;
    @FXML
    private Label adresse;
    @FXML
    private Label date;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ItemController item= new ItemController();
         int iddemande=item.getId();
          DemandeServices ds = new DemandeServices();
         d= ds.afficherDemandeById(iddemande); 
         titre.setText(d.getTitre());
         descs.setText(d.getDescription());
         type.setText(d.getType());
         category.setText(d.getCategorie());
         adresse.setText(d.getLocation());
         date.setText(d.getType());
         salaire.setText(d.getCity());
    }

    @FXML
    private void Retour(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            retour.getScene().setRoot(root);
         } catch (IOException ex) {
            // Logger.getLogger(AjoutDemandeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
