/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Khammessi
 */
public class GestionDemandeController implements Initializable {

    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button planning;
    @FXML
    private Label imagePath;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> qte;
    @FXML
    private TableColumn<?, ?> total;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prix;
    @FXML
    private Button tfModifier;
    @FXML
    private Button tfSupprimer;
    @FXML
    private Button export;
    @FXML
    private Button user;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
