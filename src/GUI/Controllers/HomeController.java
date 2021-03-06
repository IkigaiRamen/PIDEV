/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import static GUI.Controllers.MesDemandesController.d;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pidev.entities.DemandeTravail;
import pidev.entities.UserSession;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    private Pane pnlCustomer;
    private Pane pnlOrders;
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    
    public static int z;
    DemandeServices ds = new DemandeServices();
    UserSession us;
    public static DemandeTravail d ;
    
    ObservableList<DemandeTravail> list = FXCollections.observableArrayList(ds.afficherDemande(d.getId()));
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblactive;
    @FXML
    private Label lblinactive;
    @FXML
    private Button btnAjout;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
               
                final int j = i;
                z=i;
                nodes[i] = FXMLLoader.load(getClass().getResource("/GUI/item.fxml"));

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
            lblactive.setText(String.valueOf(ds.AfficherActive()));
            lblinactive.setText(String.valueOf(ds.AfficherInactive()));
        }

    }
    
    
    
     public DemandeTravail getD(){
     return d;
     }
     
    public int returnZ(){
    return z;
    }


    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btnAjout.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjoutDemandeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}