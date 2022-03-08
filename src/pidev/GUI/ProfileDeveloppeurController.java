/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import pidev.entities.Developpeur;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;
import pidev.services.ImagesServices;

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
    ImagesServices is =new ImagesServices();
    @FXML
    private ImageView profilimg;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            /* LabelName.setText(d.getNom() +" " + d.getPrenom());
            LabelExperience.setText(d.getExperience());
            LabelSpecialite.setText(d.getSpecialite());
            LabelEducation.setText(d.getEducation());*/
            BufferedImage img= ImageIO.read(is.getImg(d.getId()));
            Image convert= SwingFXUtils.toFXImage(img,null);
            profilimg.setImage(convert);
        } catch (IOException ex) {
            Logger.getLogger(ProfileDeveloppeurController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDeveloppeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
