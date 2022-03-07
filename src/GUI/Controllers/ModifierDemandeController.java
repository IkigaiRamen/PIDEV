/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
    import pidev.entities.DemandeTravail;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ModifierDemandeController implements Initializable {

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
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField titreid;
    @FXML
    private Button retour;
    @FXML
    private TextField sal;
    @FXML
    private TextField adr;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private ChoiceBox<String> cat;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Button btnCV;
    private final String[] catC ={"Design","Front-end","Back-end","Intégrateur","Full-Stack","Mern"};
    private final String[] typeC ={"A plein temps","A temps Partiel","Freelance","Permenant"};
    DemandeTravail d ;
    int id;
    @FXML
    private Button btnvalider;
    @FXML
    private TextArea descs;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                ItemController item= new ItemController();
                int id=item.getId();
          DemandeServices ds = new DemandeServices();
         d= ds.afficherDemandeById(id);                  
        type.getItems().addAll(typeC);
        cat.getItems().addAll(catC);
        titreid.setText(d.getTitle());
        type.setValue(d.getCategory());
        cat.setValue(d.getType());
        
        descs.setText(d.getDescription());
        adr.setText(d.getLocation());
        sal.setText(String.valueOf(d.getSalaire()));
       // Date mockdate=d.getDateFin();
       // LocalDate ld = convert(mockdate);
        //dateFin.setValue(ld);
    }    
    
  

    @FXML
    private void handleClicks(ActionEvent event) {
    }


    @FXML
    private void Retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjoutDemandeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
    

    @FXML
    private void singleFileChooser(ActionEvent event) {
    }

    @FXML
    private void modifierDemande(ActionEvent event) {
    ItemController item= new ItemController();
                int id=item.getId();
               System.out.println("this is the controller id " +id);
    String titre=titreid.getText();
    String description=descs.getText();
    String types=type.getSelectionModel().getSelectedItem();
    String cats=cat.getSelectionModel().getSelectedItem();
    Float salaire=Float.valueOf(sal.getText());
    String adresse= adr.getText();
    
    DemandeTravail dmock= new DemandeTravail(id,titre,description ,cats,types,adresse,salaire);
    DemandeServices ds=new DemandeServices();
    System.out.println("id number" +id);        
    ds.updateDemande(dmock);
    
    }
 
}
