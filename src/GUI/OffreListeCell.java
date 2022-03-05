/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Rectangle;
import java.sql.Date;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
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

    private final Rectangle colorRect = new Rectangle(10, 10); 
    private final Label descriptionLabel = new Label(); 
    private final ImageView carIcon = new ImageView(); 
    private final AnchorPane content = new AnchorPane();
    
    
     public OffreListeCell() {
         
         PosteLabel.setStyle(" -fx-font-size: 1.5em;"); 
         PosteLabel.setPrefSize(40, 40);
        GridPane.setConstraints(PosteLabel, 1, 0); 
        // 
        DescriptionLabel.setStyle("-fx-font-size: 1.5em; "); 
        GridPane.setConstraints(DescriptionLabel, 2, 0); 
        // 
        AdresseLabel.setStyle("-fx-font-size: 1.5em; "); 
        GridPane.setConstraints(AdresseLabel, 3, 0); 
        // 
        NiveauLabel.setStyle("-fx-font-size: 1.5em; "); 
        GridPane.setConstraints(NiveauLabel, 4, 0); 
        // 
      //  SalaireLabel.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
       // GridPane.setConstraints(SalaireLabel, 2, 0); 
        // 
       MissionLabel.setStyle("-fx-font-size: 1.5em; "); 
       GridPane.setConstraints(MissionLabel, 5, 0); 
        // 
      //  dateLimiteLabel.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
     //   GridPane.setConstraints(dateLimiteLabel, 2, 0); 
        // 
    
        // 
       // DescriptionLabel.setStyle("-fx-opacity: 0.75;"); 
      // GridPane.setConstraints(DescriptionLabel, 1, 1); 
       // GridPane.setColumnSpan(DescriptionLabel, Integer.MAX_VALUE); 
        //         
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      // gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
      //  gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      //  gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
      //  gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
       // gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
       // gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        gridPane.setHgap(10); 
        gridPane.setVgap(6); 
        gridPane.getChildren().setAll(PosteLabel, DescriptionLabel, AdresseLabel,NiveauLabel,/*SalaireLabel,*/MissionLabel); 
       // AnchorPane.setTopAnchor(gridPane, 0d); 
       // AnchorPane.setLeftAnchor(gridPane, 0d); 
       // AnchorPane.setBottomAnchor(gridPane, 0d); 
       // AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
         
    }
    // 
        Label label = new Label();
            public void changed(ObservableValue<? extends Offre> observable, Offre oldValue, Offre newValue) {
                label.setText("OLD: " + oldValue + ",  NEW: " + newValue);
            }
        
  
  
    @Override 
    protected void updateItem(Offre o, boolean empty) { 
         
       
        
        
        super.updateItem(o, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && o != null) { 
            
            PosteLabel.setText(o.getPosition());   
            DescriptionLabel.setText(o.getDescription()); 
            NiveauLabel.setText(o.getEducation());
            AdresseLabel.setText(o.getAdresse());
            //SalaireLabel.setText(valueOf(o.getSalaire()));
            MissionLabel.setText(o.getMission());
            //dateLimiteLabel.setText(t.getDateFin());
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 

   

    
}