/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import pidev.entities.TestEntity;

/**
 * FXML Controller class
 *
 * @author zewaf
 */
public class PasserCertificationController implements Initializable {

    
    @FXML
    private Label lblTimer;
    
    @FXML
    private TestEntity currentTestEntity;
    
    private int m;
    private int s = 17;
    Timer timer;
            
    private StringProperty stringTimer = new SimpleStringProperty();

    //getter & setter
    public TestEntity getCurrentTestEntity() {
        return currentTestEntity;
    }

    public void setCurrentTestEntity(TestEntity currentTestEntity) {
        this.currentTestEntity = currentTestEntity;
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
        lblTimer.textProperty().bind(stringTimer);
        timer = new Timer();
         
        // Helper class extends TimerTask
        TimerTask task = new Helper();
        
         
        timer.schedule(task, 1000, 1000);
    }   
    
    public void tempsFini(){
        timer.cancel();
        //go to result page
    }
    
}
