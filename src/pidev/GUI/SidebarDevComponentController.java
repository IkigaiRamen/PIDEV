/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class SidebarDevComponentController implements Initializable {

    @FXML
    private Button btnAcceuil;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnMessagerie;

    @FXML
    private Button btnOffres;

    @FXML
    private Button btnCertif;

    @FXML
    private Button btnPoste;

    @FXML
    private Button btnSettings2;

    @FXML
    private Button btnSignout;
    
    @FXML
    private AnchorPane navbar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
