/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;

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
import pidev.entities.User;


/**
 *
 * @author eya
 */
public class EmployeursListCell extends ListCell<User> {
     
    private final GridPane gridPane= new GridPane();
    private final Label usernameLabel = new Label();
    private final Label emailLabel = new Label();
    private final Label nomLabel = new Label();
    private final Label prenomLabel = new Label();
    private final Label professionLabel = new Label();
    private final Label nomSocieteLabel= new Label();
    private final Label siteWebLabel= new Label();

    private final AnchorPane content = new AnchorPane();
    
    public EmployeursListCell(){
        
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
        
        nomSocieteLabel.setStyle(" -fx-font-size: 1.5em;");
        nomSocieteLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(nomSocieteLabel, 5, 0);
        
        professionLabel.setStyle(" -fx-font-size: 1.5em;");
        professionLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(professionLabel, 6, 0);
        
        siteWebLabel.setStyle(" -fx-font-size: 1.5em;");
        siteWebLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(siteWebLabel, 6, 0);
        
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(20); 
        gridPane.setVgap(10); 
        gridPane.getChildren().setAll(usernameLabel,emailLabel,nomLabel,prenomLabel,nomSocieteLabel,professionLabel,siteWebLabel);
        
        content.getChildren().add(gridPane);
        
    }
    
    @Override 
    protected void updateItem(User e, boolean empty) { 
         

        super.updateItem(e, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && e != null) { 
            
           // 
            
           //
            usernameLabel.setText(e.getUsername());
            emailLabel.setText(e.getEmail());   
            nomLabel.setText(e.getName()); 
            prenomLabel.setText(e.getFirstname());
            nomSocieteLabel.setText(e.getSociete());
            professionLabel.setText(e.getProfession());
            siteWebLabel.setText(e.getSiteWeb());
            
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    }
    
}
