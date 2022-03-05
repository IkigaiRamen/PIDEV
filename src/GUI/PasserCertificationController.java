/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pidev.entities.ChoixEntity;
import pidev.entities.QuestionEntity;
import pidev.entities.TestEntity;
import pidev.services.ChoixService;
import pidev.services.QuestionService;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class PasserCertificationController implements Initializable {

    
    @FXML
    private Label lblTimer;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;
    
    @FXML
    private Label lblTitre;
    
    @FXML
    private TestEntity currentTestEntity;
    
    QuestionService qs = new QuestionService();
    ObservableList<QuestionEntity> questions ;
    //ObservableList<QuestionEntity> questions = FXCollections.observableList(ts.getAllTest());

    public void setQuestions(int testId) {
        this.questions = FXCollections.observableList(qs.getbyTest(currentTestEntity.getIdTest()));
        System.out.println(questions.toString());

    }
    
    
    //////////timer//////// methods and attributs
    private int m;
    private int s = 60;
    Timer timer;
            
    private StringProperty stringTimer = new SimpleStringProperty();

    //getter & setter
    public TestEntity getCurrentTestEntity() {
        return currentTestEntity;
    }

    public void setCurrentTestEntity(TestEntity currentTestEntity) {
        this.currentTestEntity = currentTestEntity;
        lblTitre.setText("Test de certification en " + currentTestEntity.getTitre());
        QuestionService qs = new QuestionService();
        questions = FXCollections.observableList(qs.getbyTest(currentTestEntity.getIdTest()));
        int column = 0;
        int row = 0;
        
        try {
            if(questions != null)
            for(int i=0; i<questions.size(); i++){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ItemQuestion.fxml"));
                AnchorPane item = loader.load();
                ItemQuestionController itemController = loader.getController();
                ChoixService cs = new ChoixService();
                List<ChoixEntity> listChoix = cs.getByQuestion(questions.get(i).getIdQuestion());
                
                itemController.setItem(i,questions.get(i),listChoix); //instead of i i+1
                //System.out.println(questionsController.getCurrentTestEntity().toString());
                grid.add(item, column, row++);
                GridPane.setMargin(item, new Insets(10));
            }
                
        } catch (IOException ex) {
            Logger.getLogger(GestionCertificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setM(int m) {
        this.m = m;
    }
    
    
    class Helper extends TimerTask {

    // TimerTask.run() method will be used to perform the action of the task
     
    public void run() {
        String time;
        if (m >= 0) {
            if(m == currentTestEntity.getDuree())
                m -= 1;
            
            if(s>0)
                s-= 1;
            else{
                s = 59;
                m -=1;
                if(m == -1){
                    tempsFini();
                }
            }
            time = m + ":" + s;
            
            if(s<10)
                time = m + ":0" + s;
            if(m<10)
                time = "0" + time;
            
            final String timeFinal = time;
            Platform.runLater(() -> stringTimer.setValue(timeFinal) );
            //lblTimer.setText( m + ":" + s);
            //System.out.println(m + ":" + s);
            
        }    
    }
    
    
}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        //questions = FXCollections.observableList(qs.getbyTest(currentTestEntity.getIdTest()));
        //System.out.println(questions.toString());
        
        //timer
        lblTimer.textProperty().bind(stringTimer);
        timer = new Timer();
        TimerTask task = new Helper();
        timer.schedule(task, 1000, 1000);
    }   
    
    public void tempsFini(){
        timer.cancel();
        //go to result page
    }
    @FXML
    public void finish(ActionEvent event){
        tempsFini();
    }
    
}
