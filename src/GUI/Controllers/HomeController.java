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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pidev.entities.Demande;
import pidev.entities.UserSession;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class HomeController implements Initializable {

;
    @FXML
    private VBox pnItems;
    
    public static int z;
    DemandeServices ds = new DemandeServices();
    UserSession us;
    public static Demande d ;
    
    ObservableList<Demande> list = FXCollections.observableArrayList(ds.afficherDemande());
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblactive;
    @FXML
    private Label lblinactive;
    @FXML
    private Button btnAjout;
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
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlOverview;
    @FXML
    private ImageView profilimg1;
    @FXML
    private Button btn_Acceuil1;
    @FXML
    private Button btn_Messagerie1;
    @FXML
    private Button btn_Profile1;
    @FXML
    private Button btn_listOffre1;
    @FXML
    private Button btnSettings1;
    @FXML
    private Button btnSignout1;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("this is a test");
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
               
                final int j = i;
                z=i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/pidev.GUI/item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            lbltotal.setText(String.valueOf(ds.AfficherTotal()));
        }

    }
    
    
    
     public Demande getD(){
     return d;
     }
     
    public int returnZ(){
    return z;
    }



    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterDemande.fxml"));
            btnAjout.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjoutDemandeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void Acceuil(ActionEvent event) throws IOException {
        
            Parent root = FXMLLoader.load(getClass().getResource("AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }


    private void Demandes(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void messages(ActionEvent event) {
         /* Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }

    @FXML
    private void demandes(ActionEvent event) {
    }

    @FXML
    private void goCertification(ActionEvent event) {
    }
}
