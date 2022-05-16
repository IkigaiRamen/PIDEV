/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
    import pidev.entities.Demande;
import pidev.services.DemandeServices;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class ModifierDemandeController implements Initializable {

   
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
    Demande d ;
    int id;
    @FXML
    private Button btnvalider;
    @FXML
    private TextArea descs;
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
        dateFin.setValue(d.getDateFin().toLocalDate());
       // Date mockdate=d.getDateFin();
       // LocalDate ld = convert(mockdate);
        //dateFin.setValue(ld);
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
    private void modifierDemande(ActionEvent event) throws ParseException {
    ItemController item= new ItemController();
    int iddemande=item.getId();
    String titre=titreid.getText();
    String description=descs.getText();
    String types=type.getSelectionModel().getSelectedItem();
    String cats=cat.getSelectionModel().getSelectedItem();
    Float salaire=Float.valueOf(sal.getText());
    String adresse= adr.getText();
    java.sql.Date sqlDate = java.sql.Date.valueOf(dateFin.getValue());
    Demande dmock= new Demande(iddemande,titre,description ,cats,types,adresse,salaire,sqlDate);
    DemandeServices ds=new DemandeServices();
    System.out.println("id number" +id);        
    ds.updateDemande(dmock);
      try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            retour.getScene().setRoot(root);
         } catch (IOException ex) {
    
    }
      
 
    }
      @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void Messagerie(ActionEvent event) throws IOException {
       /*   Parent root = FXMLLoader.load(getClass().getResource("/ChatUI/ListDiscussion.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
        /*  Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }

    @FXML
    private void Demandes(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));
            btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void Certificat(ActionEvent event) throws IOException {
         /* Parent root = FXMLLoader.load(getClass().getResource("/GUI/AjouterDemande.fxml"));
            btn_Acceuil.getScene().setRoot(root);*/
    }
}

