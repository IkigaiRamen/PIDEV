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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import pidev.entities.Demande;
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

    

   
    @FXML
    private TextField titreid;
    private TextField desc;
    private TextField sal;
    private TextField adr;
    private ChoiceBox<String> type;
    private ChoiceBox<String> cat;
    private final String[] catC ={"Design","Front-end","Back-end","Intégrateur","Full-Stack","Mern"};
    private final String[] typeC ={"A plein temps","A temps Partiel","Freelance","Permenant"};
    private DatePicker dateFin;
    private Button btnCV;
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
    void singleFileChooser(ActionEvent event){
     FileChooser fc= new FileChooser();
     fc.getExtensionFilters().add(new ExtensionFilter("Fichiers PDF","*.pdf"));
     File f = fc.showOpenDialog(null);
     if(f != null)
     btnCV.setText(f.getAbsolutePath());
     }
   

   private void Retour(ActionEvent event) {
try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    public void ajouterDemande(ActionEvent event) throws IOException, Exception{
    String titre=titreid.getText();
    String description=desc.getText();
    String types=type.getSelectionModel().getSelectedItem();
    String cats=cat.getSelectionModel().getSelectedItem();
    Float salaire=Float.valueOf(sal.getText());
    String adresse= adr.getText();
    Date date=Date.valueOf(dateFin.getValue());
    Demande d= new Demande(titre,description ,cats,types,adresse,salaire,date);
    DemandeServices ds=new DemandeServices();
    ds.ajouterDemande(d);
    System.out.println("this is a test");
    System.out.println(d.toString());
    DemandeMailing mailservice = new DemandeMailing();
   // mailservice.mailing("khaled.salhi@esprit.tn");
   
    
    try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
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
    private void Acceuil(ActionEvent event) throws IOException {
        
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }


    private void Demandes(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }


    
    }
    
  
    
