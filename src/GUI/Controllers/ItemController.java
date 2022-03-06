/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnView;
    @FXML
    private Button btnDelete;
   



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
      
       System.out.println(d.getTitle());
        
     Titre.setText(d.getTitle());
        type.setText(d.getType());
        category.setText(d.getCategory());
        etat.setText(d.getEtat());
        // TODO
       
    }    
    
}
