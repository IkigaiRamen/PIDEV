
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;
import static GUI.ListeOffreController.o;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import pidev.entities.Discussion;
import pidev.entities.Employeur;
import pidev.entities.Offre;
import pidev.entities.Role;
import pidev.entities.UserSession;
import pidev.services.DeveloppeurService;
import pidev.services.EmployeurService;

/**
 *
 * @author khale
 */
public class ListeDiscussionCell extends ListCell<Discussion> {

   
    
    
    private final GridPane gridPane = new GridPane(); 
    private final Label nom = new Label(); 
    //private final Label message = new Label();  
    private final AnchorPane content = new AnchorPane();
   
    
    
     public ListeDiscussionCell() {
         
         nom.setStyle(" -fx-font-size: 1.5em;"); 
        nom.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(nom, 1, 0); 
        
       // message.setStyle("-fx-font-size: 1.5em; ");
       // message.setStyle("-fx-font-weight: bold;");
      
       // GridPane.setConstraints(message, 2, 0); 
       
                
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
       
        gridPane.setHgap(20); 
        gridPane.setVgap(10); 
        //gridPane.getChildren().setAll(nom,message); 
       content.getChildren().add(gridPane); 
               
        
    }
    // 
        
        
  
  
    @Override 
    protected void updateItem(Discussion d, boolean empty) { 
         
       
        super.updateItem(d, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.CENTER); 
        
        if (!empty && d != null) { 
            
           // 
            
           //
            EmployeurService es= new EmployeurService();
            DeveloppeurService ds = new DeveloppeurService();
            try {  
                if(UserSession.role.equals(Role.Developpeur)){
                nom.setText(es.getEmpById(d.getIdEmp()).getUserName());}
                else{
                  nom.setText(ds.getDevById(d.getIdEmp()).getUserName());  
                }   
                setGraphic(nom);
                setText(nom.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ListeDiscussionCell.class.getName()).log(Level.SEVERE, null, ex);
            }
            //message.setText(d.get); 
          
            
            
             
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 

   

    
}