/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Rectangle;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import pidev.entities.TestEntity;

/**
 *
 * @author zewaf
 */
public class CellGestionCertification extends ListCell<TestEntity> {
    private final GridPane gridPane = new GridPane(); 
    private final Label lblTitre = new Label(); 
    private final Label lblDuree = new Label(); 
    private final Label lblTentative = new Label(); 
    private final Label lblDateCreation = new Label(); 
    private final Rectangle colorRect = new Rectangle(10, 10); 
    
    private final ImageView carIcon = new ImageView(); 
    private final AnchorPane content = new AnchorPane(); 
    private TestEntity currentSelected;
    public CellGestionCertification() { 
       
        // 
       

        lblTitre.setStyle("-fx-font-style: italic; -fx-font-size: 1.5em;"); 
        lblTitre.setAlignment(Pos.CENTER_LEFT);
        lblTitre.setTextAlignment(TextAlignment.LEFT);
        lblTitre.setWrapText(true);
        GridPane.setConstraints(lblTitre, 0, 0); 
        // 
        lblDuree.setStyle("-fx-font-size: 1.2em; -fx-font-style: italic; -fx-opacity: 1;"); 
        lblDuree.setTextFill(Paint.valueOf("White"));
        GridPane.setConstraints(lblDuree, 2, 0); 
        // 
    
        // 
        lblTentative.setStyle("-fx-font-size: 1.2em; -fx-opacity: 1;");
        lblTentative.setTextFill(Paint.valueOf("White"));
        GridPane.setConstraints(lblTentative, 3, 0); 
        lblDateCreation.setStyle("-fx-font-size: 1.2em; -fx-opacity: 1;");
        lblDateCreation.setTextFill(Paint.valueOf("White"));
        GridPane.setConstraints(lblDateCreation, 4, 0); 
        /*descriptionLabel.setStyle("-fx-opacity: 0.75;"); 
       GridPane.setConstraints(descriptionLabel, 2,1); */
   
        
        //         
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setMaxWidth(200);
        cc1.setMinWidth(200);
        cc1.setPrefWidth(USE_PREF_SIZE);
        gridPane.getColumnConstraints().add(cc1);
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setMaxWidth(200);
        cc2.setMinWidth(200);
        ColumnConstraints cc3 = new ColumnConstraints();
        cc3.setMaxWidth(200);
        cc3.setMinWidth(200);
        ColumnConstraints cc4 = new ColumnConstraints();
        cc4.setMaxWidth(200);
        cc4.setMinWidth(200);
        gridPane.getColumnConstraints().add(cc1);
        gridPane.getColumnConstraints().add(cc2);
        gridPane.getColumnConstraints().add(cc3);
        gridPane.getColumnConstraints().add(cc4);

        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        gridPane.setHgap(6); 
        gridPane.setVgap(6); 
        gridPane.getChildren().setAll(lblTitre,lblDuree,lblTentative,lblDateCreation); 
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
        
    } 
  
  
    @Override 
    protected void updateItem(TestEntity t, boolean empty) { 
         currentSelected = t;
        super.updateItem(t, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && t != null) { 
            
            lblTitre.setText(t.getTitre()); 
            lblDuree.setText(String.valueOf(t.getDuree())); 
            lblTentative.setText(String.valueOf(t.getNbrTentative())); 
            lblDateCreation.setText(t.getDateCreation().toString());
            
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
    
}