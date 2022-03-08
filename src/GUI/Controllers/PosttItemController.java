/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import pidev.entities.Post;

/**
 * FXML Controller class
 *
 */
public class PosttItemController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Text nomuser;
    @FXML
    private Text type;
    
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 
   
    }  
    
    public PosttItemController(){
    
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/PosttItem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        
    }

    public HBox getBox() {
        return Hbox;
    }
    
        public void setInfo(Post don)  {   
          System.out.println("controller.ListViewEvent.updateItemeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeekkkkkkkkkkkkkkkkkkkk"+don);

            
        type.setText(don.getdescription());
      //  nomuser.setText(Date);
     
     
}
        
}
