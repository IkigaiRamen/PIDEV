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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javax.imageio.ImageIO;
import pidev.entities.Developpeur;
import pidev.entities.EvaluationEntity;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;
import pidev.services.EvaluationService;
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
    @FXML
    private HBox hboxBadges;
    
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
            
            
            ////////////////////////Badges//////////////////::::
            EvaluationService es = new EvaluationService();
            
            
            int idDev = ds.getDevByUserName(UserSession.userName).getId();
            List<EvaluationEntity> evaluations = es.getByUser(idDev);
            
            for(int i=0; i<evaluations.size();i++){
                if(evaluations.get(i).isSuccess()){
                    VBox vbox = new VBox();
                    vbox.setAlignment(Pos.CENTER);
                    ImageView badge = new ImageView();
                    badge.setFitHeight(50);
                    badge.setFitWidth(50);
                    badge.setImage(new Image(getClass().getResource("..\\..\\Resources\\badge.png").toString()));
                    vbox.getChildren().add(badge);
                    Label lblTitre = new Label(evaluations.get(i).getTest().getTitre());
                    lblTitre.setTextFill(Paint.valueOf("orange"));
                    vbox.getChildren().add(lblTitre);

                    hboxBadges.getChildren().add(vbox);
                }
            }
            
            //////////////////////////////::End Badges///////////////////////////////////
            
            
          
        } catch (IOException ex) {
            Logger.getLogger(ProfileDeveloppeurController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDeveloppeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
