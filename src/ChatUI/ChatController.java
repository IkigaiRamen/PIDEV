/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import static java.awt.Color.red;
import static java.awt.SystemColor.text;
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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Box;
import pidev.entities.Discussion;
import pidev.entities.Message;
import pidev.services.DiscussionService;
import pidev.services.MessageService;
import javafx.scene.text.Text; 
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import pidev.entities.UserSession;
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
    private  Date dateCreation = null ;
  Connection mc;
    PreparedStatement ste;
    Text text2;
    ResultSet Rstest;
   

        private Discussion currentDiscussion  ;
         public void setDiscussion(Discussion d){
             this.currentDiscussion = d;
         }
        DiscussionService ds = new DiscussionService();
                  List<String> ls = new ArrayList<>();
    @FXML
    private AnchorPane ap_main;

        @Override
        
        public void initialize(URL url, ResourceBundle rb) {
          // TODO
          
          try{
          
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/pidev","root","");
          
          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("select * from message");
          while(rs.next()){
              ls.add(rs.getString(3));

          }}
          catch(Exception ex){
                  System.out.println(ex.getMessage());
                  }

          for (int j=0;j<ls.size();j++){
          
             fillFlow(j);
          
          }


                        
                   }
      
         
        
        private void fillFlow(int id){
        
                      HBox hbox = new HBox();
                      hbox.setAlignment(Pos.CENTER_LEFT);
                      hbox.setPadding(new Insets(5, 5, 5, 10));
                      Text text=new Text();
                      text.setText(ls.get(id));
                      //System.out.println(ls.get(id));
                      TextFlow textflow;
                      textflow = new TextFlow(text);
                      textflow.setStyle("-fx-color : rgb (0,0,255);-fx-background-color : rgb(192,192,192);-fx-background-radius:10px ");
                     
                      
                      textflow.setPadding(new Insets(5,10,5,10));
                      text.setFill(Color.color(0.121,0.17,0.17));
                      hbox.getChildren().add(textflow);
                      //hbox.setStyle("-fx-background-color : rgb(15,125,242)" );
                      vbox_messages.getChildren().add(hbox);
                      
        }
         
       @FXML
    private void creerMessage(ActionEvent event) {
       
 
          String contenu = Contenu.getText();
          Message m = new Message (contenu,currentDiscussion,UserSession.id);
          
          
          MessageService ms = new MessageService();
          ms.creerMessage(m);
          /////////////////////////////////////
          
                                HBox hbox = new HBox();
                      hbox.setAlignment(Pos.CENTER_RIGHT);
                      hbox.setPadding(new Insets(5, 5, 5, 10));
                      Text text=new Text();
                      text.setText(m.getContenu());
                      //System.out.println(ls.get(id));
                      TextFlow textflow;
                      
                      textflow = new TextFlow(text);
                      textflow.setStyle("-fx-color : rgb (0,0,255);-fx-background-color : rgb(15,125,242);-fx-background-radius:10px ");
                      textflow.setPadding(new Insets(5,10,5,10));
                      text.setFill(Color.color(0.121,0.17,0.17));
                      hbox.getChildren().add(textflow);
                      vbox_messages.getChildren().add(hbox);
       
          Contenu.clear();


        
    }


    
}


         
          
         
  
    



    

    