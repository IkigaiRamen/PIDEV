/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Controllers.ShowPostsController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import pidev.entities.Post;
import pidev.services.PostService;

/**
 * FXML Controller class
 *
 
 */
public class ModefierPostController implements Initializable {

    @FXML
    private TextArea description;
    
    PostService ps = new PostService();
    
            Post p = ps.findPostId(ShowPostsController.idE);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        description.setText(p.getdescription());
        
        
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
                if (description.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Complete vos cordnner", ButtonType.OK);
           alert.showAndWait();
        }
        
  else {
           p.setdescription(description.getText());
            LocalDate dd = LocalDate.now();
            Date date = java.sql.Date.valueOf(dd);
           p.setdate_p((java.sql.Date) date);
          
            ps.updatePost(ShowPostsController.idE,description.getText(), (java.sql.Date) date);
        
            Parent root ;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/ShowPosts.fxml"));
            Stage myWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            myWindow.setScene(sc);
            //myWindow.setFullScreen(true);
            myWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(AddPostController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        }
            
    }
    
    
}
