/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class ResultCertifController implements Initializable {
    
    @FXML
    private ImageView image;

    @FXML
    private Label lblMessage;
    @FXML
    private Label lblMessage2;

    @FXML
    private Button btnLeave;

    
    
    private int score,nbrQuestion;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNbrQuestion() {
        return nbrQuestion;
    }

    public void setNbrquestion(int nbrquestion) {
        this.nbrQuestion = nbrquestion;
    }
    public void setData(int score,int nbrQuestion){
        this.score = score;
        this.nbrQuestion = nbrQuestion;
        if(score > nbrQuestion-3)
        {
            this.image.setImage(new Image(getClass().getResource("..\\images\\checkmark.png").toString()));
            lblMessage.setText("Le succès va à ceux qui osent et agissent, va rarement aux timides. ~ Jawaharalal Nehru");
            lblMessage2.setText("Felicitation Vous avez Réussi, \n votre score est : " + score + "/" + nbrQuestion);
        }else{
            lblMessage.setText("Une personne qui n’a jamais fait d’erreur n’a jamais rien essayé de nouveau. ~ Albert Einstein");
            lblMessage2.setText("Malheureusement Vous n'avez pas Réussi, \n votre score est : " + score + "/" + nbrQuestion);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

@FXML
    void goMain(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CertificationList.fxml"));
            Parent root;
            try {
                root = loader.load();
                image.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    
}
