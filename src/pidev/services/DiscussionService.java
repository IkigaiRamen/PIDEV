/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import pidev.Connexion;
import pidev.entities.Discussion;
import pidev.entities.Message;

/**
 *
 * @author khoualdi koussay
 */
public class DiscussionService {
          @FXML
    private VBox vbox_messages;
            Connection mc;
    PreparedStatement ste;
/*
    public void getMessages(){
     try
        {
          Statement selectStmt = mc.createStatement();
            ResultSet rs = selectStmt
             .executeQuery("select * from message where idD=107");
            System.out.println("zqehfoqzeh");
          
             
        }
        catch (SQLException ex) {
           //System.out.println(ex.getMessage());
            
        }

    
    }*/
    public DiscussionService() {
         mc=Connexion.getInstance().getMyConnection();
    }
    public  void creerDiscussion(Discussion dis)
    { 
        
        try
        {
         String sql ="insert into discussion(idEmployeur ,idDeveloppeur ) values(?,?) ";
            System.out.println(dis.getIdDev());
                        System.out.println(dis.getIdEmp());

           ste=mc.prepareStatement(sql);
           ste.setInt(1,dis.getIdEmp());
           ste.setInt( 2,dis.getIdDev());
           ste.executeUpdate();
          
             
        }
        catch (SQLException ex) {
           System.out.println(ex.getMessage());
            
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
                   List<String> ls = new ArrayList<>();
                   public void showDiscussion(int i){
                        
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

    
        public void supprimerDiscussion(int id){
        String sql = "DELETE from message where id_discussion= '"+id+"' "; 
        try{
           Statement st= mc.createStatement();
           st.executeUpdate(sql);
           System.out.println("Discussion supprimée avec succés !");
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
