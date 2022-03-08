/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import static java.awt.Color.red;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.*;  
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import pidev.entities.Discussion;
import pidev.entities.Message;
import pidev.services.DiscussionService;
import pidev.services.MessageService;
import javafx.scene.text.Text; 
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author khoualdi koussay
 */
public class ChatController implements Initializable {
  @FXML
    private TextField Contenu;
    @FXML
    private Button send;
       @FXML
    private VBox vbox_messages;
          @FXML
    private ScrollPane sp_main ;
    private  Date dateCreation = null ;
  Connection mc;
    PreparedStatement ste;
   

         Discussion d = new Discussion (1,dateCreation);
         
        DiscussionService ds = new DiscussionService();
    @FXML
    private AnchorPane ap_main;
    @FXML
    private TextFlow txtflow;
    @FXML
    private Label txtflowlabel;
        @Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ds.creerDiscussion(d);
                     Text text=new Text();
              String test;

         try{  
              Class.forName("com.mysql.jdbc.Driver");  
              Connection con=DriverManager.getConnection(  
              "jdbc:mysql://localhost:3306/pidev","root","");  
           
              Statement stmt=con.createStatement();  
              ResultSet rs=stmt.executeQuery("select * from message");
              while(rs.next()){
                  HBox hbox = new HBox();
                  hbox.setAlignment(Pos.CENTER_RIGHT);
                  hbox.setPadding(new Insets(5,5,5,10));
             System.out.println(rs.getInt(1)+"  "+rs.getString(3)); 
             Text text2=new Text(rs.getString(3));
             
            // txtflow.getChildren().add(text2);
           // txtflow.setStyle("-fx-color: rgb(239,242,255");
            txtflow.setPadding(new Insets(5,10,5,10));
            text2.setFill(Color.color(0.934,0.945,0.996));
            hbox.getChildren().add(txtflow);
            vbox_messages.getChildren().add(text2);
         }

              
        
   
               send.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event){
                 String messageToSend =Contenu.getText();
                 if(!messageToSend.isEmpty()){
                     
                     Text text = new Text(messageToSend);
                    
                     TextFlow textflow = new TextFlow();
                     sp_main.setContent(txtflow);
                     
                     
                     textflow.setStyle("-fx-font-weight: bold;");
                    /* textflow.setStyle("-fx-color : rgb (239,242,255)"+
                             "-fx-background-color : rgb(15,125,242)" +
                             "-fx-background-radius:20px"
                             );*/
                     Contenu.clear();
                 }
                 
             }
         });
            
              while(rs.next())  {
                   System.out.println(rs.getInt(1)+"  "+rs.getString(3));  


                  }  con.close();
                        
                   }
         
         
         catch(Exception e){ System.out.println(e);}  

         
              }  
         
         
  
    



    

    @FXML
    private void creerMessage(ActionEvent event) {
      
 
          String contenu = Contenu.getText();
          Message m = new Message (contenu,d);
          
          MessageService ms = new MessageService();
          ms.creerMessage(m);           
    
                 if(!contenu.isEmpty()){
                     
                     Text text = new Text(contenu);
                     
                     txtflow.getChildren().add(text);
                     txtflowlabel.setText(contenu);
                     sp_main.setContent(txtflow);

                     
                     txtflow.setStyle("-fx-color: rgb (239,242,255)");
                       txtflow.setStyle("-fx-background-color: rgb(15,125,242)");
                         txtflow.setStyle("-fx-background-radius:20px");
           
                     txtflow.setPadding(new Insets(5,10,5,10));
                     text.setFill(Color.color(0.934,0.945,0.996));
                     Contenu.clear();
                 }


        
    }


    
}
