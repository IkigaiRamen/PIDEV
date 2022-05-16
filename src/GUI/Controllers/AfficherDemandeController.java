/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import pidev.entities.User;
import pidev.entities.UserSession;
import pidev.services.DemandeServices;
import pidev.services.UserService;

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
    private Label titre;
    private Label category;
    private Label salaire;
    private Label descs;
    private Label type;
    private Label adresse;
    private Label date;
    @FXML
    private Button retour;
    @FXML
    private Label txttitre;
    @FXML
    private Label txtdescription;
    @FXML
    private Label txtdate;
    @FXML
    private Label txttype;
    @FXML
    private Label txtexp;
    @FXML
    private Label txtqual;
    @FXML
    private Label txtcity;
    @FXML
    private Label txtlocation;
    @FXML
    private Label txtsalairemin;
    @FXML
    private Label txtsalairemax;
    @FXML
    private Label txtsex;
    @FXML
    private Label txtexpire;
    @FXML
    private Label txtfirst;
    @FXML
    private Label txtlast;
    UserSession us;
    UserService user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*   int id=us.getId();
        try {
            User current = user.getUserById(id);
       */
         ItemController item= new ItemController();
         int iddemande=item.getId();
          DemandeServices ds = new DemandeServices();
         d= ds.afficherDemandeById(iddemande); 
        txttitre.setText(d.getTitre());
                txtdescription.setText(d.getTitre());
        txtdate.setText(d.getTitre());
        txttype.setText(d.getType());
        txtexp.setText(d.getExp());
        txtqual.setText(d.getQualification());
        txtcity.setText(d.getCity());
        txtsalairemin.setText(String.valueOf(d.getSalairemin()));
        txtsalairemax.setText(String.valueOf(d.getSalairemax()));
        txtsex.setText(d.getSex());
        txtexpire.setText(d.getExpire().toString());
        txtlocation.setText(d.getLocation());
     //   txtfirst.setText(current.getName());
       // txtlast.setText(current.getFirstname());
 /*} catch (SQLException ex) {
            Logger.getLogger(AfficherDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
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
