/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import static java.lang.StrictMath.random;
import java.net.URL;
import java.util.List;
import  java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import pidev.entities.ChoixEntity;
import pidev.entities.QuestionEntity;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class ItemQuestionController implements Initializable {

    
    @FXML
    private Label lblEnonce;

    @FXML
    private Label lblNbrQuestion;
    
    @FXML
    private RadioButton choix1;

    @FXML
    private ToggleGroup choix;

    @FXML
    private RadioButton choix2;

    @FXML
    private RadioButton choix3;
    
    private QuestionEntity question;
    private List<ChoixEntity> choices;
    public void setItem(int nbr,QuestionEntity question,List<ChoixEntity> listChoix){
        
        this.question = question;
        lblEnonce.setText(question.getEnonce());
        lblNbrQuestion.setText("Question N°" + nbr);
        //int r = Random.nextInt(2) ; //randomize order of choices
        choix1.setText(listChoix.get(0).getContenu());
        choix2.setText(listChoix.get(1).getContenu());
        choix3.setText(listChoix.get(2).getContenu());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
