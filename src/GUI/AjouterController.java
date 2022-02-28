package GUI;
import pidev.entities.Offre;
import pidev.services.OffreServices;
import pidev.entities.DemandeTravail;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.entities.DemandeTravail;
import pidev.services.DemandeServices;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class AjouterController implements Initializable {
    @FXML
    private TextField titreid;
    @FXML
    private TextField desc;
    @FXML
    private TextField adr;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private ChoiceBox<String> cat;
    @FXML
    private TextField sal;
String[] typeitems = {"A plein temps", "A temps partiel" , "Permenant", "Freelance"};
String[] categorieItems = {"front-end", "back-end" , "Design", "Integrateur"};

    @FXML
    private Label imagePath1;
    @FXML
    private Button btnvalider1;
    @FXML
    private Button retour;
    

@Override
    public void initialize(URL url, ResourceBundle rb) {
        
       type.getItems().addAll(typeitems);
       type.getSelectionModel().selectFirst();
       type.setOnAction(this::getType);
       cat.getItems().addAll(categorieItems);
       cat.getSelectionModel().selectFirst();
       type.setOnAction(this::getCategory);
       
    }    
    
    private String getCategory(ActionEvent event){
    String myCategory = cat.getValue();
    return myCategory;
    }
    private String getType(ActionEvent event){
    String mytype = type.getValue();
    return mytype;
    }
    @FXML
    private void ajouterOffre(ActionEvent event) {
        
        String titre = titreid.getText();
        String description=desc.getText();
        String choix = this.getType(event);
        String fsal=sal.getText();
         float  salaire = Float.parseFloat(fsal);
        String choixcat= this.getCategory(event);
        String location = adr.getText();
        DemandeTravail d = new DemandeTravail(titre,description,choixcat,choix,location,salaire);
        DemandeServices ds = new DemandeServices();
        ds.ajouterDemande(d);
        
 try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
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
    
    @FXML
    private void retour(ActionEvent event) {
try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }
    
 
    
}