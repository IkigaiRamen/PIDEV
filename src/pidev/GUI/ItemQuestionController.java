/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;


import java.net.URL;
import java.util.List;
import java.util.Random;
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

    public RadioButton getChoix1() {
        return choix1;
    }

    public void setChoix1(RadioButton choix1) {
        this.choix1 = choix1;
    }

    public ToggleGroup getChoix() {
        return choix;
    }

    public void setChoix(ToggleGroup choix) {
        this.choix = choix;
    }

    public RadioButton getChoix2() {
        return choix2;
    }

    public void setChoix2(RadioButton choix2) {
        this.choix2 = choix2;
    }

    public RadioButton getChoix3() {
        return choix3;
    }

    public void setChoix3(RadioButton choix3) {
        this.choix3 = choix3;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
    
    
    public void setItem(int nbr,QuestionEntity question,List<ChoixEntity> listChoix){
        
        this.question = question;
        lblEnonce.setText(question.getEnonce());
        lblNbrQuestion.setText("Question N°" + nbr);
        Random r = new Random();
        int x = r.nextInt(3);
        
        choix1.setText(listChoix.get(x).getContenu());
        choix1.setId(String.valueOf(listChoix.get(x).getIdChoix()));
        listChoix.remove(x);
        x = r.nextInt(2);
        choix2.setText(listChoix.get(x).getContenu());
        choix2.setId(String.valueOf(listChoix.get(x).getIdChoix()));
        listChoix.remove(x);
        x = 0;
        choix3.setText(listChoix.get(x).getContenu());
        choix3.setId(String.valueOf(listChoix.get(x).getIdChoix()));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
