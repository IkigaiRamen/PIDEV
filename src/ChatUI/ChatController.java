/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pidev.entities.Message;
import pidev.services.MessageService;

/**
 * FXML Controller class
 *
 * @author khoualdi koussay
 */
public class ChatController implements Initializable {
  @FXML
    private TextField Contenu;
    @FXML
    private Button send;
    private  Date dateCreation = null ;

   

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    
        
  
  

    @FXML
    private void creerMessage(ActionEvent event) {
      
        String contenu = Contenu.getText();
        Message m = new Message (44,dateCreation,contenu);
  
        MessageService ps = new MessageService();
        ps.creerMessage(m);
    }
    
}
