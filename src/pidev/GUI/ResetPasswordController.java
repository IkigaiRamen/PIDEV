/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import pidev.services.UserService;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ResetPasswordController implements Initializable {

    @FXML
    private Button btnVerifier;
    @FXML
    private PasswordField txtPassowrd;

    /**
     * Initializes the controller class.
     */
    
    OublierPasswordController opc;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void verifier(ActionEvent event) throws SQLException {
        UserService us= new UserService();
        us.UpdatePassword(us.md5(txtPassowrd.getText()), opc.email);
        
    }
    
}
