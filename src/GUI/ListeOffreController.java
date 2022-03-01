/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pidev.entities.Offre;
import pidev.services.OffreServices;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class ListeOffreController implements Initializable {

    @FXML
    private TableView<Offre> table;

    @FXML
    private TableColumn<Offre, Integer> id;

    @FXML
    private TableColumn<Offre, String> Poste;

    @FXML
    private TableColumn<Offre, String> Description;
    
    @FXML
    private TableColumn<Offre, String> Condition;
    
    @FXML
    private TableColumn<Offre, String> Adresse;
    
    @FXML
    private TableColumn<Offre, Float> Salaire;
    
    @FXML
    private TableColumn<Offre, String> Mission;
    
    @FXML
    private TableColumn<Offre, String> Niveau;
    
    @FXML
    private TableColumn<Offre, String> Datefin;
    @FXML
    private Button ajouteroffre;
    @FXML
    private Button mod;
    
    private static Offre OF;
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // OffreServices os= new OffreServices(); 
       // ArrayList<Offre> exm= new ArrayList<Offre>();
        //try {
           // exm = (ArrayList<Offre>) os.redALL();
       // } catch (SQLException OF) {
           // Logger.getLogger(AjouterOffreController.class.getName()).log(Level.SEVERE, null, OF);
       // }
    
    }    
    
    @FXML
    private void ajouteoffre(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
    }
    @FXML
    private void modifierOffre(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifierOffre.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
    }
    
    
    
}
