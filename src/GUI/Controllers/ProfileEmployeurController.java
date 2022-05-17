/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Khammessi
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
    private Label LabelSpecialite;
    @FXML
    private Label LabelEducation;
    @FXML
    private Label LabelExperience;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
