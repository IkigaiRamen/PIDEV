/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.entities.ChoixEntity;
import pidev.entities.QuestionEntity;
import pidev.services.ChoixService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class InputQuestionItemController implements Initializable {

    
    @FXML
    private Label lblNbrQuestion;

    @FXML
    private TextArea  txtEnonce;

    @FXML
    private TextField txtChoix1;

    @FXML
    private TextField txtChoix2;

    @FXML
    private TextField txtChoix3;
    
    private QuestionEntity currentQuestion;
    private List<ChoixEntity> choices; 

    public TextArea getTxtEnonce() {
        return txtEnonce;
    }

    public void setTxtEnonce(TextArea txtEnonce) {
        this.txtEnonce = txtEnonce;
    }

    public TextField getTxtChoix1() {
        return txtChoix1;
    }

    public void setTxtChoix1(TextField txtChoix1) {
        this.txtChoix1 = txtChoix1;
    }

    public TextField getTxtChoix2() {
        return txtChoix2;
    }

    public void setTxtChoix2(TextField txtChoix2) {
        this.txtChoix2 = txtChoix2;
    }

    public TextField getTxtChoix3() {
        return txtChoix3;
    }

    public void setTxtChoix3(TextField txtChoix3) {
        this.txtChoix3 = txtChoix3;
    }

    public QuestionEntity getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionEntity currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<ChoixEntity> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoixEntity> choices) {
        this.choices = choices;
    }
    
    
    
    public void setData(int nbr,QuestionEntity question) {
        
        this.currentQuestion = question;
        txtEnonce.setText(question.getEnonce());
        
        ChoixService cs = new ChoixService();
        choices = cs.getByQuestion(currentQuestion.getIdQuestion()); 
        
        lblNbrQuestion.setText("Question N°" + nbr);
        
        int x = 0;
        txtChoix1.setText(choices.get(x++).getContenu());
        //choix1.setId(String.valueOf(listChoix.get(x).getIdChoix()));

        txtChoix2.setText(choices.get(x++).getContenu());
        
        txtChoix3.setText(choices.get(x++).getContenu());
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
