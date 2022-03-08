/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import pidev.entities.Offre;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class LesOffresController implements Initializable {
   @FXML
    private HBox pnItems;
    public static int x;
    OffreServices os = new OffreServices();
    public static Offre d ;
    ObservableList<Offre> list = FXCollections.observableArrayList(os.afficherOffre());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
                
                final int j = i;
                x=i;
                
                nodes[i] = FXMLLoader.load(getClass().getResource("/GUI/ItemOffre.fxml"));
                    
                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #CAC4C3");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : grey");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
       
        // TODO
            //System.err.println("its a test");
    }    
    
}
    public int returnX(){
    return x;
    }
    
    
}
