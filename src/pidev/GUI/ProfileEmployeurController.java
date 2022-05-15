/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import pidev.entities.Developpeur;
import pidev.entities.Employeur;
import pidev.entities.Societe;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;
import pidev.services.EmployeurService;
import pidev.services.ImagesServices;
import pidev.services.SocieteService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ProfileEmployeurController implements Initializable {

    @FXML
    private ImageView profilimg;
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
    private Label LabelProfession;
    @FXML
    private Label LabelSocietenom;
    @FXML
    private Label DesSoc;
    @FXML
    private Label LabelDes;
    @FXML
    private Label Labeltele;
    @FXML
    private Label LabelSocEmail;
    EmployeurService es= new EmployeurService();
    Employeur e= es.getEmpByUserName(UserSession.userName);
    ImagesServices is =new ImagesServices();
    Societe s = new Societe ();
    SocieteService ss= new SocieteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            s= ss.getSocietebyIdEmp(e.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ProfileEmployeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LabelName.setText(e.getNom() + " "+ e.getPrenom());
        LabelDes.setText(s.getDescription());
        LabelProfession.setText(e.getProfession());
        LabelSocEmail.setText(s.getEmail());
        LabelSocietenom.setText(s.getNom());
        Labeltele.setText(s.getTelephone());
    }    
    
}
