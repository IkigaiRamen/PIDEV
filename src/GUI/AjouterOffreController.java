package GUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.entities.Offre;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            Education.getItems().addAll(edu);
    }
    
    public void getEducation (ActionEvent event){
      
    }
 
    
    public void ajouteroffre(ActionEvent event) {
    String position = poste.getText();
    String description = Description.getText();
    String adresse = Adresse.getText();
    String education = Education.getValue();
    String salaire = Salaire.getText();
    float f = Float.valueOf(salaire);
    String mission = Mission.getText();
    String dateFin = Datefin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    
   
  
                    
    Offre o = new Offre (position,description,education,adresse,mission,f,"true","ckjd",dateFin);
    OffreServices os = new OffreServices();
    os.ajoutOffre(o);
    
   
    }

    
    
    
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn_Messagerie) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btn_listOffre) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btn_Acceuil) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btn_Profile)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }


   
}
