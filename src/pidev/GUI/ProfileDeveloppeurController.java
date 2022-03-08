/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import pidev.entities.Developpeur;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ProfileDeveloppeurController implements Initializable {

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
    private Label LabelName;
    @FXML
    private Label LabelExperience;
    @FXML
    private Label LabelEducation;
    @FXML
    private Label LabelSpecialite;
    
    DeveloppeurService ds= new DeveloppeurService();
    Developpeur d= ds.getDevByUserName(UserSession.userName);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LabelName.setText(d.getNom() +" " + d.getPrenom());
        LabelExperience.setText(d.getExperience());
        LabelSpecialite.setText(d.getSpecialite());
        LabelEducation.setText(d.getEducation());
        
    }    
    
}
