/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pidev.entities.Developpeur;
import pidev.entities.Role;
import static pidev.entities.Role.Developpeur;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ProfileDeveloppeurController implements Initializable {

    @FXML
    private Button btnAcceuil;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnOffre;
    @FXML
    private Button btnDiscussion;
    @FXML
    private Label UserNameLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DeveloppeurService ds= new DeveloppeurService();
        Developpeur d = ds.getDevByUserName(UserSession.userName);
        
    }    

    @FXML
    private void Acceuil(ActionEvent event) {
    }

    @FXML
    private void profile(ActionEvent event) {
    }

    @FXML
    private void offres(ActionEvent event) {
    }

    @FXML
    private void discussion(ActionEvent event) {
    }
    
}
