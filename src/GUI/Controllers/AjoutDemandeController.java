/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import pidev.entities.DemandeTravail;
import pidev.services.DemandeMailing;
import pidev.services.DemandeServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class AjoutDemandeController implements Initializable {

    
        FileChooser fileChooser = new FileChooser();

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
    private TextField titreid;
    @FXML
    private TextField desc;
    @FXML
    private Button btnvalider1;
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
    private final String[] catC ={"Design","Front-end","Back-end","Intégrateur","Full-Stack","Mern"};
    private final String[] typeC ={"A plein temps","A temps Partiel","Freelance","Permenant"};
    @FXML
    private DatePicker dateFin;
    @FXML
    private Button btnCV;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        type.getItems().addAll(typeC);
        cat.getItems().addAll(catC);
       
dateFin.setDayCellFactory(picker -> new DateCell() {
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();

            setDisable(empty || date.compareTo(today) < 0 );
        }
    });
        

    }    
    @FXML
     void singleFileChooser(ActionEvent event){
     FileChooser fc= new FileChooser();
     fc.getExtensionFilters().add(new ExtensionFilter("Fichiers PDF","*.pdf"));
     File f = fc.showOpenDialog(null);
     if(f != null)
     btnCV.setText(f.getAbsolutePath());
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
        if (actionEvent.getSource() == btnOverview ) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
           if (actionEvent.getSource() == btnvalider1 ) {
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
   private void Retour(ActionEvent event) {
try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("/GUI/MesDemandes.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    public void ajouterDemande(ActionEvent event) throws IOException, Exception{
    String titre=titreid.getText();
    String description=desc.getText();
    String types=type.getSelectionModel().getSelectedItem();
    String cats=cat.getSelectionModel().getSelectedItem();
    Float salaire=Float.valueOf(sal.getText());
    String adresse= adr.getText();
    Date date=Date.valueOf(dateFin.getValue());
    Path path= Paths.get(btnCV.getText());
    DemandeTravail d= new DemandeTravail(titre,description ,cats,types,adresse,salaire,date);
    DemandeServices ds=new DemandeServices();
    ds.ajouterDemande(d);
    DemandeMailing mailservice = new DemandeMailing();
    mailservice.mailing("khaled.salhi@esprit.tn");
   
    
    try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("/GUI/MesDemandes.fxml"));
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
    
    }
    
  
    
