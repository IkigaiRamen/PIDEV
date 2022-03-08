/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import static GUI.Controllers.MesDemandesController.d;
import com.sun.prism.paint.Color;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pidev.entities.DemandeTravail;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ItemController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label Titre;
    @FXML
    private Label type;
    @FXML
    private Label category;
    @FXML
    private Label etat;
    DemandeServices ds = new DemandeServices();
    DemandeTravail d;
    ObservableList<DemandeTravail> list = FXCollections.observableArrayList(ds.afficherDemande());
    public static int i;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnView;
    @FXML
    private Button btnDelete;
   

    public static int id;
    @FXML
    private Label txtetat;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      HomeController mdc = new HomeController();
     int i=mdc.returnZ();
     
        System.out.println(i);
        d=list.get(i-1);
        id=d.getId();
       System.out.println(d.getTitle());
         Titre.setText(d.getTitle());
         Titre.setWrapText(false);
        type.setText(d.getType());
        type.setWrapText(false);
        category.setText(d.getCategory());
        category.setWrapText(false);
        System.out.println(d.getEtat()+"this is the state");
        if(d.getEtat().equals("true")){
            txtetat.setStyle("-fx-text-fill: green;");
            txtetat.setWrapText(false);
            txtetat.setText("Active");}
        else
        {
            txtetat.setStyle("-fx-text-fill: red; ");
            txtetat.setWrapText(false);
            txtetat.setText("Inactive");}

        
         btnEdit.setOnAction(e -> {
            //(String id,String nom, String adresse, String prix, String surface,String capacite)


            if (!(d == null)) {
                try {
                    System.out.println(d.getId());
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("/GUI/ModifierDemande.fxml"));
                    btnEdit.getScene().setRoot(root);
                } catch (IOException ex) {
              Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
         
         btnDelete.setOnAction(e-> {
         ds.supprimerDemande(d.getId());  try {
      
         
         Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));

            
              btnEdit.getScene().setRoot(root);
              
          } catch (IOException ex) {
              Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
          }
                    
         });
         
         
       
    }   
    
    public int getI(){
   return i; }
    public DemandeTravail getD(){
    return d;
    }
    
    public int getId(){
    return id;
    }


    @FXML
    private void Afficher(ActionEvent event) {
        
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        ds.supprimerDemande(d.getId());
    }
    
}
