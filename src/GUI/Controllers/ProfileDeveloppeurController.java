/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import pidev.entities.UserSession;
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
    ImagesServices is =new ImagesServices();
    @FXML
    private ImageView profilimg;
    @FXML
    private Button btncertif;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /*  LabelName.setText(d.getNom() +" " + d.getPrenom());
        LabelExperience.setText(d.getExperience());
        LabelSpecialite.setText(d.getSpecialite());
        LabelEducation.setText(d.getEducation());*/
        
        //  if BufferedImage img= ImageIO.read(is.getImg(d.getId()));
        //  Image convert= SwingFXUtils.toFXImage(img,null);
        //  profilimg.setImage(convert);
        
    }    

    @FXML
    private void Acceuil(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home2.fxml"));

                         btn_Acceuil.getScene().setRoot(root);
    }
    
    

    @FXML
    private void Message(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("SeConnceter.fxml"));

                         btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void Profile(ActionEvent event) {
    }

    @FXML
    private void Demandes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Home.fxml"));

                         btn_Acceuil.getScene().setRoot(root);
    }

    @FXML
    private void certif(ActionEvent event) throws IOException {
                   Parent root = FXMLLoader.load(getClass().getResource("/GUI/CertificationList.fxml"));
                         btn_Acceuil.getScene().setRoot(root);

        
    }
    
}
