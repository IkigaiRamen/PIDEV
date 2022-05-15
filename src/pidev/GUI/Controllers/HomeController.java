/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class HomeController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private Label lbltotal;
    @FXML
    private Label lblactive;
    @FXML
    private Label lblinactive;
    @FXML
    private Button btnAjout;
    @FXML
    private VBox pnItems;
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
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private ImageView profilimg1;
    @FXML
    private Button btn_Acceuil1;
    @FXML
    private Button btn_Messagerie1;
    @FXML
    private Button btn_Profile1;
    @FXML
    private Button btn_listOffre1;
    @FXML
    private Button btnSettings1;
    @FXML
    private Button btnSignout1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
    }

    @FXML
    private void messages(ActionEvent event) {
    }

    @FXML
    private void demandes(ActionEvent event) {
    }

    @FXML
    private void goCertification(ActionEvent event) {
    }
    
}
