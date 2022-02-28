/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.entities.Offre;
import pidev.services.OffreServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.entities.DemandeTravail;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField titreid;
    @FXML
    private TextField desc;
    @FXML
    private TextField adr;
    @FXML
    private Button btnvalider;
    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button planning;
    @FXML
    private Label imagePath;
    @FXML
    private Button user;
    @FXML
    private Button retour;
    @FXML
    private MenuButton type;
    @FXML
    private MenuButton cat;
    @FXML
    private TextField sal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterOffre(ActionEvent event) {
        
        String titre = titreid.getText();
        String description = desc.getText();
        String typet =type.getText();
        float salaire= Float.parseFloat(sal.getText());
        String catt= cat.getText();
        String location = adr.getText();
     DemandeTravail(String title, String Category, String type, String location, String salaire, String cv)
        
        DemandeTravail d = new DemandeTravail(titre,catt,typet,location,salaire);
        panierCRUD pc = new panierCRUD();
        pc.ajouterPanier2(p);
        
       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("affiche.fxml"));
        
        try {
            Parent root = loader.load();
            AfficheController ac = loader.getController();
            ac.setTextID(""+p.getId());
            ac.setTextNom(p.getNom());
            ac.setTextPrix(""+p.getPrix());
            ac.setTextqte(""+p.getQte());
            ac.setTexttotale(""+p.getTotal());
            
            
           // tfNom.getScene().setRoot(root);
           
            
            
            
        } catch (IOException ex) {
            System.out.println("Error :"+ex.getMessage());
        }
       */
        try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("affiche.fxml"));
              Scene ex_section_scene = new Scene(exercices_parent);
              Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
              
              second_stage.setScene(ex_section_scene);
              second_stage.show();
          } catch (IOException ex) {
              
          }    
        TrayNotification tray = null;
        tray = new TrayNotification("Demande de travail ajouteé", "Votre demande a ete ajoutee avec succes ,Merci ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
}


    private void produit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
    }


    @FXML
    private void retour(ActionEvent event) {
        
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("GestionPanier.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }
    
 
    
}
