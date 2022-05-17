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
public class DeveloppeurListCell extends ListCell<User>{
    
    private final GridPane gridPane= new GridPane();
    private final Label usernameLabel = new Label();
    private final Label emailLabel = new Label();
    private final Label nomLabel = new Label();
    private final Label prenomLabel = new Label();
    private final Label eductionLabel = new Label();
    private final Label experienceLabel = new Label();
    private final Label bioLabel = new Label();
    private final Label specialiteLabel = new Label();
    private final Label titre1Label = new Label();
    private final Label institut1Label = new Label();
    private final Label periode1Label= new Label();
    private final Label titre2Label = new Label();
    private final Label institut2Label = new Label();
    private final Label periode2Label= new Label();
    private final Label work1Lable= new Label();
    private final Label company1Label= new Label();
    private final Label work2Lable= new Label();
    private final Label company2Label= new Label();
    private final Label qualification1Label= new Label();
    private final Label qualification2Label= new Label();
    private final Label qualification3Label= new Label();
    private final Label qualification4Label= new Label();

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
        
        titre1Label.setStyle(" -fx-font-size: 1.5em;");
        titre1Label.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(titre1Label, 9, 0);
        
        institut1Label.setStyle(" -fx-font-size: 1.5em;");
        institut1Label.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(institut1Label, 10, 0);
        
        periode1Label.setStyle(" -fx-font-size: 1.5em;");
        periode1Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(periode1Label, 11, 0);

        titre2Label.setStyle(" -fx-font-size: 1.5em;");
        titre2Label.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(titre2Label, 12, 0);
        
        institut2Label.setStyle(" -fx-font-size: 1.5em;");
        institut2Label.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(institut2Label, 13, 0);
        
        periode2Label.setStyle(" -fx-font-size: 1.5em;");
        periode2Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(periode2Label, 14, 0);

        work1Lable.setStyle(" -fx-font-size: 1.5em;");
        work1Lable.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(work1Lable, 15, 0);
        
        company1Label.setStyle(" -fx-font-size: 1.5em;");
        company1Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(company1Label, 16, 0);
        
        
        work2Lable.setStyle(" -fx-font-size: 1.5em;");
        work2Lable.setStyle("-fx-font-weight: bold;");
        GridPane.setConstraints(work2Lable, 17, 0);
        
        company2Label.setStyle(" -fx-font-size: 1.5em;");
        company2Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(company2Label, 18, 0);

        qualification1Label.setStyle(" -fx-font-size: 1.5em;");
        qualification1Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(qualification1Label, 19, 0);

        qualification2Label.setStyle(" -fx-font-size: 1.5em;");
        qualification2Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(qualification2Label, 20, 0);

        qualification3Label.setStyle(" -fx-font-size: 1.5em;");
        qualification3Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(qualification3Label, 20, 0);

        qualification4Label.setStyle(" -fx-font-size: 1.5em;");
        qualification4Label.setStyle(" -fx-font-weight: bold;");
        GridPane.setConstraints(qualification4Label, 20, 0);


        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(20); 
        gridPane.setVgap(10); 
        gridPane.getChildren().setAll(usernameLabel,emailLabel,nomLabel,prenomLabel,eductionLabel,experienceLabel,bioLabel,specialiteLabel,titre1Label,institut1Label,periode1Label,titre2Label,institut2Label,periode2Label,work1Lable,company1Label,work2Lable,company2Label,qualification1Label,qualification2Label,qualification3Label,qualification4Label);
        
        content.getChildren().add(gridPane);
        
    }
    
    @Override 
    protected void updateItem(User d, boolean empty) { 
         

        super.updateItem(d, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && d != null) { 
            
           // 
            
           //
            usernameLabel.setText(d.getUsername());
            emailLabel.setText(d.getEmail());   
            nomLabel.setText(d.getName()); 
            prenomLabel.setText(d.getFirstname());
            experienceLabel.setText(d.getExperience());
            eductionLabel.setText(d.getEducation());
            specialiteLabel.setText(d.getSpecialite());
            bioLabel.setText(d.getBio());
            titre1Label.setText(d.getTitre1());
            titre2Label.setText(d.getTitre2());
            institut1Label.setText(d.getInstitut1());
            institut2Label.setText(d.getInstitut2());
            periode1Label.setText(d.getPeriode1());
            periode2Label.setText(d.getPeriode2());
            work1Lable.setText(d.getWork1());
            work2Lable.setText(d.getWork2());
            company1Label.setText(d.getCompany1());
            company2Label.setText(d.getCompany2());
            qualification1Label.setText(d.getQualification1());
            qualification2Label.setText(d.getQualification1());
            qualification3Label.setText(d.getQualification3());
            qualification4Label.setText(d.getQualification4());
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    }
}