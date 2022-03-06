/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static GUI.ListeOffreController.o;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.Date;
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
import pidev.entities.Offre;

/**
 *
 * @author khale
 */
public class OffreListeCell extends ListCell<Offre> {

   
    
    
    private final GridPane gridPane = new GridPane(); 
    private final Label PosteLabel = new Label(); 
    private final Label DescriptionLabel = new Label(); 
    private final Label AdresseLabel = new Label(); 
    private final Label NiveauLabel = new Label(); 
    private final Label SalaireLabel = new Label(); 
    private final Label MissionLabel = new Label(); 
    private final Label dateLimiteLabel = new Label(); 
    
    //private final Rectangle colorRect = new Rectangle(10, 10); 
  //  private final Label descriptionLabel = new Label(); 
    //private final ImageView carIcon = new ImageView(); 
    private final AnchorPane content = new AnchorPane();
   
    
    
     public OffreListeCell() {
         
         PosteLabel.setStyle(" -fx-font-size: 1.5em;"); 
        PosteLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(PosteLabel, 1, 0); 
        // 
        DescriptionLabel.setStyle("-fx-font-size: 1.5em; ");
        DescriptionLabel.setStyle("-fx-font-weight: bold;");
      
        GridPane.setConstraints(DescriptionLabel, 2, 0); 
        // 
        AdresseLabel.setStyle("-fx-font-size: 1.5em;"); 
        AdresseLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(AdresseLabel, 3, 0); 
        // 
        NiveauLabel.setStyle("-fx-font-size: 1.5em; "); 
        NiveauLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(NiveauLabel, 4, 0); 
        // 
        SalaireLabel.setStyle("-fx-font-size: 1.5em; "); 
        SalaireLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(SalaireLabel, 5, 0); 
        // 
       MissionLabel.setStyle("-fx-font-size: 1.5em; "); 
       MissionLabel.setStyle("-fx-font-weight: bold;");
       GridPane.setConstraints(MissionLabel, 6, 0); 
        // 
        
       dateLimiteLabel.setStyle("-fx-font-size: 1.5em;"); 
       dateLimiteLabel.setStyle("-fx-font-weight: bold;");
       GridPane.setConstraints(dateLimiteLabel, 7, 0); 
        // 
        
       // button.setStyle(");
      
        // 
        
        //button2.setStyle("-fx-text-style:bold;-fx-background-color: Red;-fx-border-color: White;");
         
        
       // DescriptionLabel.setStyle("-fx-opacity: 0.75;"); 
      // GridPane.setConstraints(DescriptionLabel, 1, 1); 

       // GridPane.setColumnSpan(this, Integer.MIN_VALUE);
        
      
        //         
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      // gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
      //  gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      //  gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
       // gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
       // gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
       
        gridPane.setHgap(20); 
        gridPane.setVgap(10); 
        gridPane.getChildren().setAll(PosteLabel, DescriptionLabel, AdresseLabel,NiveauLabel,SalaireLabel,MissionLabel,dateLimiteLabel); 
       // AnchorPane.setTopAnchor(gridPane, 0d); 
       // AnchorPane.setLeftAnchor(gridPane, 0d); 
       // AnchorPane.setBottomAnchor(gridPane, 0d); 
       // AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
       
               
        
    }
    // 
        
        
  
  
    @Override 
    protected void updateItem(Offre o, boolean empty) { 
         

        super.updateItem(o, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && o != null) { 
            
           // 
            String s = Float.toString(o.getSalaire());
            Format formatter = new SimpleDateFormat("yyyy-MM-dd ");
            String d = formatter.format(o.getDateFin());
           //
            
            PosteLabel.setText(o.getPosition());   
            DescriptionLabel.setText(o.getDescription()); 
            NiveauLabel.setText(o.getEducation());
            AdresseLabel.setText(o.getAdresse());
            SalaireLabel.setText(s);
            MissionLabel.setText(o.getMission());
            dateLimiteLabel.setText(d);
            
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 

   

    
}