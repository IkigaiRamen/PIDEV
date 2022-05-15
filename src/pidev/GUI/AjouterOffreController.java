package GUI;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;

import java.time.LocalDate;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entities.Offre;
import pidev.services.DemandeMailing;
import pidev.services.OffreServices;

public class AjouterOffreController implements Initializable {

    private VBox pnItems = null;
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
    private Button btnAjouter;

    @FXML
    private Button retour;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    @FXML
    private TextField poste;
    @FXML
    private TextArea Description;
    @FXML
    private ChoiceBox<String> Education;
    private final String[] edu ={"Liscence","Master","Ingénierie","Doctorat"};
    @FXML
    private TextField Salaire;
    @FXML
    private TextArea Adresse;
    @FXML
    private DatePicker Datefin;
    @FXML
    private TextArea Mission;
    @FXML
    private Button submit;
    @FXML
    private TextField Titre;
          
    
    OffreServices of=new OffreServices();
        
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
            Education.getItems().addAll(edu);
            
             btn_listOffre.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
             btn_listOffre.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
             retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
             btn_listOffre.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
            Datefin.setDayCellFactory(picker -> new DateCell() {
                
        @Override
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            LocalDate today = LocalDate.now();

            setDisable(empty || date.compareTo(today) < 0 );
        }
    });
    }
    
    public void getEducation (ActionEvent event){
      
    }
 
    
    @FXML
    public void ajouteroffre(ActionEvent event) throws IOException, Exception {
    String titre = Titre.getText();
    String position = poste.getText();
    String description = Description.getText();
    String adresse = Adresse.getText();
    String education = Education.getValue();
    String salaire = Salaire.getText();
    float f = Float.valueOf(salaire);
    String mission = Mission.getText();
    Date dateFin = Date.valueOf(Datefin.getValue());
    
    
    if(Titre.getText().trim().isEmpty()||poste.getText().trim().isEmpty()||Description.getText().trim().isEmpty()||
            Adresse.getText().trim().isEmpty()||Education.getValue().trim().isEmpty()||Salaire.getText().trim().isEmpty()||
            Mission.getText().trim().isEmpty()){
       Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("Champs vide !");
        fail.showAndWait(); 
       
        
    }else{
    
   
            
    Offre o = new Offre (titre,position,description,education,adresse,mission,f,"true",dateFin);
    OffreServices os = new OffreServices();
    os.ajoutOffre(o);
       // DemandeMailing D = new DemandeMailing();
       // D.mailing2("khaled.salhi@esprit.tn");
    try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("ListeOffre.fxml"));
              Scene ex_section_scene = new Scene(exercices_parent);
              Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
              
              second_stage.setScene(ex_section_scene);
              second_stage.show();
          } catch (IOException ex) {
              
          }    
     
      //  TrayNotification tray = null;
       // tray = new TrayNotification("Demande de travail ajouteé", "Votre demande a ete ajoutee avec succes ,Merci ", NotificationType.SUCCESS);
       
      //  tray.showAndDismiss(javafx.util.Duration.seconds(5));
    }
   
    }

    
    @FXML
  protected void onbtnAjouterClick() throws InterruptedException {
    Alert fail= new Alert(AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("Champs vide !");
        fail.showAndWait();
  }
     
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        
    }


   
}
