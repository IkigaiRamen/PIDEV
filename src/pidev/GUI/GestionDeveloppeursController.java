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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pidev.entities.Developpeur;
import static pidev.entities.Role.Developpeur;
import pidev.services.DeveloppeurService;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class GestionDeveloppeursController implements Initializable {

    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField txtSearch;
    @FXML
    private ListView<Developpeur> table;
    @FXML
    private Button mod;
    @FXML
    private Button sup;
    @FXML
    private Button aff;

    /**
     * Initializes the controller class.
     */
    DeveloppeurService ds= new DeveloppeurService(); 
    ObservableList<Developpeur> list = FXCollections.observableArrayList(ds.afficherDeveloppeur());
       
    public static Developpeur d ;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setCellFactory(lv -> new DeveloppeurListCell());
        System.out.println(list);
        table.setItems(list);
    }    

    @FXML
    private void modif(ActionEvent event) {
        d =table.getSelectionModel().getSelectedItem();
        
        if(!(d== null)){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("DeveloppeurModifier.fxml"));
                Scene scene = new Scene(root);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

                    
                 } 
                 catch (IOException ex) {
                     Logger.getLogger(SeConnceterController.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        else{
            System.out.println("does not exist");
        }
            
        }
        
    

    @FXML
    private void deleteDeveloppeur(ActionEvent event) {
        d=table.getSelectionModel().getSelectedItem();
        if(!(d== null)){
            try{
                ds.supprimerDeveloppeur(d.getId());
                Parent root = FXMLLoader.load(getClass().getResource("GestionDeveloppeurs.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage )((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
    
}
