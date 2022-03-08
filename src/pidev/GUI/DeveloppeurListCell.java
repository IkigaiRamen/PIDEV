/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.text.Format;
import java.text.SimpleDateFormat;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import pidev.entities.Developpeur;
import pidev.entities.Offre;


/**
 *
 * @author eya
 */
public class DeveloppeurListCell extends ListCell<Developpeur>{
    
    private final GridPane gridPane= new GridPane();
    private final Label usernameLabel = new Label();
    private final Label emailLabel = new Label();
    private final Label nomLabel = new Label();
    private final Label prenomLabel = new Label();
    private final Label eductionLabel = new Label();
    private final Label experienceLabel = new Label();
    private final Label bioLabel = new Label();
    private final Label specialiteLabel = new Label();
    
    private final AnchorPane content = new AnchorPane();
    
    public DeveloppeurListCell(){
        
        usernameLabel.setStyle(" -fx-font-size: 1.5em;");
        usernameLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(usernameLabel, 1, 0);
        
        emailLabel.setStyle(" -fx-font-size: 1.5em;");
        emailLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(emailLabel, 2, 0);
        
        nomLabel.setStyle(" -fx-font-size: 1.5em;");
        nomLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(nomLabel, 3, 0);
        
        prenomLabel.setStyle(" -fx-font-size: 1.5em;");
        prenomLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(prenomLabel, 4, 0);
        
        eductionLabel.setStyle(" -fx-font-size: 1.5em;");
        eductionLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(eductionLabel, 5, 0);
        
        experienceLabel.setStyle(" -fx-font-size: 1.5em;");
        experienceLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(experienceLabel, 6, 0);
        
        bioLabel.setStyle(" -fx-font-size: 1.5em;");
        bioLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(bioLabel, 7, 0);
        
        specialiteLabel.setStyle(" -fx-font-size: 1.5em;");
        specialiteLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(specialiteLabel, 8, 0);
        
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(20); 
        gridPane.setVgap(10); 
        gridPane.getChildren().setAll(usernameLabel,emailLabel,nomLabel,prenomLabel,eductionLabel,experienceLabel,bioLabel,specialiteLabel);
        
        content.getChildren().add(gridPane);
        
    }
    
    @Override 
    protected void updateItem(Developpeur d, boolean empty) { 
         

        super.updateItem(d, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && d != null) { 
            
           // 
            
           //
            usernameLabel.setText(d.getUserName());
            emailLabel.setText(d.getEmail());   
            nomLabel.setText(d.getNom()); 
            prenomLabel.setText(d.getPrenom());
            experienceLabel.setText(d.getExperience());
            eductionLabel.setText(d.getEducation());
            specialiteLabel.setText(d.getSpecialite());
            bioLabel.setText(d.getBio());
            
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    }
}