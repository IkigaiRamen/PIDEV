/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.entities.Developpeur;
import static pidev.entities.Role.Developpeur;
import pidev.services.DeveloppeurService;
import pidev.services.ImagesServices;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class DeveloppeurModifier implements Initializable {

    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btnAjouter;
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
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button mod;
    @FXML
    private TextField LabelNom;
    @FXML
    private TextArea labelExperience;
    @FXML
    private TextArea labelBio;
    @FXML
    private TextField labelEmail;
    @FXML
    private TextField LabelPrenom;
    @FXML
    private TextField labelEducation;
    @FXML
    private TextField labelSpecialite;
    public File image;
    public FileInputStream fis;


    /**
     * Initializes the controller class.
     */
     GestionDeveloppeursController gdc = new GestionDeveloppeursController();

     Developpeur d=gdc.d;
     String path;
    @FXML
    private Button btnProfile;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LabelNom.setText(d.getNom());
        LabelPrenom.setText(d.getPrenom());
        labelBio.setText(d.getBio());
        labelEducation.setText(d.getEducation());
        labelEmail.setText(d.getEmail());
        labelExperience.setText(d.getExperience());
        labelSpecialite.setText(d.getSpecialite());
        
    }    
            ImagesServices is= new ImagesServices();

    @FXML
     void singleFileChooser(ActionEvent event) throws FileNotFoundException, SQLException{
     FileChooser fc= new FileChooser();
     fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers Images","*.png","*.jpeg"));
     image = fc.showOpenDialog(null);
     if(image != null){
         path=image.getAbsolutePath();
        System.out.println(path);}
       // sendImg(10, (int) image.length());
       fis=new FileInputStream(image);
       fis.toString();
        FileInputStream img = new FileInputStream(image);
       System.out.println(img.toString());
        is.updateImg(img,10, (int) image.length());
       
     }

      private void sendImg ( int id , int length) throws FileNotFoundException, SQLException{
       
        
      
      }
        
   
    @FXML
    private void modif(ActionEvent event) {
        DeveloppeurService ds = new DeveloppeurService();
        System.out.println(labelEmail.getText());

        ds.modifierDeveloppeur(d.getId(), labelEmail.getText(), d.getPassword(), LabelNom.getText(), LabelPrenom.getText(), labelEducation.getText(), labelExperience.getText(), labelBio.getText(), labelSpecialite.getText());
        try {
                Parent root = FXMLLoader.load(getClass().getResource("GestionDeveloppeurs.fxml"));
                Scene scene = new Scene(root);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

         } 
                 catch (IOException ex) {
                     Logger.getLogger(SeConnceterController.class.getName()).log(Level.SEVERE, null, ex);
                 }
    }
    
}
