/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pidev.entities.Employeur;
import pidev.entities.Societe;
import pidev.services.EmployeurService;
import pidev.services.SocieteService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class EmployeurModifierController implements Initializable {

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
    private TextField labelEmail;
    @FXML
    private TextField LabelPrenom;
   
    @FXML
    private TextField labelProfession;

    /**
     * Initializes the controller class.
     */
    
    GestionEmployeursController gec= new GestionEmployeursController();
    Employeur e=gec.e;
    int id=e.getId();
    SocieteService ss= new SocieteService();
    
    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtAdresse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LabelNom.setText(e.getNom());
        LabelPrenom.setText(e.getPrenom());
        labelProfession.setText(e.getProfession());
        labelEmail.setText(e.getEmail());
        


    }    

    @FXML
    private void modif(ActionEvent event) {
    EmployeurService es = new EmployeurService();
    
        System.out.println(labelEmail.getText());
        System.out.println(e.getId());
        es.modifierEmployeur(e.getId(), labelEmail.getText(), e.getPassword(), LabelNom.getText(), LabelPrenom.getText(), labelProfession.getText());
        try {
                Parent root = FXMLLoader.load(getClass().getResource("GestionEmployeurs.fxml"));
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
