/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import pidev.entities.TestEntity;
import pidev.services.TestService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class AjouterCertificationController implements Initializable {

    
    @FXML
    private ScrollPane paneAjouterTest;

    @FXML
    private Label lblTitre;

    @FXML
    private Label lblNbrTentative;

    @FXML
    private Label lblduree;

    @FXML
    private TextField txtTitre;

    @FXML
    private TextField txtNbrTentative;

    @FXML
    private TextField txtDuree;
    
    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrecedent;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /////////////////////////////////////////////////listener for numeric textfield////////////////////////////////////////////////
        
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) { 
                return change;
            }
            return null;
        };

    txtNbrTentative.setTextFormatter(
        new TextFormatter<>(new IntegerStringConverter(), 0, integerFilter));
    txtDuree.setTextFormatter(
        new TextFormatter<>(new IntegerStringConverter(), 0, integerFilter));
    }

    @FXML
    void goToCreateQuestions(ActionEvent event) {
        List<TextField> tfl = Arrays.asList(txtTitre,txtDuree,txtNbrTentative) ;
        int j = 0;
        boolean verified = true;
        while(j<3 && verified)
        {
            String ch = tfl.get(j).getText();
            if(ch.equals("") || ch.equals("0")){
                verified = false;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText("Vérifier les données saisies svp");
                alert.setContentText("Attention tout les champs de saisie sont obligatoires");

                Optional<ButtonType> result = alert.showAndWait();
            }
            j++;
        }
        if(verified){
            TestService ts = new TestService();
            TestEntity t2 = new TestEntity();
            //t2.setUserId(CURRENT_USER);///////to add later
            t2.setType("Certification");
            t2.setDuree(Integer.parseInt(txtDuree.getText()));
            t2.setNbrTentative(Integer.parseInt(txtNbrTentative.getText()));
            t2.setTitre(txtTitre.getText());
            Integer insertedId = ts.ajouterTest(t2);
            t2.setIdTest(insertedId);
            
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterQuestions.fxml"));
                Parent root = loader.load();
                AjouterQuestionsController questionsController = loader.getController();
                questionsController.setCurrentTestEntity(t2);
                //System.out.println(questionsController.getCurrentTestEntity().toString());
                lblTitre.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
               
        
        
    }
    @FXML
    void backToListTest(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionCertification.fxml"));
            Parent root;
        try {
            root = loader.load();
            lblTitre.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void cleanTxtField(MouseEvent event) {
        TextField e = (TextField)event.getSource();
        if(e.getText().equals("0"))
            e.setText("");
        

    }    
    
}
