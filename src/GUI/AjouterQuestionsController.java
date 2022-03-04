/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.entities.QuestionEntity;
import pidev.entities.ChoixEntity;
import pidev.entities.TestEntity;
import pidev.services.QuestionService;
import pidev.services.ChoixService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class AjouterQuestionsController implements Initializable {

    @FXML
    private TestEntity currentTestEntity;

    @FXML
    private ScrollPane paneAjouterQuestions;

    @FXML
    private TextArea txtEnonce;

    @FXML
    private TextField txtChoix1;

    @FXML
    private TextField txtChoix2;

    @FXML
    private TextField txtChoix3;

    @FXML
    private Button btnTerminer;

    @FXML
    private Button btnAjouter;

    

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(currentTestEntity == null);
    }
    //getter & setter
    public TestEntity getCurrentTestEntity() {
        return currentTestEntity;
    }

    public void setCurrentTestEntity(TestEntity currentTestEntity) {
        this.currentTestEntity = currentTestEntity;
    }
    //////////////////////Button methods////////////////////
    @FXML
    void addAndClear(ActionEvent event) {
        final String choix1 =  txtChoix1.getText();
        final String choix2 = txtChoix2.getText();
        final String choix3 = txtChoix3.getText();
        final String enonce = txtEnonce.getText();
        
        if(enonce.isEmpty() ||choix1.isEmpty() || choix2.isEmpty() || choix3.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attention");
                alert.setHeaderText("Vérifier les données saisies svp");
                alert.setContentText("Attention tout les champs de saisie sont obligatoires");

                Optional<ButtonType> result = alert.showAndWait();
        }else{
            //ajout enonce
            QuestionEntity q = new QuestionEntity();
            q.setEnonce(enonce);
            q.setIdTest(currentTestEntity.getIdTest());
            QuestionService qs = new QuestionService();
            Integer currentQuestionId = qs.ajouterQuestion(q);
            
            //ajout choix1
            ChoixEntity c = new ChoixEntity();
            c.setContenu(choix1);
            c.setCorrect(true);
            c.setIdQuestion(currentQuestionId);
            ChoixService cs = new ChoixService();
            cs.ajouterChoix(c);
            
           //ajout choix2
            c.setContenu(choix2);
            c.setCorrect(false);
            cs.ajouterChoix(c);
            
            //ajout choix3
            c.setContenu(choix3);
            c.setCorrect(false);
            cs.ajouterChoix(c);
            
            //clear txtfields
            txtEnonce.setText("");
            txtChoix1.setText("");
            txtChoix2.setText("");
            txtChoix3.setText("");
            
            //Enable Button terminer
            if(btnAjouter.isDisabled())
                btnAjouter.setDisable(false);
        }
    }

    @FXML
    void terminerCreation(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/GestionCertification.fxml"));
                Parent root = loader.load();
                GestionCertificationController gestionCertificationController = loader.getController();
                //System.out.println(questionsController.getCurrentTestEntity().toString());
                btnTerminer.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
 
    
}
