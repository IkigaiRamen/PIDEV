/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.entities.Commentaire;
import pidev.services.CommentaireService;

/**
 * FXML Controller class
 *
 * 
 */
public class ModefierCommentController implements Initializable {

    @FXML
    private TextField cmt;
    
    CommentaireService cs = new CommentaireService();
    Commentaire c =  cs.findCommentId(ShowCommentController.idc);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmt.setText(c.getContenu());    }    

    @FXML
    private void ModifierComment(ActionEvent event) {
        
        cs.updateCommentaire(ShowCommentController.idc, cmt.getText(), c.getDate());
                  
                  try {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/ShowComment.fxml"));
            Stage myWindow =  (Stage) cmt.getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            myWindow.setTitle("");
            myWindow.show();
           
        } catch (IOException ex) {
           // Logger.getLogger(ReponseItemController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
