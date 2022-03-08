/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pidev.entities.ChoixEntity;
import pidev.entities.QuestionEntity;
import pidev.entities.TestEntity;
import pidev.services.ChoixService;
import pidev.services.QuestionService;
import pidev.services.TestService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class ModifierCertificationController implements Initializable {

    @FXML
    private Button btn_Acceuil;

    @FXML
    private Button btn_Messagerie;

    @FXML
    private Button btn_Profile;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btn_listOffre;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private GridPane grid;

    @FXML
    private Button finish;

    @FXML
    private Label lblTitre;

    @FXML
    void finish(ActionEvent event) {
        for(int i=0; i<listItemController.size();i++)
        {
            // update question
            QuestionEntity q = questions.get(i);
            q.setEnonce(listItemController.get(i).getTxtEnonce().getText());
            QuestionService qs = new QuestionService();
            qs.ModifierQuestion(q);
            
            List<ChoixEntity> choices = listItemController.get(i).getChoices();
            
            choices.get(0).setContenu(listItemController.get(i).getTxtChoix1().getText());
            choices.get(1).setContenu(listItemController.get(i).getTxtChoix2().getText());
            choices.get(2).setContenu(listItemController.get(i).getTxtChoix3().getText());
            
            ChoixService cs = new ChoixService();
            for(int j=0; j<choices.size();j++)
            {
                //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa" + choices.get(j).toString());
                cs.ModifierChoix(choices.get(j));
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListCertification.fxml"));
            Parent root;
            try {
                root = loader.load();
                
                lblTitre.getScene().setRoot(root);
                
            } catch (IOException ex) {
                Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    private TestEntity currentSelected;
    private List<QuestionEntity> questions;
    List<InputQuestionItemController> listItemController = new ArrayList();
    List<ChoixEntity> allChoix = new ArrayList();       

    
    public void setData(TestEntity currentSelected) {
        this.currentSelected = currentSelected;
        QuestionService qs = new QuestionService();
        questions = FXCollections.observableList(qs.getbyTest(currentSelected.getIdTest()));
        
        lblTitre.setText("Modifier certification : " + currentSelected.getTitre());
        int column = 0;
        int row = 1;
        
        try {
            if(questions != null)
            for(int i=0; i<questions.size(); i++){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("InputQuestionItem.fxml"));
                AnchorPane item = loader.load();
                InputQuestionItemController itemController = loader.getController();
                ChoixService cs = new ChoixService();
                List<ChoixEntity> listChoix = cs.getByQuestion(questions.get(i).getIdQuestion());
                
                allChoix.addAll(listChoix);
                //System.out.println(allChoix.toString());
                itemController.setData(i+1,questions.get(i)); //instead of i i+1
                //System.out.println(questionsController.getCurrentTestEntity().toString());
                //////
                listItemController.add(itemController);
                grid.add(item, column, row++);
                GridPane.setMargin(item, new Insets(10));
            }
                
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
